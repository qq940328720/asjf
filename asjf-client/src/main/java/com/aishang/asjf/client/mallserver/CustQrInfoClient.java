package com.aishang.asjf.client.mallserver;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.request.UserDetailRequest;
import com.aishang.asjf.client.mallserver.request.CustPreOrderRequest;
import com.aishang.asjf.client.mallserver.request.PayMonthRequest;
import com.aishang.asjf.client.mallserver.response.*;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 17-11-23.
 */
@Component
public class CustQrInfoClient {

    @Value("${server.mall.manager.root}")
    private String mallRootUrl;//商品服务地址

    @Value("${server.merchant.manager.root}")
    private String merchantRootUrl;//商户服务地址

    @Value("${sever.qr.code.url}")
    private String qrCodeUrl;//根据二维码编号查询二维码信息

    @Value("${server.product.manager.root}")
    private String productRootUrl;//产品服务地址

    @Value("${server.product.name.url}")
    private String productInfoUrl;//申请页面通过产品code查询产品名称含期数

    @Value("${server.mall.byCode.url}")
    private String mallByCodeUrl;//根据商品code查询商品信息

    @Value("${server.merchant.name.url}")
    private String merchantNameUrl;//门店地址

    @Value("${server.merchant.store.lonLat.url}")
    private String merchantStoreUrl;//门店经纬度

    @Value("${server.merchant.info.url}")
    private String merchantInfoUrl;//商户信息

    @Value(("${sever.mall.state.url}"))
    private String mallStateUrl;    //商品状态地址

    @Value(("${sever.merchant.state.url}"))
    private String merchantStateUrl; //商户门店地址

    @Value(("${sever.product.state.url}"))
    private String productStateUrl; //商户门店地址

    @Value(("${server.order.manager.root}"))
    private String orderUrl; //订单服务地址

    @Value(("${server.add.order.url}"))
    private String createOrderUrl; //订单服务地址

    @Value("${sever.mall.qrCode.time.url}")
    private String qrCodeTimeUrl;//二维码是否失效地址

    @Value("${sever.pay.month.url}")
    private String payMonthUrl;//计算月供

    @Value("${server.org.manager.root}")
    private String orgRootUrl;//组织机构

    @Value("${server.org.info.url}")
    private String orgInfoUrl;//查询组织机构

    @Value("${server.store.radius}")
    private double storeRadius;//半径

    @Value("${server.dictionary.manager.root}")
    private String dicRootUrl;//半径

    @Value("${server.dic.city.url}")
    private String dicUrl; //省市区

    @Value("${server.crm.manager.root}")
    private String crmRootUrl;//客户服务地址

    @Value("${server.enum.url}")
    private String enumUrl;//获取所有枚举

    @Value("${server.order.unfinish.url}")
    private String orderUnfinishUrl;//是否有未完成订单

    @Value("${server.crm.isFormal.url}")
    private String crmIsFormalUrl;//是否有未完成订单

    @Value("${server.product.isPrePay.url}")
    private String isPrePayUrl;//获取产品提前还款包信息

    private static final Logger LOGGER = LoggerFactory.getLogger(QrServerClient.class);

    RestTemplate restTemplate = MyRestTemplate.getInstace();

