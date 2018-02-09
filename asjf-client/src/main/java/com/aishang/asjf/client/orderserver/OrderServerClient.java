package com.aishang.asjf.client.orderserver;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.enums.ImageTypeEnum;
import com.aishang.asjf.client.crmserver.enums.MoneyResourceEnum;
import com.aishang.asjf.client.crmserver.request.AddPickupImgRequest;
import com.aishang.asjf.client.crmserver.request.ImgInfo;
import com.aishang.asjf.client.crmserver.request.UpdRejectImgRequest;
import com.aishang.asjf.client.crmserver.request.UpdateImaRequest;
import com.aishang.asjf.client.crmserver.response.CilentXydResponse;
import com.aishang.asjf.client.crmserver.response.UserOrderListInfoResponse;
import com.aishang.asjf.client.crmserver.response.UserOrderListResponse;
import com.aishang.asjf.client.crmserver.response.WecashrResponse;
import com.aishang.asjf.client.mallserver.response.CommodityMustImeiResponse;
import com.aishang.asjf.client.mallserver.response.MustImeiResponse;
import com.aishang.asjf.client.orderserver.enums.CreditImageType;
import com.aishang.asjf.client.orderserver.enums.PayTimeType;
import com.aishang.asjf.client.orderserver.enums.PickupImageType;
import com.aishang.asjf.client.orderserver.enums.WhetherEnum;
import com.aishang.asjf.client.orderserver.request.OrderSignRequest;
import com.aishang.asjf.client.orderserver.request.UpdateCreditAdjustImgRequest;
import com.aishang.asjf.client.orderserver.request.UpdatePickupAdjustImgRequest;
import com.aishang.asjf.client.orderserver.response.*;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 订单系统接口客户端
 */
@Component
public class OrderServerClient {

    @Value("${server.order.manager.root}")
    private String orderUrl;

    @Value("${server.crm.manager.root}" + "${server.crm.manager.url}")
    private String crmUrl;

    @Value("${server.mall.manager.root}")
    private String mallRootUrl;//商品服务地址

    @Value("${server.commodity.url}")
    private String isMustDeImeIcodeUrl;//查询设备串码是否必填

    @Value("${server.order.info.url}")
    private String orderInfosUrl;//通过订单编号获取订单信息

    @Value("${server.api.manager.root}")
    private String apiRootUrl; //api根目录；

    @Value("${server.api.acc.pwd.url}")
    private String accpwd;//通过cusmerId获取用户账号和密码

    @Value("${server.api.manager.root}")
    private String apiUrl;

    private RestTemplate restTemplate = MyRestTemplate.getInstace();

    private ObjectMapper objectMapper = MyObjectMapper.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(CrmServerClient.class);




    /**
     * 查询驳回照片
     * @param orderCode
     * @return
     * @throws IOException
     */
    public  ClientResponseWrapper getCustImgList(String orderCode) throws IOException{
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        LOGGER.info("查询驳回照片开始:{}",orderCode);
        //查询被驳回提货照
        String pickUrl = orderUrl + "/outOrder/" + orderCode + "/getPickupAdjustImg";
        GetPickupAdjustImgResponse getPickupAdjustImgResponse = restTemplate.getForObject(pickUrl,GetPickupAdjustImgResponse.class);
        if (getPickupAdjustImgResponse.isSuccess() && getPickupAdjustImgResponse.isExecuted()) {
            wrapper.setSuccess(true);
            wrapper.setData(getPickupAdjustImgResponse.getResultData());
        }else {
            wrapper.setSuccess(false);
        }

        //查询被驳回信审照片
        String pickUrls = orderUrl + "/outOrder/" + orderCode + "/getCreditAdjustImg";
        GetPickupAdjustImgResponse getCreditAdjustImgResponse = restTemplate.getForObject(pickUrls,GetPickupAdjustImgResponse.class);
        if (getCreditAdjustImgResponse.isSuccess() && getCreditAdjustImgResponse.isExecuted()) {
            wrapper.setSuccess(true);
            wrapper.setData(getCreditAdjustImgResponse.getResultData());
        }else {
            wrapper.setSuccess(false);
        }

        LOGGER.info("查询驳回照片结束:{}",wrapper);
        return wrapper;
    }

