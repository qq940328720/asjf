package com.aishang.asjf.client.mallserver;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.request.MallRequest;
import com.aishang.asjf.client.mallserver.request.PayMonthRequest;
import com.aishang.asjf.client.mallserver.response.*;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by mx on 17-11-22.
 */
@Component
public class CommodityClient {

    @Value("${server.mall.manager.root}")
    private String mallRootUrl;//商品服务地址

    @Value("${server.product.manager.root}")
    private String productRootUrl;//产品服务地址

    @Value("${sever.product.stages.plan.url}")
    private String tagesPlanUrl;//分期方案

    @Value("${server.order.manager.root}")
    private String orderUrl;//订单系统

    @Value("${sever.commodity.url}")
    private String commodityUrl;//选择商品

    @Value("${sever.mall.dictionary.url}")
    private String mallDictUrl;//选择商品

    @Value("${sever.mall.info.url}")
    private String mallInfo;//选择商品

    @Value("${sever.pay.month.url}")
    private String payMonthUrl;//计算月供

    @Value("${server.mall.byCode.url}")
    private String mallByCodeUrl;//根据是商品code查询商品信息

    private static final Logger LOGGER = LoggerFactory.getLogger(CommodityClient.class);

    /**
     * 选择商品
     *
     * @param request
     * @return
     * @throws IOException
     */
    public MallResponseWrapper selectMall(MallRequest request) throws IOException {
        LOGGER.info("选择商品开始：{}", request);
        MallResponseWrapper responseWrapper = new MallResponseWrapper();
        String url = mallRootUrl + commodityUrl + "?level1Name=" + request.getLevel1Name() + "&&level2Name=" + request.getLevel2Name() + "&&level3Name=" + request.getLevel3Name() + "&&commodityName=" + request.getCommodityName() + "&&sort=" + request.getSort() + "&&page=" + request.getOffset() + "&&size=" + request.getLimit();
        LOGGER.debug("url:{}", url);
        String string = MyRestTemplate.getInstace().getForObject(url, String.class);
        MallResponse mallResponse = MyObjectMapper.getInstance().readValue(string, MallResponse.class);
        if (mallResponse.isSuccess() && mallResponse.isExecuted()) {
            responseWrapper.setData(mallResponse.getList());
            if(null == mallResponse.getTotal()){
                responseWrapper.setTotal(0);
            }
            responseWrapper.setTotal(mallResponse.getTotal());
            responseWrapper.setSuccess(true);
        } else {
            responseWrapper.setTotal(0);
            responseWrapper.setSuccess(false);
            return responseWrapper;
        }
        LOGGER.info("选择商品结束：{}", responseWrapper);
        return responseWrapper;
    }


    /**
     * 选择商品三级联动
     *
     * @return
     * @throws IOException
     */
    public ClientResponseWrapper chooseMall() throws IOException {
        LOGGER.info("选择商品三级联动开始:{}");
        ClientResponseWrapper clientResponseWrapper = new ClientResponseWrapper();
        String url = mallRootUrl + mallDictUrl;
        LOGGER.debug("url:{}", url);

        String string = MyRestTemplate.getInstace().getForObject(url, String.class);
        ChooseMallResponse chooseMallResponse = MyObjectMapper.getInstance().readValue(string, ChooseMallResponse.class);
        if (chooseMallResponse.isSuccess() && chooseMallResponse.isExecuted()) {
            clientResponseWrapper.setSuccess(true);
            clientResponseWrapper.setData(chooseMallResponse.getData());
        } else {
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        LOGGER.info("选择商品三级联动结束:{}", clientResponseWrapper);
        return clientResponseWrapper;
    }

    /**
     * 分期方案
     *
     * @param commodityCode
     * @return
     */
    public StagesPlanResponseWrapper stagesPlan(String commodityCode) throws IOException {
        LOGGER.info("分期方案开始:{}", commodityCode);
        StagesPlanResponseWrapper wrapper = new StagesPlanResponseWrapper();
        //查询商品信息
        String mallCodeUrl = mallRootUrl + mallByCodeUrl;
        LOGGER.debug("mallCodeUrl:{}", mallCodeUrl);
        CustCommodityResponse mallInfo = MyRestTemplate.getInstace().getForObject(mallCodeUrl, CustCommodityResponse.class, Collections.singletonMap("commodityCode", commodityCode));
        if(null != mallInfo.getCommData()){
            Integer condition = 1;
            String url = productRootUrl + tagesPlanUrl + "?level1Name=" + mallInfo.getCommData().getLevel1Name() + "&&level2Name=" + mallInfo.getCommData().getLevel2Name() + "&&level3Name=" + mallInfo.getCommData().getLevel3Name();
            LOGGER.debug("url:{}", url);
            String string = MyRestTemplate.getInstace().getForObject(url, String.class,Collections.singletonMap("condition", condition));
            StagesPlanResponse stagesPlanResponse = MyObjectMapper.getInstance().readValue(string, StagesPlanResponse.class);
            if (stagesPlanResponse.isSuccess() && stagesPlanResponse.isExecuted()) {
                wrapper.setSuccess(true);
                wrapper.setData(stagesPlanResponse.getResultData());
            }
        } else {
            wrapper.setSuccess(false);
            return wrapper;
        }

        LOGGER.info("分期方案结束:{}", wrapper);
        return wrapper;
    }

    /**
     * 商品明细
     *
     * @param commodityCode
     * @return
     */
    public ClientResponseWrapper getMallInfo(String commodityCode) throws IOException {
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        LOGGER.info("商品明细开始:{}", commodityCode);
        String url = mallRootUrl + mallInfo;
        LOGGER.debug("url:{}", url);
        MallCodeResponse string = MyRestTemplate.getInstace().getForObject(url, MallCodeResponse.class, Collections.singletonMap("commodityCode", commodityCode));
        if (string.isSuccess() && string.isExecuted()) {
            wrapper.setSuccess(true);
            wrapper.setData(string.getCommData());
        } else {
            wrapper.setSuccess(false);
            return wrapper;
        }
        LOGGER.info("商品明细结束:{}", wrapper);
        return wrapper;
    }

    /**
     * 计算月供
     * PayMonthResponse
     *
     * @param request
     */
    public ClientResponseWrapper getCalculationPayMonth(PayMonthRequest request) throws IOException {
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        LOGGER.info("计算月供开始:{}", request);
        String url = orderUrl + "/outOrder/"+request.getProductCode()+"/getMonthPay" + "?loanMoney=" + request.getLoanMoney() + "&&payTime=" + request.getPayTime() + "&&payTimeUnit=" + request.getPayTimeUnit() + "&&interestType=" + request.getInterestType() + "&&totalRate=" + request.getTotalRate() + "&&isPrePay=" + request.getIsPrePay();
        LOGGER.debug("url:{}", url);

        String string = MyRestTemplate.getInstace().getForObject(url, String.class);
        PayMonthResponse payMonthResponse = MyObjectMapper.getInstance().readValue(string, PayMonthResponse.class);
        if (payMonthResponse.isSuccess() && payMonthResponse.isExecuted()) {
            wrapper.setSuccess(true);
            wrapper.setData(payMonthResponse.getMonthPay());
        } else {
            LOGGER.debug("查询产品信息错误，可能产品信息不错在或提前还款包错误.");
            wrapper.setSuccess(false);
            return wrapper;
        }

        LOGGER.info("计算月供结束:{}", wrapper);
        return wrapper;
    }



}