    //把经纬度转为度（°）
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    /**
     * 申请页面根据二维码编号查询二维码信息
     *
     * @param qrCode
     */
    public ClientResponseWrapper getQrCodeInfo(String qrCode,String userCode) throws IOException {
        LOGGER.info("申请页面查询二维码信息开始:{}", qrCode);
        LOGGER.info("用户编号:{}", userCode);
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        CustQrInfoResponse response = new CustQrInfoResponse();
        //查询商品
        String url = mallRootUrl + qrCodeUrl;
        LOGGER.debug("url:{}", url);
        QrCodeResponse qrCodeResponse = restTemplate.getForObject(url, QrCodeResponse.class, Collections.singletonMap("qrCode", qrCode));
        if(null != qrCodeResponse){
            //**********************判断同类型订单是否有未完成的
            String commodityCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityCode();
            //查询商品信息
            String mallCodeUrl = mallRootUrl + mallByCodeUrl;
            LOGGER.debug("mallCodeUrl:{}", mallCodeUrl);
            CustCommodityResponse mallInfo = MyRestTemplate.getInstace().getForObject(mallCodeUrl, CustCommodityResponse.class, Collections.singletonMap("commodityCode", commodityCode));
            if(null != mallInfo){
                String level1Code = mallInfo.getCommData().getLevel1Name();
                LOGGER.debug("level1Code:{}",level1Code);
                //查询订单中是否有未完成的(１:没有被拒或同类型未完成;２:被拒且时间不足;３:有同类型未完成)
                String unFinishedOrdersUrl = orderUrl+orderUnfinishUrl+"?level1Code="+level1Code;
                UnFinishOrderResponse unFinishResponse = restTemplate.getForObject(unFinishedOrdersUrl,UnFinishOrderResponse.class,Collections.singletonMap("userCode",userCode));
                if(unFinishResponse.isSuccess() && unFinishResponse.isExecuted()){
                    //1单子被拒绝
                    if(null != unFinishResponse.getData() && unFinishResponse.getData() == 2){
                        LOGGER.debug("返回的天数:{}",unFinishResponse.getMessage());
                        wrapper.setData(unFinishResponse.getMessage());
                        wrapper.setSuccess(false);
//                        wrapper.setMessage("您3个月内有拒单记录，请"+unFinishResponse.getMessage()+"天后再重试申请哦～");
                        wrapper.setMessage("1");
                        return wrapper;
                    }
                    //2相同类型的单子只能下一个
                    if(null != unFinishResponse.getData() && unFinishResponse.getData() == 3){
                        wrapper.setSuccess(false);
                        wrapper.setMessage("2");
                        return wrapper;
                    }
                }
            }
            //商品名称，商品价格,分期方案，分期期数
            //查询产品信息
            //分期方案，分期期数
            String productCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductCode();
            LOGGER.debug("获取到的产品code:{}", productCode);
            String productUrl = productRootUrl + productInfoUrl;
            LOGGER.debug("产品请求地址:{}", productUrl);
            //查询门店信息
            String storeCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getStoreCode();//门店code
            LOGGER.debug("storeCode:{}", storeCode);
            String storeUrl = merchantRootUrl + merchantNameUrl;
            MerchantResponse merchantResponse = restTemplate.getForObject(storeUrl, MerchantResponse.class, Collections.singletonMap("storeCode", storeCode));

            if (null != merchantResponse.getOuterDTOS()) {
                response.setStoreCode(merchantResponse.getOuterDTOS().get(0).getStoreCode());
                response.setStoreName(merchantResponse.getOuterDTOS().get(0).getStoreFullName());
            }
            ProductResponse productResponse = restTemplate.getForObject(productUrl, ProductResponse.class, Collections.singletonMap("productCode", productCode));
            if (productResponse.isSuccess() && productResponse.isExecuted()) {
                //商品信息
                if (null != qrCodeResponse.getQrCreateLogInfoDTOS()) {
                    response.setCommodityCode(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityCode());
                    response.setCommodityName(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityName());
                    response.setCommodityPrice(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductPrice());
                    response.setEmpNameCode(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getEmployeeCode());
                    response.setLoanAmountMin(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getLoanAmountMin());
                    response.setLoanAmountMax(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getLoanAmountMax());
                }
                //产品信息
                if (null != productResponse.getProductName()) {
                    response.setProductName(productResponse.getProductName());
                }
                if (null != qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductCode()) {
                    response.setProductCode(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductCode());
                } else {
                    response.setProductCode("");
                }
                if (null != productResponse.getInterestType()) {
                    response.setInterestType(productResponse.getInterestType());
                }
                if (null != productResponse.getTotalRate()) {
                    response.setTotalRate(productResponse.getTotalRate());
                }
                if (null != productResponse.getSupportTimeInfos()) {
                    response.setSupportTimeInfos(productResponse.getSupportTimeInfos());
                }
                //查询是否有提前还款包 0,否  1,是
                String urls = productRootUrl+isPrePayUrl;
                ProductIsPrePayResponse payResponse = restTemplate.getForObject(urls, ProductIsPrePayResponse.class, Collections.singletonMap("productCode", productCode));
                if(!payResponse.isSuccess() && !payResponse.isExecuted()){
                    LOGGER.debug("查询提前还款包(产品不存在)!");
                    wrapper.setSuccess(false);
                    return wrapper;
                }
                response.setIsPrePay(String.valueOf(payResponse.getIsPrePay()));
                wrapper.setSuccess(true);
                wrapper.setData(response);

            } else {
                LOGGER.debug("查询产品出错!");
                wrapper.setSuccess(false);
                return wrapper;
            }
        }else{
            wrapper.setSuccess(false);
            return wrapper;
        }
        LOGGER.info("申请页面查询二维码信息结束:{}", wrapper);
        return wrapper;
    }

