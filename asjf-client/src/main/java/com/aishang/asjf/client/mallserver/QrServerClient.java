package com.aishang.asjf.client.mallserver;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.request.UserDetailRequest;
import com.aishang.asjf.client.mallserver.request.QrListRequest;
import com.aishang.asjf.client.mallserver.request.QrRequest;
import com.aishang.asjf.client.mallserver.response.*;
import com.aishang.asjf.client.mallserver.response.info.QrCreateLogInfo;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 商城系统接口客户端
 */
@Component
public class QrServerClient {

    @Value("${server.mall.manager.root}")
    private String mallRootUrl;//商品服务地址

    @Value("${server.merchant.manager.root}")
    private String merchantRootUrl;//商户服务地址

    @Value("${server.product.manager.root}")
    private String productRootUrl;//产品服务地址

    @Value("${sever.mall.qrCode.time.url}")
    private String qrCodeTimeUrl;//二维码是否失效地址

    @Value("${sever.mall.qrCode.url}")
    private String qrUrl;//生成二维码地址

    @Value("${sever.qr.code.url}")
    private String qrCodeUrl;//根据二维码编号查询二维码信息

    @Value("${server.store.binding.manager.root}")
    private String storeRootUrl;//门店服务地址

    @Value("${server.merchant.name.url}")
    private String merchantNameUrl;//门店地址

    @Value("${sever.empl.code.qrUrl}")
    private String emplCodeQrUrl;//根据二维码编号查询二维码信息

    @Value("${server.product.name.url}")
    private String productInfoUrl;//申请页面通过产品code查询产品名称含期数

    @Value(("${sever.mall.state.url}"))
    private String mallStateUrl;    //商品状态地址

    @Value(("${sever.merchant.state.url}"))
    private String merchantStateUrl; //商户门店地址

    @Value(("${sever.product.state.url}"))
    private String productStateUrl; //商户门店地址

    @Value("${server.mall.usage.url}")
    private String mallUsageUrl;//根据是商品code查询商品信息

    RestTemplate restTemplate = MyRestTemplate.getInstace();

    private static final Logger LOGGER = LoggerFactory.getLogger(QrServerClient.class);