    /**
     * 修改驳回照片
     * @return
     */
    public ClientResponseWrapper updateRejectImageList(UpdRejectImgRequest rejectImgDTO, String orderCode,String userCode){
        LOGGER.info("修改驳回照片开始:{}");
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<ImgInfo> recieveData = rejectImgDTO.getRecieveData();
        String imgTypeCode="";
        if(recieveData!=null&&recieveData.size()>0){
            imgTypeCode = recieveData.get(0).getImgTypeCode();
        }
        Map<String,ImgInfo> map=new HashMap<>();
        for (ImgInfo imgInfo : recieveData) {
            map.put(imgInfo.getImgTypeCode(),imgInfo);
        }
        String[] creditImaStr = {CreditImageType.CONFIM.getEnumName(),CreditImageType.HOLD_IDENTITY.getEnumName(), CreditImageType.IDENTITY_HEAD.getEnumName(),CreditImageType.IDENTITY_EMBLEM.getEnumName()};
        String[] pickupImaStr = {PickupImageType.BANKCARD.getEnumName(),PickupImageType.GROUP.getEnumName(),
                PickupImageType.STRINGCODE.getEnumName(),PickupImageType.STRINGCODE_SHOT.getEnumName(),
                PickupImageType.SELF.getEnumName(),PickupImageType.SIGNPAY.getEnumName()};
        int result=0;
        int n;
        for (int m = 0; m < creditImaStr.length; m++) {
            for (n = 0; n < pickupImaStr.length; n++) {
                if(pickupImaStr[n].equals(imgTypeCode)){
                    result = 2;
                    break;
                }
            }
            if(result==2){
                break;
            }
            if (creditImaStr[m].equals(imgTypeCode)) {
                result = 1;
                break;
            }
        }
        if(result==1){
        //查询被驳回信审照片
        String pickUrls = orderUrl + "/outOrder/" + orderCode + "/getCreditAdjustImg";
        GetPickupAdjustImgResponse getCreditAdjustImgResponse = restTemplate.getForObject(pickUrls,GetPickupAdjustImgResponse.class);
        if(null != getCreditAdjustImgResponse.getResultData()){
            //修改客户系统被驳回信审照片
            String imgUpdurl = crmUrl + "/images/update/" + userCode;
            ResponseEntity<CilentBaseResponse> baseRespons = null;
            ImgInfo zmResponse = map.get(ImageTypeEnum.IDENTITY_HEAD.getEnumName());
            if (zmResponse !=null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(zmResponse.getImgUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_HEAD);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseRespons = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.getBody().isExecuted()) {
                    wrapper.setSuccess(false);
                    wrapper.setMessage("身份证正面照修改失败");
                    return wrapper;
                }
            }
            ImgInfo fmResponse = map.get(ImageTypeEnum.IDENTITY_EMBLEM.getEnumName());
            if (fmResponse !=null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(fmResponse.getImgUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_EMBLEM);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseRespons = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.getBody().isExecuted()) {
                    wrapper.setSuccess(false);
                    wrapper.setMessage("身份证反面照修改失败");
                    return wrapper;
                }
            }
            ImgInfo scResponse = map.get(ImageTypeEnum.HOLD_IDENTITY.getEnumName());
            if (scResponse !=null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(scResponse.getImgUrl());
                imgj.setImgType(ImageTypeEnum.HOLD_IDENTITY);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseRespons = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.getBody().isExecuted()) {
                    wrapper.setSuccess(false);
                    wrapper.setMessage("手持照修改失败");
                    return wrapper;
                }
            }
            ImgInfo qrResponse = map.get(ImageTypeEnum.CONFIM.getEnumName());
            if (qrResponse !=null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(qrResponse.getImgUrl());
                imgj.setImgType(ImageTypeEnum.CONFIM);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseRespons = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.getBody().isExecuted()) {
                    wrapper.setSuccess(false);
                    wrapper.setMessage("确认照修改失败");
                    return wrapper;
                }
            }
            //修改订单系统被驳回信审照片
            String orderurl = orderUrl + "/outOrder/" + orderCode+"/updateCreditAdjustImg";
            HttpEntity<UpdRejectImgRequest> requestEntit = new HttpEntity<>(rejectImgDTO, httpHeaders);
            ResponseEntity<CilentBaseResponse> baseResponse = restTemplate.exchange(orderurl, HttpMethod.PUT, requestEntit, CilentBaseResponse.class);
            if(baseResponse.getBody().isSuccess() && baseResponse.getBody().isExecuted()){
                wrapper.setSuccess(true);
                return wrapper;
            }else{
                wrapper.setSuccess(false);
                return wrapper;
            }
        }
        }
        if(result==2){
            //查询被驳回提货照
            //String pickUrl = "http://192.168.1.53:8090" + "/outOrder/" + orderCode + "/getPickupAdjustImg";
            String pickUrl = orderUrl + "/outOrder/" + orderCode + "/getPickupAdjustImg";
            GetPickupAdjustImgResponse getPickupAdjustImgResponse = restTemplate.getForObject(pickUrl,GetPickupAdjustImgResponse.class);
            if(null != getPickupAdjustImgResponse.getResultData()){
                //修改被驳回提货照
                //图片修改
                //http://192.168.1.54:8090/outOrder/5635/updatePickupAdjustImg
                String imgurl = orderUrl + "/outOrder/" + orderCode+"/updatePickupAdjustImg";
                ResponseEntity<CilentBaseResponse> baseResponse = null;
                HttpEntity<UpdRejectImgRequest> requestEntity = new HttpEntity<>(rejectImgDTO, httpHeaders);
                baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if(baseResponse.getBody().isSuccess() && baseResponse.getBody().isExecuted()){
                    wrapper.setSuccess(true);
                    return wrapper;
                }else{
                    wrapper.setSuccess(false);
                    return wrapper;
                }
            }
        }
        return wrapper;
    }


    /**
     * 客户端订单列表查询
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getOrderList(String userCode) throws Exception {
        LOGGER.info("调用查询用户订单列表开始,入参userCode:" + userCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //查询用户订单列表
        //http://192.168.1.53:8090/outOrder/56/getOrdersByUserCode
        String stuUrl = orderUrl + "/outOrder/" + userCode + "/getOrdersByUserCode";
        String res = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserOrderListResponse userOrderListResponse = objectMapper.readValue(res, UserOrderListResponse.class);
        if (userOrderListResponse.isSuccess() && userOrderListResponse.isExecuted()) {
            List<UserOrderListInfoResponse> resultData = userOrderListResponse.getResultData();
            OrderListOutResponse orderListOutResponse=new OrderListOutResponse();
            List<OrderOutInfoResponse> list=new ArrayList<>();
            for (int i=0;i<resultData.size();i++) {
                OrderOutInfoResponse order=new OrderOutInfoResponse();
                order.setCommodityName(resultData.get(i).getCommodityName());
                order.setCommodityPrice(resultData.get(i).getCommodityPrice());
                order.setEmpNameCode(resultData.get(i).getEmpNameCode());
                order.setFirstPayMoney(resultData.get(i).getFirstPayMoney());
                order.setImgAuditState(resultData.get(i).getImgAuditState());
                order.setMonthMoney(resultData.get(i).getMonthMoney());
                order.setOrderAuditState(resultData.get(i).getOrderAuditState());
                order.setOrderCode(resultData.get(i).getOrderCode());
                order.setSendMoneyEndTime(resultData.get(i).getSendMoneyEndTime());
                order.setState(resultData.get(i).getState());
                order.setSendAuditState(resultData.get(i).getSendAuditState());
                order.setOrderState(resultData.get(i).getOrderState());
                String time = String.valueOf(resultData.get(i).getPayTime());
                String unit="";
                if(resultData.get(i).getPayTimeUnit()!=null){
                    unit=resultData.get(i).getPayTimeUnit().getDisplayName();
                }
                String payTime = String.format("%s%s", time, unit);
                order.setPayTime(payTime);
                list.add(order);
            }
            response.setData(list);
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }
        LOGGER.info("调用查询用户订单列表结束，response:{" + response + "}");
        return response;
    }

    /**
     * 查询客户还款计划列表
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getPayList(String orderCode) throws Exception {
        LOGGER.info("查询客户还款计划列表,入参orderCode{}:" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        List list=new ArrayList<>();
        //查询客户还款计划列表
        //String url=orderUrl+"/outOrder/"+orderCode+"/getPayBackPlansByOrderCode";
        //"http://order-manager.test.api.aishangjinrong.com/outOrder/4524/getPayBackPlansByOrderCode"
        String url="http://order-manager.test.api.aishangjinrong.com"+"/outOrder/"+orderCode+"/getPayBackPlansByOrderCode";
        String res = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserPayBackPlansResponse userPayBackPlansResponse = objectMapper.readValue(res, UserPayBackPlansResponse.class);
        Map<Byte,String> map=new HashMap<>();
        for (PayTimeType item : PayTimeType.values() ){
            map.put(item.getValue(),item.getDisplayName());
        }
        if (userPayBackPlansResponse.isSuccess() && userPayBackPlansResponse.isExecuted()) {
            List<UserPayBackPlansInfoResponse> resultData = userPayBackPlansResponse.getResultData();
            for (UserPayBackPlansInfoResponse userPayBackPlansInfoResponse : resultData){
                AppPayPlanInfoResponse appPayPlanInfoResponse=new AppPayPlanInfoResponse();
                appPayPlanInfoResponse.setExpectedRepayDate(userPayBackPlansInfoResponse.getExpectedRepayDate());
                appPayPlanInfoResponse.setOverduefineAmount(userPayBackPlansInfoResponse.getOverduefineAmount());
                //appPayPlanInfoResponse.setOverduefineDay(userPayBackPlansInfoResponse.getOverduefineDay());
                appPayPlanInfoResponse.setOverduefineDay(2);
                for (PayTimeType item : PayTimeType.values() ){
                    if(userPayBackPlansInfoResponse.getPayTime()!=null){
                        PayTimeType payTime = userPayBackPlansInfoResponse.getPayTime();
                        if(payTime.getValue().equals(item.getValue())){
                            appPayPlanInfoResponse.setPayTime(map.get(item.getValue()));
                            break;
                        }
                    }
                }
                appPayPlanInfoResponse.setRealRepayTime(userPayBackPlansInfoResponse.getRealRepayTime());
                //appPayPlanInfoResponse.setActualPayMoney(userPayBackPlansInfoResponse.getRealTotalAmount());
                appPayPlanInfoResponse.setActualPayMoney(new BigDecimal(233.5));
                appPayPlanInfoResponse.setState(userPayBackPlansInfoResponse.getPayState());
                appPayPlanInfoResponse.setCurShPayMoney(userPayBackPlansInfoResponse.getShouldTotalAmount());
                list.add(appPayPlanInfoResponse);
            }
            response.setSuccess(true);
            response.setData(list);
        }else{
            response.setSuccess(false);
        }
        LOGGER.info("查询客户还款计划列表，response:{" + response + "}");
        return response;
    }

    /**
     * 添加提货照片接口
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper savePickImage(AddPickupImgRequest addPickupImgRequest, String userCode,String orderCode) throws Exception {
        LOGGER.info("修改提货照片,入参addPickupImgRequest:" + addPickupImgRequest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //String imgurl ="http://192.168.1.53:8090/outOrder/151135251114023XF3ASJ/addPickupImg";
        String imgurl = orderUrl + "/outOrder/" + orderCode + "/addPickupImg";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpEntity<AddPickupImgRequest> requestEntity = new HttpEntity<>(addPickupImgRequest, httpHeaders);
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        baseResponse = restTemplate.exchange(imgurl, HttpMethod.POST, requestEntity, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("图片保存失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("提货照片保存成功");
        LOGGER.info("保存提货照片方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 查询被驳回信审照
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getCreditAdjustImg(String orderCode) throws Exception {
        LOGGER.info("查询被驳回信审照,入参orderCode:" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //查询被驳回信审照片server.order.manager.root=http://192.168.1.53:8090/outOrder/1414/getCreditAdjustImg
        String pickUrl = orderUrl + "/outOrder/" + orderCode + "/getCreditAdjustImg";
        String result = restTemplate.getForObject(pickUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GetCreditAdjustImgResponse getCreditAdjustImgResponse = objectMapper.readValue(result, GetCreditAdjustImgResponse.class);
        if (getCreditAdjustImgResponse.isSuccess() && getCreditAdjustImgResponse.isExecuted()) {
            response.setData(getCreditAdjustImgResponse.getResultData());
        } else {
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setMessage("查询被驳回信审照成功");
        LOGGER.info("查询被驳回信审照方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 查询被驳回提货照
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getPickupAdjustImg(String orderCode) throws Exception {
        LOGGER.info("查询被驳回提货照,入参orderCode:" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //提货照片server.order.manager.root=http://192.168.1.53:8090/outOrder/gfh/getPickupAdjustImg
        String pickUrl = orderUrl + "/outOrder/" + orderCode + "/getPickupAdjustImg";
        String result = restTemplate.getForObject(pickUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GetPickupAdjustImgResponse getPickupAdjustImgResponse = objectMapper.readValue(result, GetPickupAdjustImgResponse.class);
        if (getPickupAdjustImgResponse.isSuccess() && getPickupAdjustImgResponse.isExecuted()) {
            response.setData(getPickupAdjustImgResponse.getResultData());
        } else {
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setMessage("查询被驳回提货照成功");
        LOGGER.info("查询被驳回提货照方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 修改用户驳回的信审照片
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper updateCreditImage(UpdateCreditAdjustImgRequest updateCreditAdjustImgRequest, String userCode, String orderCode) throws Exception {
        LOGGER.info("修改用户照片,入参updateCreditAdjustImgRequest:" + updateCreditAdjustImgRequest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //在订单系统中的修改
        //http://192.168.1.54:8090/outOrder/14/updateCreditAdjustImg
        String orderurl = orderUrl + "/outOrder/" + orderCode+"/updateCreditAdjustImg";
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        HttpEntity<UpdateCreditAdjustImgRequest> requestEntit = new HttpEntity<>(updateCreditAdjustImgRequest, httpHeaders);
        baseResponse = restTemplate.exchange(orderurl, HttpMethod.PUT, requestEntit, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("修改用户驳回的信审照片失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("修改用户驳回的信审照片成功");
        LOGGER.info("修改用户驳回的信审照片方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 修改用户驳回的提货照片
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper updatePickImage(UpdatePickupAdjustImgRequest updatePickupAdjustImgRequest, String userCode, String orderCode) throws Exception {
        LOGGER.info("修改用户驳回的提货照片,入参updatePickupAdjustImgRequest:" + updatePickupAdjustImgRequest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //图片修改
        //http://192.168.1.54:8090/outOrder/5635/updatePickupAdjustImg
        String imgurl = orderUrl + "/outOrder/" + orderCode+"/updatePickupAdjustImg";
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        HttpEntity<UpdatePickupAdjustImgRequest> requestEntity = new HttpEntity<>(updatePickupAdjustImgRequest, httpHeaders);
        baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("修改用户驳回的提货照片失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("修改用户驳回的提货照片成功");
        LOGGER.info("修改用户驳回的提货照片方法结束，response:{" + response + "}");
        return response;
    }


    /**
     * 修改订单状态为待信审
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper updateOrderStateToCredit(String orderCode) throws Exception {
        LOGGER.info("修改订单状态为待信审,入参orderCode:" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //图片修改
        //http://192.168.1.54:8090/outOrder/1545/updateOrderStateToCredit
        String imgurl = orderUrl + "/outOrder/" + orderCode+"/updateOrderStateToCredit";
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("修改状态失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("修改订单状态为待信审成功");
        LOGGER.info("修改订单状态为待信审方法结束，response:{" + response + "}");
        return response;
    }



    /**
     * 通过cunstmerId获取运营商数据
     *
     * @return
     * @throws Exception
     */
    @Async
    public ClientResponseWrapper getWecashMobile(String custmerId) throws Exception {
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Thread.sleep(1000*2*60);
        //通过cunstmerId获取运营商数据
        String wecashUrl = apiUrl + "/wecash/" + custmerId + "/getWecashMobile";
        // String wecashUrl = "http://apiserver.test.api.aishangjinrong.com"+ "/wecash/" + custmerId + "/getWecashMobile";
        ResponseEntity<WecashrResponse> wecashrResponseResponseEntity = restTemplate.postForEntity(wecashUrl, null, WecashrResponse.class);
        LOGGER.info("wecashResponse{}", wecashrResponseResponseEntity.getBody());
        return response;
    }


    /**
     * 查询设备串码是否必填
     * @param orderCode
     * @return
     */
    public ClientResponseWrapper queryIsMustDeImeIcode(String orderCode) {
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        MustImeiResponse imeiResponse = new MustImeiResponse();
        LOGGER.info("查询设备串码是否必填开始:{}", wrapper);
        //根据订单编号查询商品code
        String orderInfoUrl =  orderUrl+orderInfosUrl;
        OrderResponse orderResponse = restTemplate.getForObject(orderInfoUrl,OrderResponse.class,Collections.singletonMap("orderCode", orderCode));
        if(null == orderResponse.getData()){
            wrapper.setSuccess(false);
            return wrapper;
        }
        String commodityCode = orderResponse.getData().getCommodityCode();
        String url = mallRootUrl + isMustDeImeIcodeUrl;
        CommodityMustImeiResponse response = MyRestTemplate.getInstace().getForObject(url, CommodityMustImeiResponse.class, Collections.singletonMap("commodityCode", commodityCode));
        if(response.isSuccess() && response.isExecuted()){
            if(null != response.getIsMustDeImeIcode()){
                LOGGER.info("设备串码:{}",response.getIsMustDeImeIcode().getValue().toString());
                if(response.getIsMustDeImeIcode().getValue().toString().equals("1")){
                    imeiResponse.setRequired("1");
                    wrapper.setData(imeiResponse);
                    wrapper.setSuccess(true);
                }else{
                    imeiResponse.setRequired("0");
                    wrapper.setSuccess(false);
                    wrapper.setData(imeiResponse);
                    return wrapper;
                }
            }
        }
        return wrapper;
    }

    /**
     * 查询服务密码授权页面的参数
     * @param orderCode
     * @return
     */
    public ClientResponseWrapper queryAuth(String orderCode) {
        LOGGER.info("查询服务密码授权页面的参数,入参orderCode:" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        OrderAuthResponse orderAuthResponse=new OrderAuthResponse();
        String custmerId="";
        //根据orderCode获取customerId、isAuth、isTelephone
        //http://192.168.1.54:8090/outOrder/151135469362634XF3ASJ/getOrderInfoByOrderCode
        String orUrl=orderUrl + "/outOrder/" + orderCode+"/getOrderInfoByOrderCode";
        OrderManagerResponse orderManagerResponse = restTemplate.getForObject(orUrl, OrderManagerResponse.class);
        if(orderManagerResponse.isExecuted()&&orderManagerResponse.isSuccess()){
            custmerId=orderManagerResponse.getData().getAuthCode();
            if(WhetherEnum.YES.getValue().equals(orderManagerResponse.getData().getIsAuth())){
                orderAuthResponse.setAuth(true);
            }else{
                orderAuthResponse.setAuth(false);
            }
            if(WhetherEnum.YES.getValue().equals(orderManagerResponse.getData().getIsTelephonedirectory())){
                orderAuthResponse.setDirect(true);
            }else{
                orderAuthResponse.setDirect(false);
            }
        }else{
            orderAuthResponse.setAuth(false);
            orderAuthResponse.setDirect(false);
        }
        //根据custmerId查询手机号和密码
        //server.api.acc.pwd.url=/wecash/users/{custmerId}/user
        String apiUrl=apiRootUrl+"/wecash/users/"+custmerId+"/user";
        UserCustResponse userCustResponse = restTemplate.getForObject(apiUrl, UserCustResponse.class);
        if(userCustResponse.isSuccess()){
            orderAuthResponse.setPassWord(userCustResponse.getData().getPassWord());
            orderAuthResponse.setUserAccount(userCustResponse.getData().getUserAccount());
        }
        orderAuthResponse.setAuthCode(custmerId);
        response.setSuccess(true);
        response.setData(orderAuthResponse);
        LOGGER.info("查询服务密码授权页面的参数方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 修改订单为运营商已授权
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper updateOrderIsAuth(String orderCode,String userCode) throws Exception {
        LOGGER.info("修改订单为运营商已授权,入参{}" + orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        boolean selfOrder = this.isSelfOrder(orderCode, userCode);
        if(!selfOrder){
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
        //http://192.168.1.54:8090/outOrder/1545/updateOrderIsAuth
        String imgurl = orderUrl + "/outOrder/" + orderCode+"/updateOrderIsAuth";
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("成功");
        LOGGER.info("修改订单为运营商已授权方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 判断该订单是否为本人订单
     *
     * @return
     * @throws Exception
     */
    public boolean isSelfOrder(String orderCode,String userCode) throws Exception {
        boolean resul = false;
        //查询用户订单列表
        //http://192.168.1.53:8090/outOrder/56/getOrdersByUserCode
        String stuUrl = orderUrl + "/outOrder/" + userCode + "/getOrdersByUserCode";
        String result = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserOrderListResponse userOrderListResponse = objectMapper.readValue(result, UserOrderListResponse.class);
        if (userOrderListResponse.isSuccess() && userOrderListResponse.isExecuted()) {
            List<UserOrderListInfoResponse> resultData = userOrderListResponse.getResultData();
            for (int i = 0; i < resultData.size(); i++) {
                String orderCycleCode = resultData.get(i).getOrderCode();
                if (orderCode.equals(orderCycleCode) ) {
                    resul = true;
                    break;
                }
            }
        } else {
            return false;
        }
        return resul;
    }

    /**
     * 获取订单详情
     *
     * @return
     * @throws Exception
     */
    public JsonNode getOrderInfo(String orderCode) throws Exception {
        LOGGER.info("获取订单详情,入参{}" + orderCode);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String imgurl = orderUrl + "/outOrder/" + orderCode+"/getOrderInfoByOrderCode";
        JsonNode resultData = null;
        JsonNode jsonNode = restTemplate.getForObject(imgurl, JsonNode.class);
        if (jsonNode.get("executed").asBoolean()) {
            resultData= jsonNode.get("data");
        }
        LOGGER.info("获取订单详情方法结束，resultData:{" + resultData + "}");
        return resultData;
    }

    /**
     * 接收小雨点签约成功的异步通知
     *
     * @return
     * @throws Exception
     */
    public CilentXydResponse updateXydSigResult(String orderCode) throws Exception {
        CilentXydResponse response = new CilentXydResponse();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String receiveResuUrl=orderUrl+"/outOrder/"+orderCode+"/updateOrderSignByOrderCode";
        OrderSignRequest orderSignRequest=new OrderSignRequest();
        orderSignRequest.setMoneyResource(MoneyResourceEnum.XYD.getValue());
        HttpEntity<OrderSignRequest> requestEntity = new HttpEntity<>(orderSignRequest, httpHeaders);
        ResponseEntity<CilentBaseResponse> exchange = restTemplate.exchange(receiveResuUrl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
        if(exchange.getBody().isExecuted()&&exchange.getBody().isSuccess()){
            response.setSuccess(true);
            response.setMessage("修改成功");
            return response;
        }else{
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
    }

    /**
     * 修改还款计划状态(还款状态 1,成功 2,还款中 3,待还款)
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper updateOrderSignPayState(String orderCode,String payTime,String payState) throws Exception {
        LOGGER.info("修改还款计划状态,入参{}" + orderCode,payTime,payState);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //http://order-manager.test.api.aishangjinrong.com/outOrder/151135469345375XF3ASJ/12/2/updateOrderSignPayState
        //String url = "http://order-manager.test.api.aishangjinrong.com" + "/outOrder/" + orderCode+"/"+payTime+"/"+payState+"/updateOrderSignPayState";
        String url = orderUrl + "/outOrder/" + orderCode+"/"+payTime+"/"+payState+"/updateOrderSignPayState";
        ResponseEntity<PayStateResponse> baseResponse = null;
        baseResponse = restTemplate.exchange(url, HttpMethod.PUT, null, PayStateResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("成功");
        LOGGER.info("修改还款计划状态方法结束，response:{" + response + "}");
        return response;
    }


}