    /**
     * 客户下单
     * @param request
     * @param qrCode
     * @return
     */
    public ClientResponseWrapper addCustPreOrder(CustPreOrderRequest request,String qrCode,String ip) throws IOException {
        LOGGER.info("客户下单开始:{}", request);
        LOGGER.info("客户下单开始:{}", qrCode);
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        //查询商品
        String url = mallRootUrl + qrCodeUrl;
        LOGGER.debug("url:{}", url);
        QrCodeResponse qrCodeResponse = restTemplate.getForObject(url, QrCodeResponse.class, Collections.singletonMap("qrCode", qrCode));
        if (null != qrCodeResponse.getQrCreateLogInfoDTOS()) {

            //贷款金额=商品价格 —首付
            BigDecimal price = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductPrice();
            BigDecimal firstPayMoney = request.getFirstPayMoney();
            BigDecimal loanMoney = price.subtract(firstPayMoney);
            request.setLoanMoney(loanMoney);//贷款金额
            request.setIpSrc(ip);//请求ip

            //根据商品code查询商品信息
            String commodityCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityCode();
            String mallCodeUrl = mallRootUrl + mallByCodeUrl;
            LOGGER.debug("url:{}", url);
            CustCommodityResponse mallInfo = restTemplate.getForObject(mallCodeUrl, CustCommodityResponse.class, Collections.singletonMap("commodityCode", commodityCode));

            if (null != qrCodeResponse.getQrCreateLogInfoDTOS()) {
                request.setCommodityCode(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityCode());
                request.setCommodityName(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getCommodityName());
                request.setCommodityPrice(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductPrice());
                request.setEmpNameCode(qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getEmployeeCode());
            }

            //查询产品信息
            String productCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getProductCode();
            LOGGER.debug("获取到的产品code:{}", productCode);
            String productUrl = productRootUrl + productInfoUrl;
            LOGGER.debug("产品请求地址:{}", productUrl);
            ProductResponse productResponse = restTemplate.getForObject(productUrl, ProductResponse.class, Collections.singletonMap("productCode", productCode));
            if (null != productResponse.getSupportTimeInfos()) {
                request.setProductCode(productCode);
                request.setProductName(productResponse.getProductName());
                request.setInterestType(productResponse.getInterestType().getValue());
                request.setPayRate(productResponse.getTotalRate());
                request.setPayTimeUnit(productResponse.getSupportTimeInfos().get(0).getPaytimeUnit().getValue());
            }

            if (null != mallInfo.getCommData()) {
                request.setLevel1Code(mallInfo.getCommData().getLevel1Name());
                request.setLevel2Code(mallInfo.getCommData().getLevel2Name());
                request.setLevel3Code(mallInfo.getCommData().getLevel3Name());
            }

            String storeCode = qrCodeResponse.getQrCreateLogInfoDTOS().get(0).getStoreCode();//门店code
            //查询商户信息
            String merchantUrl = merchantRootUrl + merchantInfoUrl;
            MerchantInfoResponse merchantInfoResponse = restTemplate.getForObject(merchantUrl, MerchantInfoResponse.class, Collections.singletonMap("storeCode", storeCode));
            if (null != merchantInfoResponse) {
                request.setMerchantName(merchantInfoResponse.getMerchantFullName());
                request.setMerchantCode(merchantInfoResponse.getMerchantCode());
            }
            String orgCode = merchantInfoResponse.getParentOrgCode();
            //查询组织机构
            String orgUrl = orgRootUrl+orgInfoUrl;
            OrgResponse org = restTemplate.getForObject(orgUrl, OrgResponse.class, Collections.singletonMap("orgCode", orgCode));
            if(null != org.getData()){
                request.setOrgCode(org.getData().get(0).getId());
                request.setOrgName(org.getData().get(0).getName());
            }

            //查询门店信息
            LOGGER.debug("storeCode:{}", storeCode);
            String storeUrl = merchantRootUrl + merchantNameUrl;
            MerchantResponse merchantResponse = restTemplate.getForObject(storeUrl, MerchantResponse.class, Collections.singletonMap("storeCode", storeCode));
            if (null != merchantResponse.getOuterDTOS()) {
                request.setStoreCode(merchantResponse.getOuterDTOS().get(0).getStoreCode());
                request.setStoreName(merchantResponse.getOuterDTOS().get(0).getStoreFullName());
            }

            //*****************************状态判断开始******************************//
            //判断商品，门店，产品的状态开始
            LOGGER.info("判断商品的状态开始:{}", request.getCommodityCode());
            String commUrl = mallRootUrl + mallStateUrl;
            CilentBaseResponse commString = restTemplate.getForObject(commUrl, CilentBaseResponse.class, Collections.singletonMap("commodityCode", commodityCode));
            if (!commString.isExecuted()) {
                wrapper.setMessage("1");
                wrapper.setSuccess(false);
                return wrapper;
            }
            //商户门店
            String merchentUrl = merchantRootUrl + merchantStateUrl;
            CilentBaseResponse merchentString = restTemplate.getForObject(merchentUrl, CilentBaseResponse.class, Collections.singletonMap("storeCode", storeCode));
            LOGGER.debug("调用结果:{}", merchentString);
            if (!merchentString.isExecuted()) {
                wrapper.setMessage("2");
                wrapper.setSuccess(false);
                return wrapper;
            }
            //产品
            String proUrl = productRootUrl + productStateUrl;
            CilentBaseResponse productString = restTemplate.getForObject(proUrl, CilentBaseResponse.class, Collections.singletonMap("productCode", productCode), Collections.singletonMap("storeCode", storeCode));
            if (!productString.isExecuted()) {
                wrapper.setMessage("3");
                wrapper.setSuccess(false);
                return wrapper;
            }
            //*****************************状态判断结束******************************//
            //判断该业务员在不在门店范围内
            //门店经纬度
            String merchantLonLatUrl = merchantRootUrl + merchantStoreUrl;
            MerchantLonLatResponse merchantLonLatResponse = restTemplate.getForObject(merchantLonLatUrl, MerchantLonLatResponse.class, Collections.singletonMap("storeCode", storeCode));
            String lat = merchantLonLatResponse.getLon();//纬度
            String lon = merchantLonLatResponse.getLat();//经度
            //业务员经纬度
            double empLat = request.getLat();//纬度
            double empLng = request.getLng();//经度
            double distance = getDistance(empLat, empLng, Double.valueOf(lat), Double.valueOf(lon));

            BigDecimal data1 = new BigDecimal(storeRadius);
            BigDecimal data2 = new BigDecimal(distance);
            int compare = data1.compareTo(data2);//RADIUS小于、等于或大于distance 时，返回 -1、0 或 1。
            if(compare == -1){
                wrapper.setMessage("4");
                return wrapper;
            }
            //**********************判断二维码是否失效
            ClientResponseWrapper qrValidity = getQrValidity(qrCode);
            if(!qrValidity.isSuccess()){
                wrapper.setMessage("5");
                return wrapper;
            }

            //修改客户为正式客户
            String crmIsFormal = crmRootUrl+crmIsFormalUrl+"YES"+"/"+request.getUserCode();
            ResponseEntity<CilentBaseResponse> respons = restTemplate.exchange(crmIsFormal, HttpMethod.PUT, null, CilentBaseResponse.class);
            if(!respons.getBody().isSuccess() && !respons.getBody().isExecuted()){
                wrapper.setSuccess(false);
                return wrapper;
            }
            //调用创建订单接口
            String addOrderUrl = orderUrl+createOrderUrl;
            LOGGER.debug("下单请求参数:{}",request);
            CreateOrderResponse orderResponse = MyRestTemplate.getInstace().postForObject(addOrderUrl, request, CreateOrderResponse.class);
            if(orderResponse.isSuccess() && orderResponse.isExecuted()){
                wrapper.setSuccess(true);
                wrapper.setData(orderResponse.getData());
            }else{
                wrapper.setSuccess(false);
                return wrapper;
            }

        }else{
            wrapper.setSuccess(false);
            return wrapper;
        }
        return wrapper;
    }


    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public double getDistance(double lng1, double lat1, double lng2, double lat2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin(a/2),2)
                                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)
                )
        );
        s = s * storeRadius;
        s = Math.round(s * 10000) / 10000;
        System.out.println("=="+s);
        return s;
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
            wrapper.setSuccess(false);
            return wrapper;
        }

        LOGGER.info("计算月供结束:{}", wrapper);
        return wrapper;
    }


    public ClientResponseWrapper getAllEnum() throws IOException {
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        AllEnumAreaResponseWapper allWrpper = new AllEnumAreaResponseWapper();
        LOGGER.info("获取省市区及枚举开始");
        String dictUrl = dicRootUrl + dicUrl;
        DictionaryResponse dict = MyRestTemplate.getInstace().getForObject(dictUrl, DictionaryResponse.class);
        if(null == dict.getDatas()){
            wrapper.setSuccess(false);
            return wrapper;
        }
        String allEnumUrl = crmRootUrl+enumUrl;
        JsonNode jsonNode = MyRestTemplate.getInstace().getForObject(allEnumUrl, JsonNode.class);
        if(jsonNode.get("success").asBoolean()&&jsonNode.get("executed").asBoolean()) {

            //收入来源
            String incomeResource = jsonNode.get("incomeResource").asText();
            List<AllEnumResponse> incomeResourceResponse = MyObjectMapper.getInstance().readValue(incomeResource, new TypeReference<List<AllEnumResponse>>() {
            });

            //婚姻状况
            String ismarriede = jsonNode.get("ismarriede").asText();
            List<AllEnumResponse> ismarriedeResponse = MyObjectMapper.getInstance().readValue(ismarriede, new TypeReference<List<AllEnumResponse>>() {
            });

            //学历
            String highesteducation = jsonNode.get("highesteducation").asText();
            List<AllEnumResponse> highesteducationResponse = MyObjectMapper.getInstance().readValue(highesteducation, new TypeReference<List<AllEnumResponse>>() {
            });

            //联系人关系
            String relationship = jsonNode.get("relationship").asText();
            List<AllEnumResponse> relationshipResponse = MyObjectMapper.getInstance().readValue(relationship, new TypeReference<List<AllEnumResponse>>() {
            });

            //性别
            String gender = jsonNode.get("gender").asText();
            List<AllEnumResponse> genderResponse = MyObjectMapper.getInstance().readValue(gender, new TypeReference<List<AllEnumResponse>>() {
            });

            //第几联系人
            String ncontactname = jsonNode.get("ncontactname").asText();
            List<AllEnumResponse> ncontactnameResponse = MyObjectMapper.getInstance().readValue(ncontactname, new TypeReference<List<AllEnumResponse>>() {
            });

            //电话类型
            String phones = jsonNode.get("phones").asText();
            List<AllEnumResponse> phonesResponse = MyObjectMapper.getInstance().readValue(phones, new TypeReference<List<AllEnumResponse>>() {
            });

            //照片类型
            String imageType = jsonNode.get("imageType").asText();
            List<AllEnumResponse> imageTypeResponse = MyObjectMapper.getInstance().readValue(imageType, new TypeReference<List<AllEnumResponse>>() {
            });

            //订单状态
            String orderStatus = jsonNode.get("orderStatus").asText();
            List<AllEnumResponse> orderStatusResponse = MyObjectMapper.getInstance().readValue(orderStatus, new TypeReference<List<AllEnumResponse>>() {
            });

            //打款状态
            String sendAuditState = jsonNode.get("sendAuditState").asText();
            List<AllEnumResponse> sendAuditStateResponse = MyObjectMapper.getInstance().readValue(sendAuditState, new TypeReference<List<AllEnumResponse>>() {
            });

            //信审状态
            String creditState = jsonNode.get("creditState").asText();
            List<AllEnumResponse> creditStateResponse = MyObjectMapper.getInstance().readValue(creditState, new TypeReference<List<AllEnumResponse>>() {
            });

            //资金渠道
            String moneyResource = jsonNode.get("moneyResource").asText();
            List<AllEnumResponse> moneyResourceResponse = MyObjectMapper.getInstance().readValue(moneyResource, new TypeReference<List<AllEnumResponse>>() {
            });

            String pickupState = jsonNode.get("pickupState").asText();
            List<AllEnumResponse> pickupStateResponse = MyObjectMapper.getInstance().readValue(pickupState, new TypeReference<List<AllEnumResponse>>() {
            });


            String firstLinkerRelation = jsonNode.get("firstLinkerRelation").asText();
            List<AllEnumResponse> firstLinkerRelationResponse = MyObjectMapper.getInstance().readValue(firstLinkerRelation, new TypeReference<List<AllEnumResponse>>() {
            });


            allWrpper.setArea(dict);
            allWrpper.setIncomeResource(incomeResourceResponse);
            allWrpper.setIsmarriede(ismarriedeResponse);
            allWrpper.setHighesteducation(highesteducationResponse);
            allWrpper.setRelationship(relationshipResponse);
            allWrpper.setGender(genderResponse);
            allWrpper.setNcontactname(ncontactnameResponse);
            allWrpper.setPhones(phonesResponse);
            allWrpper.setImageType(imageTypeResponse);
            allWrpper.setOrderStatus(orderStatusResponse);
            allWrpper.setSendAuditState(sendAuditStateResponse);
            allWrpper.setCreditState(creditStateResponse);
            allWrpper.setPickupState(pickupStateResponse);
            allWrpper.setMoneyResource(moneyResourceResponse);
            allWrpper.setFirstLinkerRelation(firstLinkerRelationResponse);
            wrapper.setSuccess(true);
            wrapper.setData(allWrpper);
        }else{
            wrapper.setSuccess(false);
            return wrapper;
        }


        return wrapper;
    }

}