    /**
     * 生成二维码返回二维码编号
     *
     * @param request
     * @return
     * @throws IOException
     */
    public ClientResponseWrapper GeneratingTwoDimensionalCode(QrRequest request) throws IOException {
        LOGGER.info("生成二维码开始:{}", request);
        ClientResponseWrapper clientResponseWrapper = new ClientResponseWrapper();

        //*****************************状态判断开始******************************//
        //判断商品，门店，产品的状态开始
        String commodityCode = request.getCommodityCode();
        LOGGER.info("判断商品的状态开始:{}", request.getCommodityCode());
        String commUrl = mallRootUrl + mallStateUrl;
        CilentBaseResponse commString = restTemplate.getForObject(commUrl, CilentBaseResponse.class, Collections.singletonMap("commodityCode", commodityCode));
        if (!commString.isExecuted()) {
            clientResponseWrapper.setMessage("1");
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        //商户门店
        String storeCode = request.getStoreCode();
        String merchentUrl = merchantRootUrl + merchantStateUrl;
        CilentBaseResponse merchentString = restTemplate.getForObject(merchentUrl, CilentBaseResponse.class, Collections.singletonMap("storeCode", storeCode));
        LOGGER.debug("调用结果:{}", merchentString);
        if (!merchentString.isExecuted()) {
            clientResponseWrapper.setMessage("2");
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        //产品
        String productCode = request.getProductCode();
        String productUrl = productRootUrl + productStateUrl;
        CilentBaseResponse productString = restTemplate.getForObject(productUrl, CilentBaseResponse.class, Collections.singletonMap("productCode", productCode), Collections.singletonMap("storeCode", storeCode));
        if (!productString.isExecuted()) {
            clientResponseWrapper.setMessage("3");
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }

        //*****************************状态判断结束******************************//
        QrResponse qrResponse = new QrResponse();
        String url = mallRootUrl + qrUrl;
        LOGGER.debug("url:{}", url);
        LOGGER.debug("请求地址:{}", url);

        Map<String, String> params = new HashMap<>(5);
        params.put("commodityCode", request.getCommodityCode());
        params.put("employeeCode", request.getEmployeeCode());
        params.put("productCode", request.getProductCode());
        params.put("productPrice", String.valueOf(request.getProductPrice()));
        params.put("storeCode", request.getStoreCode());
        params.put("isWarning", String.valueOf(request.getIsWarning()));
        params.put("isRecommend", String.valueOf(request.getIsRecommend()));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map> entity = new HttpEntity<>(params, httpHeaders);
        //生成二维码
        String string = MyRestTemplate.getInstace().postForObject(url, entity, String.class);
        QrResponse response = MyObjectMapper.getInstance().readValue(string, QrResponse.class);

        //修改商品使用率
        String usageUrl = mallRootUrl+mallUsageUrl+"/"+commodityCode;
        HttpEntity requestw = new HttpEntity<>(commodityCode, httpHeaders);
        ResponseEntity<CilentBaseResponse> usage = null;
        usage = restTemplate.exchange(usageUrl, HttpMethod.PUT, requestw, CilentBaseResponse.class);

//        CilentBaseResponse usage = MyRestTemplate.getInstace().getForObject(usageUrl, CilentBaseResponse.class, Collections.singletonMap("commodityCode", commodityCode));
        if(!usage.getBody().isExecuted()){
            clientResponseWrapper.setMessage("4");
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        if (response.isSuccess() && response.isExecuted()) {
            clientResponseWrapper.setSuccess(true);
            clientResponseWrapper.setData(response.getQrCode());
            LOGGER.info("返回的二维码编号:{}", response.getQrCode());
        } else {
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }

        LOGGER.info("生成二维码结束:{}", response);
        return clientResponseWrapper;
    }


    /**
     * 根据二维码编号查询二维码信息
     *
     * @param qrCode
     */
    public ClientResponseWrapper getQrCodeInfo(String qrCode) throws IOException {
        LOGGER.info("根据二维码编号查询二维码信息开始:{}", qrCode);
        StoreInfoResponse response = new StoreInfoResponse();
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        //查询商品
        //先查出code对应的name
        String url = mallRootUrl + qrCodeUrl;
        LOGGER.debug("url:{}", url);
        QrCodeResponse string = restTemplate.getForObject(url, QrCodeResponse.class, Collections.singletonMap("qrCode", qrCode));
        //商品名称，商品价格，首付金额，贷款金额，分期方案，分期期数，每期仅还，购买提前还款包
        if (null != string.getQrCreateLogInfoDTOS()) {
            //调门店
            String storeCode = string.getQrCreateLogInfoDTOS().get(0).getStoreCode();
            String storeUrl = merchantRootUrl + merchantNameUrl;
            LOGGER.debug("storeUrl:{}", storeUrl);
            StoreNameResponse storeResponse = restTemplate.getForObject(storeUrl, StoreNameResponse.class, Collections.singletonMap("storeCode", storeCode));

            //调产品
            //分期方案，分期期数
            Integer condition = 1;
            String productCode = string.getQrCreateLogInfoDTOS().get(0).getProductCode();
            LOGGER.debug("获取到的产品code:{}", productCode);
            String productUrl = productRootUrl + productInfoUrl;
            LOGGER.debug("产品请求地址:{}", productUrl);
            ProductResponse productResponse = restTemplate.getForObject(productUrl, ProductResponse.class, Collections.singletonMap("productCode", productCode));
            if (productResponse.isSuccess() && productResponse.isExecuted()) {

                //商品信息
                if (null != string.getQrCreateLogInfoDTOS().get(0).getCommodityCode()) {
                    response.setCommodityCode(string.getQrCreateLogInfoDTOS().get(0).getCommodityCode());
                } else {
                    response.setCommodityCode("");
                }
                if (null != string.getQrCreateLogInfoDTOS().get(0).getCommodityName()) {
                    response.setCommodityName(string.getQrCreateLogInfoDTOS().get(0).getCommodityName());
                } else {
                    response.setCommodityName("");
                }
                if (null != string.getQrCreateLogInfoDTOS().get(0).getProductPrice()) {
                    response.setCommodityPrice(string.getQrCreateLogInfoDTOS().get(0).getProductPrice());
                } else {
                    response.setCommodityPrice(new BigDecimal(0));
                }
                if (null != string.getQrCreateLogInfoDTOS().get(0).getLoanAmountMin()) {
                    response.setLoanAmountMin(string.getQrCreateLogInfoDTOS().get(0).getLoanAmountMin());
                } else {
                    response.setLoanAmountMin(new BigDecimal(0));
                }
                if (null != string.getQrCreateLogInfoDTOS().get(0).getLoanAmountMax()) {
                    response.setLoanAmountMax(string.getQrCreateLogInfoDTOS().get(0).getLoanAmountMax());
                } else {
                    response.setLoanAmountMax(new BigDecimal(0));
                }
                response.setIsWarning(string.getQrCreateLogInfoDTOS().get(0).getIsWarning());
                response.setIsRecommend(string.getQrCreateLogInfoDTOS().get(0).getIsRecommend());

                //门店信息
                if (null != storeResponse.getOuterDTOS()) {
                    response.setStoreCode(storeResponse.getOuterDTOS().get(0).getStoreCode());
                    response.setStoreName(storeResponse.getOuterDTOS().get(0).getStoreFullName());
                } else {
                    response.setStoreCode("");
                    response.setStoreName("");
                }

                //产品信息
                if (null != productResponse.getProductName()) {
                    response.setProductName(productResponse.getProductName());
                } else {
                    response.setProductName("");
                }
                if (null != string.getQrCreateLogInfoDTOS().get(0).getProductCode()) {
                    response.setProductCode(string.getQrCreateLogInfoDTOS().get(0).getProductCode());
                } else {
                    response.setProductCode("");
                }
                if (null != productResponse.getInterestType()) {
                    response.setInterestType(productResponse.getInterestType());
                }
                if (null != productResponse.getTotalRate()) {
                    response.setTotalRate(productResponse.getTotalRate());
                } else {
                    response.setTotalRate(new BigDecimal(0));
                }
                if (null != productResponse.getSupportTimeInfos()) {
                    response.setSupportTimeInfos(productResponse.getSupportTimeInfos());
                } else {
                    response.setSupportTimeInfos(new ArrayList());
                }

                response.setIsPrePay(productResponse.getIsPrePay());

                wrapper.setSuccess(true);
                wrapper.setData(response);
            }
        } else {
            wrapper.setSuccess(false);
            return wrapper;
        }
        return wrapper;
    }

    /**
     * 根据二维码编号判断二维码是否失效
     *
     * @param qrCode
     * @return
     * @throws IOException
     */
    public ClientResponseWrapper getQrValidity(String qrCode) throws IOException {
        LOGGER.info("根据二维码编号判断二维码是否失效开始:{}", qrCode);
        ClientResponseWrapper clientResponseWrapper = new ClientResponseWrapper();
        if (null == qrCode) {
            return null;
        }
        String url = mallRootUrl + qrCodeTimeUrl;
        LOGGER.debug("url:{}", url);
        CilentBaseResponse string = MyRestTemplate.getInstace().getForObject(url, CilentBaseResponse.class, Collections.singletonMap("qrCode", qrCode));
        if (string.isSuccess() && string.isExecuted()) {
            clientResponseWrapper.setSuccess(true);
            clientResponseWrapper.setData(string.getMessage());
        } else {
            clientResponseWrapper.setSuccess(false);
            return clientResponseWrapper;
        }
        LOGGER.info("根据二维码编号判断二维码是否失效结束:{}", string);
        return clientResponseWrapper;
    }

    /**
     * 根据员工工号查询二维码列表
     *
     * @param request
     * @return
     */
    public QrCodeResponse getQrCodeList(QrListRequest request) {
        LOGGER.debug("查询二维码列表开始:{}", request);
        QrCodeResponse wrapper = new QrCodeResponse();
        //查询二维码列表
        String url = mallRootUrl + emplCodeQrUrl + "?mallName=" + request.getMallName() + "&&page=" + request.getOffset() + "&&size=" + request.getLimit();
        LOGGER.debug("url:{}", url);
        QrCodeResponse string = restTemplate.getForObject(url, QrCodeResponse.class, Collections.singletonMap("employeeCode", request.getEmployeeCode()));
        //调用门店

        List<QrCreateLogInfo> infoDTOS = string.getQrCreateLogInfoDTOS();
        List list = new ArrayList();
        if (null != infoDTOS) {
            for (int i = 0; i < infoDTOS.size(); i++) {//获取二维码信息
                if (null != infoDTOS.get(i)) {
                    QrListResponse qrList = null;
                    //调门店
                    String storeCode = string.getQrCreateLogInfoDTOS().get(i).getStoreCode();
                    LOGGER.debug("storeCode:{}", storeCode);
                    System.out.println("=======" + storeCode + "======");
                    String storeUrl = merchantRootUrl + merchantNameUrl;
                    MerchantResponse merchantResponse = restTemplate.getForObject(storeUrl, MerchantResponse.class, Collections.singletonMap("storeCode", storeCode));
                    qrList = new QrListResponse();
                    qrList.setCommodityCode(infoDTOS.get(i).getCommodityCode());
                    qrList.setCommodityName(infoDTOS.get(i).getCommodityName());
                    qrList.setProductPrice(infoDTOS.get(i).getProductPrice());
                    qrList.setQrCode(infoDTOS.get(i).getQrCode());
                    qrList.setInsertTime(infoDTOS.get(i).getInsertTime());
                    if (null == merchantResponse.getOuterDTOS()) {
                        qrList.setStoreCode("");
                        qrList.setStoreName("");
                    } else {
                        qrList.setStoreCode(merchantResponse.getOuterDTOS().get(0).getStoreCode());
                        qrList.setStoreName(merchantResponse.getOuterDTOS().get(0).getStoreFullName());
                    }

                    list.add(qrList);

                }
            }
        }
        wrapper.setTotal(string.getTotal());
        wrapper.setData(list);

        LOGGER.debug("查询二维码列表结束:{}", wrapper);
        return wrapper;
    }


}
