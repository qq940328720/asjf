package com.aishang.asjf.client.crmserver;

import com.aishang.asjf.client.apiserver.response.BankResponse;
import com.aishang.asjf.client.apiserver.response.info.BankListInfoResponse;
import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.enums.*;
import com.aishang.asjf.client.crmserver.request.*;
import com.aishang.asjf.client.crmserver.response.*;
import com.aishang.asjf.client.orderserver.OrderServerClient;
import com.aishang.asjf.client.orderserver.enums.OrderStatusEnum;
import com.aishang.asjf.client.orderserver.request.PushDataRequest.*;
import com.aishang.asjf.client.orderserver.response.OrderResponse;
import com.aishang.asjf.client.product.ProductServerClient;
import com.aishang.asjf.client.utils.MyObjectMapper;
import com.aishang.asjf.client.utils.MyRestTemplate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 客户系统接口客户端
 */
@Component
public class CrmServerClient {

    @Value("${server.order.manager.root}")
    private String orderUrl;

    @Value("${server.crm.manager.root}" + "${server.crm.manager.url}")
    private String crmUrl;

    @Value("${server.api.manager.root}")
    private String apiUrl;

    @Value("${asjf.server.url.root}")
    private String asjfRootUrl;

    @Value("${asjf.wecash.callback.url}")
    private String callback;

    @Value("${server.dic.manager.url}")
    private String dicArea;

    @Value("${server.dictionary.manager.root}")
    private String dicRootUrl;

    @Value("${server.dic.bank.name.url}")
    private String dicBankNameUrl;

    @Value("${server.crm.manager.root}")
    private String crmRootUrl;//客户系统服务地址

    @Value("${server.bank.bin.url}")
    private String crmBankBinUrl;//验证银行卡bin

    @Value("${server.dictionary.manager.root}")
    private String dictRootUrl;//字典服务地址

    @Value("${server.bank.url}")
    private String dictBankRootUrl;//字典服务地址

    @Value("${server.funds.manager.root}")
    private String fundsUrl;//资金渠道服务地址

    @Value("${server.product.manager.root}")
    private String productUrl;//资金渠道服务地址

    @Value("${asjf.as.callback.url}")
    private String asCallbackUrl;//资金渠道服务地址

    @Value("${firmNo.url}")
    private String firmNo;//资金渠道服务地址

    @Value("${sever.dic.qrBankCode.url}")
    private String qryBankUrl;//资金渠道服务地址

    @Autowired
    private OrderServerClient orderClient;

    @Autowired
    private ProductServerClient productClient;

    private RestTemplate restTemplate = MyRestTemplate.getInstace();

    private ObjectMapper objectMapper = MyObjectMapper.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(CrmServerClient.class);

    private Integer dayfifteen = 15;

    public boolean reg(String userPhone, String userCode) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String bankurl = crmUrl + "/user/save";
        Map<String, String> map = new HashMap<>(2);
        map.put("userPhone", userPhone);
        map.put("userCode", userCode);
        HttpEntity<Map> req = new HttpEntity<>(map, httpHeaders);
        CilentBaseResponse baseResponse = restTemplate.postForObject(bankurl, req, CilentBaseResponse.class);
        return (baseResponse.isSuccess() || baseResponse.isExecuted());
    }

    /**
     * 保存用户基本信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveUserBaseInfo(UserSaveBaseRequest userSaveBaseRequest, String userCode) throws Exception {
        LOGGER.info("调用保存用户基本信息方法开始:{}", userSaveBaseRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        String name = userSaveBaseRequest.getUserName();
        String idcert = userSaveBaseRequest.getUserNationalid();
        //身份证和姓名的二要素验证
        //http://192.168.1.54:8091/out/idenetity/verification/%E5%90%B4%E8%88%AA%E5%85%B5/610431199409254614/563
        String validateUrl = crmUrl + "/idenetity/verification/" + name + "/" + idcert + "/" + userCode;
        ResponseEntity<CilentBaseResponse> exchange = restTemplate.exchange(validateUrl, HttpMethod.GET, null, CilentBaseResponse.class);
        if (!exchange.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
        //保存个人基本信息
        String userUrl = crmUrl + "/user/update/" + userCode + "/info";
        UserDetailRequest userDetailRequest = new UserDetailRequest();
        String rangeStr = userSaveBaseRequest.getValiddaterange();
        String range = rangeStr.substring(0, 4) + "-" + rangeStr.substring(4, 6) + "-" + rangeStr.substring(6, 8);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long identy = sdf.parse(range).getTime();
        long currentDate = new Date().getTime();
        long sy = identy - new Date().getTime();
        if (sy < (-2 * 24 * 60 * 60 * 1000)) {
            response.setMessage("4");//小于今天
            response.setSuccess(false);
            return response;
        }
        if (sy / (24 * 60 * 60 * 1000) < dayfifteen) {
            response.setMessage("3");//身份证有效期数小于15天
            response.setSuccess(false);
            return response;
        }
        userDetailRequest.setUserValiddaterange(sdf.parse(range));//身份证有效期 0000-00-00为长期
        userDetailRequest.setUserGender(userSaveBaseRequest.getUserGender());
        userDetailRequest.setUserHomeaddress(userSaveBaseRequest.getRegisterAddress());
        userDetailRequest.setUserIsmarried(userSaveBaseRequest.getUserIsmarried());
        userDetailRequest.setUserName(userSaveBaseRequest.getUserName());
        userDetailRequest.setUserNationalid(userSaveBaseRequest.getUserNationalid());
        userDetailRequest.setClientResource(userSaveBaseRequest.getClientResource());
        userDetailRequest.setIsFormal(IsFormalEnum.YES);
        HttpEntity<UserDetailRequest> request = new HttpEntity<>(userDetailRequest, httpHeaders);
        LOGGER.debug("转换后参数:{}", request);
        ResponseEntity<CilentBaseResponse> baseRespon = null;
        baseRespon = restTemplate.exchange(userUrl, HttpMethod.PUT, request, CilentBaseResponse.class);
        if (!baseRespon.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("用户个人信息添加失败");
            return response;
        }
        //查询照片信息
        String imgUrl = crmUrl + "/images/query/" + userCode;
        String res = restTemplate.getForObject(imgUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserImgResponse userImgResponse = objectMapper.readValue(res, UserImgResponse.class);
        if (userImgResponse.isSuccess() && userImgResponse.isExecuted()) {
            String imgUpdurl = crmUrl + "/images/update/" + userCode;
            ResponseEntity<CilentBaseResponse> baseResponse = null;
            List<UserImgInfoResponse> data = userImgResponse.getData();
            Map<Byte, UserImgInfoResponse> mapResponse = new HashMap<>();
            for (UserImgInfoResponse imageInfo : data) {
                mapResponse.put(imageInfo.getImgType().getValue(), imageInfo);
            }
            UserImgInfoResponse zmResponse = mapResponse.get(ImageTypeEnum.IDENTITY_HEAD.getValue());
            if (zmResponse == null) {
                //身份证正面照保存
                String iimgurl = crmUrl + "/images/save";
                //ResponseEntity<CilentBaseResponse> baseResponse = null;
                SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
                List<UserImgRequest> list = new ArrayList<>();
                UserImgRequest imgj = new UserImgRequest();
                imgj.setImgUrl(userSaveBaseRequest.getZmImaUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_HEAD);
                imgj.setUserCode(userCode);
                list.add(imgj);
                saveUserImgRequest.setData(list);
                //SaveUserImgRequest saveUserImgRequest=new SaveUserImgRequest();
                HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
                CilentBaseResponse baseRespons = null;
                baseRespons = restTemplate.postForObject(iimgurl, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("图片添加失败");
                    return response;
                }
            } else {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(userSaveBaseRequest.getZmImaUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_HEAD);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseResponse = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseResponse.getBody().isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("身份证正面照修改失败");
                    return response;
                }
            }
            UserImgInfoResponse fmResponse = mapResponse.get(ImageTypeEnum.IDENTITY_EMBLEM.getValue());
            //身份证反面照
            if (fmResponse != null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(userSaveBaseRequest.getFmImaUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_EMBLEM);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseResponse = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseResponse.getBody().isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("身份证反面照修改失败");
                    return response;
                }
            } else {
                //身份证反面照保存
                String iimgurl = crmUrl + "/images/save";
                //ResponseEntity<CilentBaseResponse> baseResponse = null;
                SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
                List<UserImgRequest> list = new ArrayList<>();
                UserImgRequest imgj = new UserImgRequest();
                imgj.setImgUrl(userSaveBaseRequest.getFmImaUrl());
                imgj.setImgType(ImageTypeEnum.IDENTITY_EMBLEM);
                imgj.setUserCode(userCode);
                list.add(imgj);
                saveUserImgRequest.setData(list);
                //SaveUserImgRequest saveUserImgRequest=new SaveUserImgRequest();
                HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
                CilentBaseResponse baseRespons = null;
                baseRespons = restTemplate.postForObject(iimgurl, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("图片添加失败");
                    return response;
                }
            }
            //手持照
            UserImgInfoResponse scResponse = mapResponse.get(ImageTypeEnum.HOLD_IDENTITY.getValue());
            if (scResponse != null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(userSaveBaseRequest.getScImaUrl());
                imgj.setImgType(ImageTypeEnum.HOLD_IDENTITY);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseResponse = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseResponse.getBody().isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("身份证手持照修改失败");
                    return response;
                }
            } else {
                //手持照保存
                String iimgurl = crmUrl + "/images/save";
                //ResponseEntity<CilentBaseResponse> baseResponse = null;
                SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
                List<UserImgRequest> list = new ArrayList<>();
                UserImgRequest imgj = new UserImgRequest();
                imgj.setImgUrl(userSaveBaseRequest.getScImaUrl());
                imgj.setImgType(ImageTypeEnum.HOLD_IDENTITY);
                imgj.setUserCode(userCode);
                list.add(imgj);
                saveUserImgRequest.setData(list);
                //SaveUserImgRequest saveUserImgRequest=new SaveUserImgRequest();
                HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
                CilentBaseResponse baseRespons = null;
                baseRespons = restTemplate.postForObject(iimgurl, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("图片添加失败");
                    return response;
                }
            }
            //确认照
            UserImgInfoResponse qrResponse = mapResponse.get(ImageTypeEnum.CONFIM.getValue());
            if (qrResponse != null) {
                UpdateImaRequest imgj = new UpdateImaRequest();
                imgj.setImgUrl(userSaveBaseRequest.getQrImaUrl());
                imgj.setImgType(ImageTypeEnum.CONFIM);
                HttpEntity<UpdateImaRequest> requestEntity = new HttpEntity<>(imgj, httpHeaders);
                baseResponse = restTemplate.exchange(imgUpdurl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
                if (!baseResponse.getBody().isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("确认照修改失败");
                    return response;
                }
            } else {
                //图片保存
                String iimgurl = crmUrl + "/images/save";
                //ResponseEntity<CilentBaseResponse> baseResponse = null;
                SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
                List<UserImgRequest> list = new ArrayList<>();
                UserImgRequest imgj = new UserImgRequest();
                imgj.setImgUrl(userSaveBaseRequest.getQrImaUrl());
                imgj.setImgType(ImageTypeEnum.CONFIM);
                imgj.setUserCode(userCode);
                list.add(imgj);
                saveUserImgRequest.setData(list);
                //SaveUserImgRequest saveUserImgRequest=new SaveUserImgRequest();
                HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
                CilentBaseResponse baseRespons = null;
                baseRespons = restTemplate.postForObject(iimgurl, requestEntity, CilentBaseResponse.class);
                if (!baseRespons.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("图片添加失败");
                    return response;
                }
            }
        } else {
            //图片保存
            String imgurl = crmUrl + "/images/save";
            //ResponseEntity<CilentBaseResponse> baseResponse = null;
            SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
            List<UserImgRequest> list = new ArrayList<>();
            UserImgRequest imgj = new UserImgRequest();
            imgj.setImgUrl(userSaveBaseRequest.getZmImaUrl());
            imgj.setImgType(ImageTypeEnum.IDENTITY_HEAD);
            imgj.setUserCode(userCode);
            list.add(imgj);
            UserImgRequest imgb = new UserImgRequest();
            imgb.setImgUrl(userSaveBaseRequest.getFmImaUrl());
            imgb.setImgType(ImageTypeEnum.IDENTITY_EMBLEM);
            imgb.setUserCode(userCode);
            list.add(imgb);
            UserImgRequest imgh = new UserImgRequest();
            imgh.setImgUrl(userSaveBaseRequest.getScImaUrl());
            imgh.setImgType(ImageTypeEnum.HOLD_IDENTITY);
            imgh.setUserCode(userCode);
            list.add(imgh);
            UserImgRequest imgc = new UserImgRequest();
            imgc.setImgUrl(userSaveBaseRequest.getQrImaUrl());
            imgc.setImgType(ImageTypeEnum.CONFIM);
            imgc.setUserCode(userCode);
            list.add(imgc);
            saveUserImgRequest.setData(list);
            //SaveUserImgRequest saveUserImgRequest=new SaveUserImgRequest();
            HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
            CilentBaseResponse baseRespons = null;
            baseRespons = restTemplate.postForObject(imgurl, requestEntity, CilentBaseResponse.class);
            if (!baseRespons.isExecuted()) {
                response.setSuccess(false);
                response.setMessage("图片添加失败");
                return response;
            }
        }
        //查询新住址信息
        String addUrl = crmUrl + "/user/" + userCode + "/getUserAddress";
        String resu = restTemplate.getForObject(addUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserAddressResponse userAddressResponse = objectMapper.readValue(resu, UserAddressResponse.class);
        if (userAddressResponse.isSuccess() && userAddressResponse.isExecuted()) {
            //修改现住址
            //http://192.168.1.245:8091/out/user/159/updateAddress
            String addurl = crmUrl + "/user/" + userCode + "/updateAddress";
            UserAddressAddRequest userAddressAddRequest = new UserAddressAddRequest();
            userAddressAddRequest.setCityCode(userSaveBaseRequest.getCityCode());
            userAddressAddRequest.setDistrictCode(userSaveBaseRequest.getDistrictCode());
            userAddressAddRequest.setHomeAddress(userSaveBaseRequest.getNowAddress());
            userAddressAddRequest.setProvinceCode(userSaveBaseRequest.getProvinceCode());
            HttpEntity<UserAddressAddRequest> requestEntit = new HttpEntity<>(userAddressAddRequest, httpHeaders);
            ResponseEntity<CilentBaseResponse> baseRespons = restTemplate.exchange(addurl, HttpMethod.PUT, requestEntit, CilentBaseResponse.class);
            if (!baseRespons.getBody().isExecuted()) {
                response.setSuccess(false);
                response.setMessage("现住址添加失败");
                return response;
            }
        } else {
            //保存现住址
            String addurl = crmUrl + "/user/addUserAddress";
            UserAddressAddRequest userAddressAddRequest = new UserAddressAddRequest();
            userAddressAddRequest.setCityCode(userSaveBaseRequest.getCityCode());
            userAddressAddRequest.setDistrictCode(userSaveBaseRequest.getDistrictCode());
            userAddressAddRequest.setHomeAddress(userSaveBaseRequest.getNowAddress());
            userAddressAddRequest.setProvinceCode(userSaveBaseRequest.getProvinceCode());
            userAddressAddRequest.setCode(userCode);
            HttpEntity<UserAddressAddRequest> requestEntit = new HttpEntity<>(userAddressAddRequest, httpHeaders);
            CilentBaseResponse baseRespons = restTemplate.postForObject(addurl, requestEntit, CilentBaseResponse.class);
            if (!baseRespons.isExecuted()) {
                response.setSuccess(false);
                response.setMessage("现住址添加失败");
                return response;
            }
        }
        //修改用户资料完善度
        String dataCompletion = "BASE";
        //String userUrl="http://192.168.1.53:8091/out/user/update/dataCompletion/CONTACT/CUST2017112709382578882";
        String url = crmUrl + "/user/update/dataCompletion/" + dataCompletion + "/" + userCode;
        ResponseEntity<CilentBaseResponse> baseRespons = null;
        baseRespons = restTemplate.exchange(url, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespons.getBody().isExecuted()) {
            response.setMessage("修改用户资料完善度失败");
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setMessage("基本信息保存成功");
        LOGGER.info("调用保存用户基本信息方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 保存工作信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveWorkInfo(UserSaveWorkResquest userSaveWorkResquest, String userCode) throws Exception {
        LOGGER.info("调用保存用户工作信息方法开始,入参userSaveWorkResquest:{" + userSaveWorkResquest + "}");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //查询工作信息
        String stuUrl = crmUrl + "/userWork/query/" + userCode;
        String res = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserWorkResponse userResponseDT = objectMapper.readValue(res, UserWorkResponse.class);
        if (userResponseDT.isSuccess() && userResponseDT.isExecuted()) {
            //修改用户工作信息
            //http://192.168.1.245:8091/out/userWork/update/60
            String userUrl = crmUrl + "/userWork/update/" + userCode;
            SaveWorkInfoRequest saveWorkInfoRequest = new SaveWorkInfoRequest();
            saveWorkInfoRequest.setwAddressCompanyName(userSaveWorkResquest.getwAddressCompanyName());
            saveWorkInfoRequest.setwAddressDetail(userSaveWorkResquest.getwAddressDetail());
            saveWorkInfoRequest.setwAddressMobile(userSaveWorkResquest.getwAddressMobile());
            saveWorkInfoRequest.setWorkJob(userSaveWorkResquest.getProfession());
            saveWorkInfoRequest.setWorkPost(userSaveWorkResquest.getWorkPosition());
            HttpEntity<SaveWorkInfoRequest> request = new HttpEntity<>(saveWorkInfoRequest, httpHeaders);
            ResponseEntity<CilentBaseResponse> baseRespon = null;
            LOGGER.debug("保存客户联系人请求参数:{}", request.toString());
            baseRespon = restTemplate.exchange(userUrl, HttpMethod.PUT, request, CilentBaseResponse.class);
            if (!baseRespon.getBody().isExecuted()) {
                response.setSuccess(false);
                response.setMessage("用户工作信息保存失败");
                return response;
            }
        } else {
            //保存工作信息
            String detailUrl = crmUrl + "/userWork/save";
            SaveWorkInfoRequest saveWorkInfoRequest = new SaveWorkInfoRequest();
            saveWorkInfoRequest.setUserCode(userCode);
            saveWorkInfoRequest.setwAddressCompanyName(userSaveWorkResquest.getwAddressCompanyName());
            saveWorkInfoRequest.setwAddressDetail(userSaveWorkResquest.getwAddressDetail());
            saveWorkInfoRequest.setwAddressMobile(userSaveWorkResquest.getwAddressMobile());
            saveWorkInfoRequest.setWorkJob(userSaveWorkResquest.getProfession());
            saveWorkInfoRequest.setWorkPost(userSaveWorkResquest.getWorkPosition());
            HttpEntity<SaveWorkInfoRequest> reques = new HttpEntity<>(saveWorkInfoRequest, httpHeaders);
            CilentBaseResponse baseRespone = null;
            LOGGER.debug("保存客户联系人请求参数:{}", reques.toString());
            baseRespone = restTemplate.postForObject(detailUrl, reques, CilentBaseResponse.class);
            if (!baseRespone.isExecuted()) {
                response.setSuccess(false);
                response.setMessage("用户个人信息保存失败");
                return response;
            }
        }
        //更新用户基本信息
        //http://192.168.1.245:8091/user/update/60/info
        String userUrl = crmUrl + "/user/update/" + userCode + "/info";
        ClientWorkDetailResquest clientWorkDetailResquest = new ClientWorkDetailResquest();
        clientWorkDetailResquest.setUserHighesteducation(userSaveWorkResquest.getUserHighesteducation());
        clientWorkDetailResquest.setUserIncome(userSaveWorkResquest.getUserIncome());
        clientWorkDetailResquest.setUserIncomeResource(userSaveWorkResquest.getUserIncomeResource());
        clientWorkDetailResquest.setIsFormal(IsFormalEnum.YES);
        HttpEntity<ClientWorkDetailResquest> request = new HttpEntity<>(clientWorkDetailResquest, httpHeaders);
        ResponseEntity<CilentBaseResponse> baseRespon = null;
        baseRespon = restTemplate.exchange(userUrl, HttpMethod.PUT, request, CilentBaseResponse.class);
        if (!baseRespon.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("用户基本信息保存失败");
            return response;
        }
        //修改用户资料完善度
        String dataCompletion = "WORK";
        //String userUrl="http://192.168.1.53:8091/out/user/update/dataCompletion/CONTACT/CUST2017112709382578882";
        String url = crmUrl + "/user/update/dataCompletion/" + dataCompletion + "/" + userCode;
        ResponseEntity<CilentBaseResponse> baseRespons = null;
        baseRespons = restTemplate.exchange(url, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespons.getBody().isExecuted()) {
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setMessage("工作信息保存成功");
        LOGGER.info("调用保存用户工作信息方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 保存联系人信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveContactInfo(SaveLinkerListRequest saveLinkerListRequest, String userCode) throws Exception {
        LOGGER.info("调用保存用户联系人方法开始入参{}", saveLinkerListRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //先查询用户联系人信息
        String url = crmUrl + "/userLinker/query?userCode=" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//ObjectMapper转换忽略多余字段
        UserLinkerResponse userResponseDTO = objectMapper.readValue(ret, UserLinkerResponse.class);
        if (userResponseDTO.isSuccess() && userResponseDTO.isExecuted()) {
            //修改联系人信息
            //http://192.168.1.54:8091/out/userLinker/484848/update
            String linkUrl = crmUrl + "/userLinker/" + userCode + "/update";
            List<SaveLinkerRequest> linkerList = saveLinkerListRequest.getLinkerList();
            SaveUserLinkerListRequest saveUserLinkerListRequest = new SaveUserLinkerListRequest();
            List<SaveUserLinkerRequest> list = new ArrayList<>();
            if (linkerList != null && linkerList.size() > 0) {
                for (int i = 0; i < linkerList.size(); i++) {
                    SaveUserLinkerRequest saveUserLinkerRequest = new SaveUserLinkerRequest();
                    saveUserLinkerRequest.setCityCode(saveLinkerListRequest.getLinkerList().get(i).getCityCode());
                    saveUserLinkerRequest.setContactNcontactname(saveLinkerListRequest.getLinkerList().get(i).getNo());
                    saveUserLinkerRequest.setDistrictCode(saveLinkerListRequest.getLinkerList().get(i).getDistrictCode());
                    saveUserLinkerRequest.setHomeAddress(saveLinkerListRequest.getLinkerList().get(i).getHomeAddress());
                    saveUserLinkerRequest.setLinkerName(saveLinkerListRequest.getLinkerList().get(i).getLinkerName());
                    saveUserLinkerRequest.setLinkPhone(saveLinkerListRequest.getLinkerList().get(i).getLinkPhone());
                    saveUserLinkerRequest.setLinkRelation(saveLinkerListRequest.getLinkerList().get(i).getRelation());
                    saveUserLinkerRequest.setProvinceCode(saveLinkerListRequest.getLinkerList().get(i).getProvinceCode());
                    saveUserLinkerRequest.setUserCode(userCode);
                    list.add(saveUserLinkerRequest);
                }
                saveUserLinkerListRequest.setLinkerList(list);
            }
            HttpEntity<SaveUserLinkerListRequest> requestEntity = new HttpEntity<>(saveUserLinkerListRequest, httpHeaders);
            ResponseEntity<CilentBaseResponse> baseResponse = restTemplate.exchange(linkUrl, HttpMethod.PUT, requestEntity, CilentBaseResponse.class);
            if (!baseResponse.getBody().isExecuted()) {
                response.setSuccess(false);
                response.setMessage("联系人保存失败");
                return response;
            }
        } else {
            //保存联系人基本信息
            String linkUrl = crmUrl + "/userLinker/save";
            List<SaveLinkerRequest> linkerList = saveLinkerListRequest.getLinkerList();
            SaveUserLinkerListRequest saveUserLinkerListRequest = new SaveUserLinkerListRequest();
            List<SaveUserLinkerRequest> list = new ArrayList<>();
            if (linkerList != null && linkerList.size() > 0) {
                for (int i = 0; i < linkerList.size(); i++) {
                    SaveUserLinkerRequest saveUserLinkerRequest = new SaveUserLinkerRequest();
                    saveUserLinkerRequest.setCityCode(saveLinkerListRequest.getLinkerList().get(i).getCityCode());
                    saveUserLinkerRequest.setContactNcontactname(saveLinkerListRequest.getLinkerList().get(i).getNo());
                    saveUserLinkerRequest.setDistrictCode(saveLinkerListRequest.getLinkerList().get(i).getDistrictCode());
                    saveUserLinkerRequest.setHomeAddress(saveLinkerListRequest.getLinkerList().get(i).getHomeAddress());
                    saveUserLinkerRequest.setLinkerName(saveLinkerListRequest.getLinkerList().get(i).getLinkerName());
                    saveUserLinkerRequest.setLinkPhone(saveLinkerListRequest.getLinkerList().get(i).getLinkPhone());
                    saveUserLinkerRequest.setLinkRelation(saveLinkerListRequest.getLinkerList().get(i).getRelation());
                    saveUserLinkerRequest.setProvinceCode(saveLinkerListRequest.getLinkerList().get(i).getProvinceCode());
                    saveUserLinkerRequest.setUserCode(userCode);
                    list.add(saveUserLinkerRequest);
                }
                saveUserLinkerListRequest.setLinkerList(list);
            }
            HttpEntity<SaveUserLinkerListRequest> requestEntity = new HttpEntity<>(saveUserLinkerListRequest, httpHeaders);
            CilentBaseResponse baseResponse = null;
            baseResponse = restTemplate.postForObject(linkUrl, requestEntity, CilentBaseResponse.class);
            if (!baseResponse.isExecuted()) {
                response.setSuccess(false);
                response.setMessage("联系人保存失败");
                return response;
            }
        }
        //更新用户基本信息
        //http://192.168.1.245:8091/user/update/60/info
        String userUrl = crmUrl + "/user/update/" + userCode + "/info";
        ClientWorkDetailResquest clientWorkDetailResquest = new ClientWorkDetailResquest();
        clientWorkDetailResquest.setIsFormal(IsFormalEnum.YES);
        HttpEntity<ClientWorkDetailResquest> request = new HttpEntity<>(clientWorkDetailResquest, httpHeaders);
        ResponseEntity<CilentBaseResponse> baseRespon = null;
        baseRespon = restTemplate.exchange(userUrl, HttpMethod.PUT, request, CilentBaseResponse.class);
        if (!baseRespon.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("用户基本信息保存失败");
            return response;
        }
        //修改用户资料完善度
        String dataCompletion = "CONTACT";
        //String userUrl="http://192.168.1.53:8091/out/user/update/dataCompletion/CONTACT/CUST2017112709382578882";
        String workurl = crmUrl + "/user/update/dataCompletion/" + dataCompletion + "/" + userCode;
        ResponseEntity<CilentBaseResponse> baseRespons = null;
        baseRespons = restTemplate.exchange(workurl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespons.getBody().isExecuted()) {
            response.setSuccess(false);
            return response;
        }
        response.setSuccess(true);
        response.setMessage("用户联系人信息保存成功");
        LOGGER.info("调用保存用户联系人方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 保存用户银行卡信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveBankInfo(UserBankResquest resquest, String userCode) throws Exception {
        LOGGER.info("调用保存银行卡信息方法开始:{}", resquest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //查询用户资料完善度
        //http://192.168.1.53:8091/out/user/getDataCompletion/CUST2017112709382578882
        String urll = crmUrl + "/user/getDataCompletion/" + userCode;
        String rett = restTemplate.getForObject(urll, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserProfileCompleteResponse userResponse = null;
        userResponse = objectMapper.readValue(rett, UserProfileCompleteResponse.class);
        if (userResponse.isExecuted() && userResponse.isSuccess()) {
            List<UserProfileCompleteResponse.Data> userProfileComplete = userResponse.getUserProfileComplete();
            boolean completed = userProfileComplete.get(0).isCompleted();
            if (!completed) {
                response.setSuccess(false);
                response.setMessage("4");
                return response;
            }
        }
        //卡bin验证
        Map maps = new HashMap();
        maps.put("verificationBankno", resquest.getBankCardnumber());
        maps.put("userCode", userCode);
        String bankBinUrl = crmRootUrl + crmBankBinUrl;
        String string = restTemplate.postForObject(bankBinUrl, maps, String.class);
        BankbinResponse bankbinResponse = objectMapper.readValue(string, BankbinResponse.class);
        if (!bankbinResponse.isSuccess() && !bankbinResponse.isExecuted()) {
            response.setMessage("1");
            return response;
        }
        LOGGER.info("卡宾验证输出的message:{}", bankbinResponse.getMessage());
        if (null != bankbinResponse.getMessage()) {
            //信用卡
            if (bankbinResponse.getMessage().indexOf("信用卡") != -1) {
                response.setMessage("2");
                return response;
            }
            LOGGER.info("判断银行卡列表是否支持该银行卡:{}");
            //输入的银行卡是否在支持的银行卡列表
            if (bankbinResponse.getMessage().equals("暂不支持该银行!")) {
                response.setMessage("3");
                return response;
            }
            LOGGER.info("银行卡号合法性验证:{}");
            if (bankbinResponse.getMessage().equals("请输入合法的银行卡号码")) {
                response.setMessage("8");
                return response;
            }
        }
        String abbreviation = "";
        if (bankbinResponse.isExecuted()) {
            abbreviation = bankbinResponse.getResultDatas().get(0).getAbbreviation();
        }
        String userName = "";
        String idcert = "";
        //查询用户详细信息
        String url = crmUrl + "/user/query/" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userDetailResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userDetailResponse.isSuccess() && userDetailResponse.isExecuted()) {
            userName = userDetailResponse.getData().getUserName();
            idcert = userDetailResponse.getData().getUserNationalid();
        }
        //根据订单状态银行卡判断是否验证三要素
        String stuUrl = orderUrl + "/outOrder/" + userCode + "/getOrdersByUserCode";
        String result = "";
        result = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserOrderListResponse userOrderListResponse = objectMapper.readValue(result, UserOrderListResponse.class);
        boolean resul = false;
        if (userOrderListResponse.isSuccess() && userOrderListResponse.isExecuted()) {
            List<UserOrderListInfoResponse> resultData = userOrderListResponse.getResultData();
            for (int i = 0; i < resultData.size(); i++) {
                Byte state = resultData.get(i).getState().getValue();
                LOGGER.info("订单状态为:{}", resultData.get(i).getState());
                int[] st = {OrderStatusEnum.WAIT_PICKUPGOODS.getValue(), OrderStatusEnum.WAIT_PAYBACK.getValue()};
                for (int m = 0; m < st.length; m++) {
                    if (st[m] == Integer.valueOf(state)) {
                        resul = true;
                        break;
                    }
                }
                if (resul) {
                    break;
                }
            }
        }
        if (resul) {
            //银行卡四要素验证
            String bankNum = resquest.getBankCardnumber();
            String bankPhone = resquest.getBankPhone();
            ApiResultFactors4BankRequest request = new ApiResultFactors4BankRequest();
            request.setBankCardId(bankNum);
            request.setId(idcert);
            request.setName(userName);
            request.setUserCode(userCode);
            request.setPhoneNumber(bankPhone);
            HttpEntity<ApiResultFactors4BankRequest> requ = new HttpEntity<>(request, httpHeaders);
            //http://192.168.1.54:8091/identify/fourElements/6236684220008121825/130530199301092072/%E6%AF%9B%E9%9F%B6%E8%B0%A6/18092506397/26565
            String fouMentsUrl = crmRootUrl + "/identify/fourElements";
            CilentBaseResponse basResponse = restTemplate.postForObject(fouMentsUrl, requ, CilentBaseResponse.class);
            if (!basResponse.isExecuted()) {
                LOGGER.info("银行卡号四要素验证未通过");
                LOGGER.info("银行卡号三要素验证开始");
                //银行卡三要素验证
                //http://192.168.1.245:8091/out/identifyBank/add
                String bankurl = crmUrl + "/identifyBank/add";
                ApiResultFactors3BankRequest apiResultFactors3BankRequest = new ApiResultFactors3BankRequest();
                apiResultFactors3BankRequest.setBankCardId(resquest.getBankCardnumber());
                apiResultFactors3BankRequest.setName(userName);
                apiResultFactors3BankRequest.setId(idcert);
                LOGGER.info("银行卡号三要素验证:{}", apiResultFactors3BankRequest);
                HttpEntity<ApiResultFactors3BankRequest> req = new HttpEntity<>(apiResultFactors3BankRequest, httpHeaders);
                CilentBaseResponse baseResponse = null;
                baseResponse = restTemplate.postForObject(bankurl, req, CilentBaseResponse.class);
                if (!baseResponse.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("5");
                    return response;
                }
                LOGGER.info("银行卡号三要素验证通过");
            }
        }
        if (resquest.getBizid() != null) {
            //解绑原银行卡
            //http://192.168.1.54:8091/out/bank/updateBankInfo/CUST2017120119294286335/2c7de6b8fb664f8eb02c8d3fe6c0ee54
            String imgurl = crmUrl + "/bank/updateBankInfo/" + userCode + "/" + resquest.getBizid();
            ResponseEntity<CilentBaseResponse> baseResponse = null;
            baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, null, CilentBaseResponse.class);
            if (!baseResponse.getBody().isExecuted()) {
                response.setSuccess(false);
                response.setMessage("解绑银行卡失败");
                return response;
            }
        }
        //保存用户银行卡信息
        String Url = crmUrl + "/bank/save";
        SaveBankInfoRequest saveBankInfoRequest = new SaveBankInfoRequest();
        saveBankInfoRequest.setBankCardnumber(resquest.getBankCardnumber());
        saveBankInfoRequest.setBankCardImgUrl(resquest.getBankCardImgUrl());
        saveBankInfoRequest.setBankId(abbreviation);
        saveBankInfoRequest.setBankPhone(resquest.getBankPhone());
        saveBankInfoRequest.setUserCode(userCode);
        LOGGER.info("保存银行卡信息入参:{}", saveBankInfoRequest);
        HttpEntity<SaveBankInfoRequest> reques = new HttpEntity<>(saveBankInfoRequest, httpHeaders);
        CilentBaseResponse baseRespo = restTemplate.postForObject(Url, reques, CilentBaseResponse.class);
        if (!baseRespo.isExecuted()) {
            response.setSuccess(false);
            response.setMessage("6");
            return response;
        }
        response.setSuccess(true);
        //修改用户资料完善度
        String dataCompletion = "BANK";
        //String userUrl="http://192.168.1.53:8091/out/user/update/dataCompletion/CONTACT/CUST2017112709382578882";
        String bankur = crmUrl + "/user/update/dataCompletion/" + dataCompletion + "/" + userCode;
        ResponseEntity<CilentBaseResponse> baseRespons = null;
        baseRespons = restTemplate.exchange(bankur, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespons.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("7");
            return response;
        }
        //this.uploadFiles(orderCode,userCode);
        LOGGER.info("调用保存银行卡信息方法结束:{}", response);
        return response;
    }

    /**
     * 查询该产品的签约相关信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qrySignatureInfo(String orderCode, String userCode) throws Exception {
        LOGGER.info("查询该产品的签约相关信息{}", orderCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //CilentXydResponse clientResponseWrapper = pushData(orderCode, userCode);
        //获取订单信息并获取到商品号
        JsonNode orderJsonNode = this.orderClient.getOrderInfo(orderCode);
        String productCode = orderJsonNode.get("productCode").asText();
        //根据商品编号获取商品信息并获取到该产品是否可以切爱尚
        JsonNode productInfo = productClient.getProductInfo(productCode);
        if (null == productInfo) {
            LOGGER.info("无该产品相关信息");
            response.setMessage("1");
            response.setSuccess(false);
            return response;
        }
        int isSupportAssend = productInfo.get("isSupportAssend").get("value").asInt();
        List<AsXydResponse> list = new ArrayList<>();
        //查询小雨点是否签约成功
        //http://192.168.1.54:8090/outOrder/1545/getOrderSignInfoByOrderCode
        String orderSignUrl = orderUrl + "/outOrder/" + orderCode + "/getOrderSignInfoByOrderCode";
        JsonNode orderSigh = restTemplate.getForObject(orderSignUrl, JsonNode.class);
        int isASSignSuccessed = 0;
        int isXYDSignSuccessed = 0;
        boolean isASSign = false;
        boolean isXYDSign = false;
        if (orderSigh.get("success").asBoolean() && orderSigh.get("executed").asBoolean()) {
            isASSignSuccessed = orderSigh.get("isASSignSuccessed").asInt();
            isXYDSignSuccessed = orderSigh.get("isXYDSignSuccessed").asInt();
        }
        if (isASSignSuccessed == SignatureEnum.SIGSUCCESS.getValue()) {
            isASSign = true;
        }
        if (isXYDSignSuccessed == SignatureEnum.SIGSUCCESS.getValue()) {
            isXYDSign = true;
        }
        int monneyResource = productInfo.get("moneyResource").get("value").asInt();
        if (monneyResource == MoneyResourceEnum.XYD.getValue()) {
            AsXydResponse asXydResponse = new AsXydResponse();
            asXydResponse.setCanSkip(false);
            asXydResponse.setName("小雨点");
            asXydResponse.setSignatrueSuccess(isXYDSign);
            list.add(asXydResponse);
        }
        AsXydResponse as = null;
        if (isSupportAssend == AdmissionEnum.ADMISSION.getValue()) {
            as = new AsXydResponse();
            as.setCanSkip(false);
            as.setName("爱尚");
            as.setSignatrueSuccess(isASSign);
            as.setUrl(asjfRootUrl + asCallbackUrl);
            list.add(as);
            /*boolean re = this.userYqbRegister(userCode);
            if(re){
                LOGGER.info("注册易签宝个人账户失败");
                response.setSuccess(false);
                response.setMessage("1");
                return response;
            }*/
            /*//更新签约表
            OrderSignRequest orderSignRequest=new OrderSignRequest();
            orderSignRequest.setMoneyResource(MoneyResourceEnum.AS.getValue());
            CilentXydResponse xydResponse = updateSign(orderSignRequest, orderCode);
            if(!xydResponse.isSuccess()){
                response.setSuccess(false);
                response.setMessage("3");
                LOGGER.info("更新签约表失败");
                return response;
            }*/
        }
        response.setData(list);
        response.setSuccess(true);
        response.setMessage("查询成功");
        LOGGER.info("查询该产品的签约相关信息方法结束:{}", response);
        return response;
    }

    /**
     * 保存用户银行卡信息(唯一的订单编号对应的银行卡信息)
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveBankInfoOrder(UserBankRequest resquest, String userCode) throws Exception {
        LOGGER.info("调用保存银行卡信息并查询该产品的签约相关信息{}", resquest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //查询用户资料完善度
        //http://192.168.1.53:8091/out/user/getDataCompletion/CUST2017112709382578882
        String urll = crmUrl + "/user/getDataCompletion/" + userCode;
        String rett = restTemplate.getForObject(urll, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserProfileCompleteResponse userResponse = null;
        userResponse = objectMapper.readValue(rett, UserProfileCompleteResponse.class);
        if (userResponse.isExecuted() && userResponse.isSuccess()) {
            List<UserProfileCompleteResponse.Data> userProfileComplete = userResponse.getUserProfileComplete();
            int o = 3;
            boolean first = false;
            boolean sencond = false;
            boolean third = false;
            if (userProfileComplete != null && userProfileComplete.size() > o) {
                first = userProfileComplete.get(0).isCompleted();
                sencond = userProfileComplete.get(1).isCompleted();
                third = userProfileComplete.get(2).isCompleted();
            }
            if ((!first) || (!sencond) || (!third)) {
                response.setSuccess(false);
                response.setMessage("4");
                return response;
            }
        }
        //卡bin验证
        Map maps = new HashMap();
        maps.put("verificationBankno", resquest.getBankCardnumber());
        maps.put("userCode", userCode);
        String bankBinUrl = crmRootUrl + crmBankBinUrl;
        String string = restTemplate.postForObject(bankBinUrl, maps, String.class);
        BankbinResponse bankbinResponse = objectMapper.readValue(string, BankbinResponse.class);
        if (!bankbinResponse.isSuccess() && !bankbinResponse.isExecuted()) {
            response.setMessage("1");
            return response;
        }
        LOGGER.info("卡宾验证输出的message:{}", bankbinResponse.getMessage());
        if (null != bankbinResponse.getMessage()) {
            //信用卡
            if (bankbinResponse.getMessage().indexOf("信用卡") != -1) {
                response.setMessage("2");
                return response;
            }
            LOGGER.info("判断银行卡列表是否支持该银行卡:{}");
            //输入的银行卡是否在支持的银行卡列表
            if (bankbinResponse.getMessage().equals("暂不支持该银行!")) {
                response.setMessage("3");
                return response;
            }
            LOGGER.info("银行卡号合法性验证:{}");
            if (bankbinResponse.getMessage().equals("请输入合法的银行卡号码")) {
                response.setMessage("8");
                return response;
            }
        }
        String abbreviation = "";
        if (bankbinResponse.isExecuted()) {
            abbreviation = bankbinResponse.getResultDatas().get(0).getAbbreviation();
        }
        String userName = "";
        String idcert = "";
        //查询用户详细信息
        String url = crmUrl + "/user/query/" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userDetailResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userDetailResponse.isSuccess() && userDetailResponse.isExecuted()) {
            userName = userDetailResponse.getData().getUserName();
            idcert = userDetailResponse.getData().getUserNationalid();
        }
        String orderCode = resquest.getOrderCode();
        //根据订单状态银行卡判断是否验证三要素
        String durl = orderUrl + "/outOrder/" + orderCode + "/getOrderInfoByOrderCode";
        String result = "";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OrderResponse orderResponse = restTemplate.getForObject(durl, OrderResponse.class);
        boolean resul = false;
        if (orderResponse.isSuccess() && orderResponse.isExecuted()) {
            int state = orderResponse.getData().getState();
            LOGGER.info("订单状态为:{}", state);
            //当订单状态为4和9时，需验证三四要素
            int[] st = {OrderStatusEnum.WAIT_PICKUPGOODS.getValue(), OrderStatusEnum.WAIT_PAYBACK.getValue()};
            for (int m = 0; m < st.length; m++) {
                if (st[m] == state) {
                    resul = true;
                    break;
                }
            }
        }
        if (resul) {
            //银行卡四要素验证
            String bankNum = resquest.getBankCardnumber();
            String bankPhone = resquest.getBankPhone();
            ApiResultFactors4BankRequest request = new ApiResultFactors4BankRequest();
            request.setBankCardId(bankNum);
            request.setId(idcert);
            request.setName(userName);
            request.setUserCode(userCode);
            request.setOrderCode(orderCode);
            request.setPhoneNumber(bankPhone);
            HttpEntity<ApiResultFactors4BankRequest> req = new HttpEntity<>(request, httpHeaders);
            //http://192.168.1.54:8091/identify/fourElements/6236684220008121825/130530199301092072/%E6%AF%9B%E9%9F%B6%E8%B0%A6/18092506397/26565
            String fouMentsUrl = crmRootUrl + "/identify/fourElements";
            CilentBaseResponse basResponse = restTemplate.postForObject(fouMentsUrl, req, CilentBaseResponse.class);
            if (!basResponse.isExecuted()) {
                LOGGER.info("银行卡号四要素验证未通过");
                LOGGER.info("银行卡号三要素验证开始");
                //银行卡三要素验证
                //http://192.168.1.54:8091/out/identifyBank/add
                String bankurl = crmUrl + "/identifyBank/add";
                ApiResultFactors3BankRequest apiResultFactors3BankRequest = new ApiResultFactors3BankRequest();
                apiResultFactors3BankRequest.setBankCardId(bankNum);
                apiResultFactors3BankRequest.setName(userName);
                apiResultFactors3BankRequest.setId(idcert);
                apiResultFactors3BankRequest.setUserCode(userCode);
                LOGGER.info("银行卡号三要素验证:{}", apiResultFactors3BankRequest);
                HttpEntity<ApiResultFactors3BankRequest> requ = new HttpEntity<>(apiResultFactors3BankRequest, httpHeaders);
                CilentBaseResponse baseResponse = restTemplate.postForObject(bankurl, requ, CilentBaseResponse.class);
                if (!baseResponse.isExecuted()) {
                    response.setSuccess(false);
                    response.setMessage("5");
                    return response;
                }
            }
            if (basResponse.isSuccess() && basResponse.isExecuted()) {
                LOGGER.info("银行卡号四要素验证通过");
            }
        }
        if (resquest.getBizid() != null) {
            //解绑原银行卡
            //http://192.168.1.54:8091/out/bank/updateBankInfo/CUST2017120119294286335/2c7de6b8fb664f8eb02c8d3fe6c0ee54
            String imgurl = crmUrl + "/bank/updateBankInfo/" + userCode + "/" + resquest.getBizid();
            ResponseEntity<CilentBaseResponse> baseResponse = null;
            baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, null, CilentBaseResponse.class);
            if (!baseResponse.getBody().isExecuted()) {
                response.setSuccess(false);
                response.setMessage("解绑银行卡失败");
                return response;
            }
        }
        //保存用户银行卡信息
        String Url = crmUrl + "/bank/save";
        SaveBankInfoRequest saveBankInfoRequest = new SaveBankInfoRequest();
        saveBankInfoRequest.setBankCardnumber(resquest.getBankCardnumber());
        saveBankInfoRequest.setBankCardImgUrl(resquest.getBankCardImgUrl());
        saveBankInfoRequest.setBankId(abbreviation);
        saveBankInfoRequest.setBankPhone(resquest.getBankPhone());
        saveBankInfoRequest.setUserCode(userCode);
        LOGGER.info("保存银行卡信息入参:{}", saveBankInfoRequest);
        HttpEntity<SaveBankInfoRequest> reques = new HttpEntity<>(saveBankInfoRequest, httpHeaders);
        CilentBaseResponse baseRespo = restTemplate.postForObject(Url, reques, CilentBaseResponse.class);
        if (!baseRespo.isExecuted()) {
            response.setSuccess(false);
            response.setMessage("6");
            return response;
        }
        response.setSuccess(true);
        //修改用户资料完善度
        String dataCompletion = "BANK";
        //String userUrl="http://192.168.1.53:8091/out/user/update/dataCompletion/CONTACT/CUST2017112709382578882";
        String bankur = crmUrl + "/user/update/dataCompletion/" + dataCompletion + "/" + userCode;
        ResponseEntity<CilentBaseResponse> baseRespons = null;
        baseRespons = restTemplate.exchange(bankur, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespons.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("7");
            return response;
        }
        response.setSuccess(true);
        LOGGER.info("调用保存银行卡信息方法结束:{}", response);
        return response;
    }

    /**
     * 用户基本信息查询
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qryUserBaseInfo(String code) throws Exception {
        LOGGER.info("调用查询用户基本信息方法开始,入参userCode:{" + code + "}");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        UserBaseReponse userBaseReponse = new UserBaseReponse();
        //查询新住址信息
        String addUrl = crmUrl + "/user/" + code + "/getUserAddress";
        System.out.println(addUrl);
        String resu = "";
        resu = restTemplate.getForObject(addUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserAddressResponse userAddressResponse = objectMapper.readValue(resu, UserAddressResponse.class);
        if (userAddressResponse.isSuccess() && userAddressResponse.isExecuted()) {
            userBaseReponse.setCityCode(userAddressResponse.getUserAddressInfoDTO().getCityCode());
            userBaseReponse.setProvinceCode(userAddressResponse.getUserAddressInfoDTO().getProvinceCode());
            userBaseReponse.setDistrictCode(userAddressResponse.getUserAddressInfoDTO().getDistrictCode());
            userBaseReponse.setNowAddress(userAddressResponse.getUserAddressInfoDTO().getHomeAddress());
            String cityCode = userAddressResponse.getUserAddressInfoDTO().getCityCode();
            String provinceCode = userAddressResponse.getUserAddressInfoDTO().getProvinceCode();
            String districtCode = userAddressResponse.getUserAddressInfoDTO().getDistrictCode();
            String provinceName = "";
            String cityName = "";
            String disName = "";
            provinceName = qryAreaName(provinceCode);
            cityName = qryAreaName(cityCode);
            disName = qryAreaName(districtCode);
            String pcd = String.format("%s %s %s", provinceName, cityName, disName);
            userBaseReponse.setPcd(pcd);

        }
        //查询该页面是否需要锁定
        userBaseReponse.setLocked(isLocked(code));
        //查询用户详细信息
        String url = crmUrl + "/user/query/" + code;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userDetailResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userDetailResponse.isSuccess() && userDetailResponse.isExecuted()) {
            if (userDetailResponse.getData().getUserGender() != null) {
                userBaseReponse.setUserGender(userDetailResponse.getData().getUserGender().getName());
            }
            if (userDetailResponse.getData().getUserIsmarried() != null) {
                userBaseReponse.setUserIsmarried(userDetailResponse.getData().getUserIsmarried().getName());
            }
            userBaseReponse.setRegisterAddress(userDetailResponse.getData().getUserHomeaddress());
            userBaseReponse.setUserName(userDetailResponse.getData().getUserName());
            userBaseReponse.setUserNationalid(userDetailResponse.getData().getUserNationalid());
            userBaseReponse.setUserValiddaterange(userDetailResponse.getData().getUserValiddaterange());
        }
        //查询用户信审照片信息
        //http://192.168.1.54:8091/out/images/query/15
        String imgurl = crmUrl + "/images/query/" + code;
        String results = restTemplate.getForObject(imgurl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserImgResponse userImgResponse = objectMapper.readValue(results, UserImgResponse.class);
        if (userImgResponse.isSuccess() && userImgResponse.isExecuted()) {
            List<UserImgInfoResponse> data = userImgResponse.getData();
            for (UserImgInfoResponse img : data) {
                if ((ImageTypeEnum.IDENTITY_HEAD.getValue()) == (img.getImgType().getValue())) {
                    userBaseReponse.setZmImaUrl(img.getImgUrl());
                }
                if ((ImageTypeEnum.IDENTITY_EMBLEM.getValue()) == (img.getImgType().getValue())) {
                    userBaseReponse.setFmImaUrl(img.getImgUrl());
                }
                if ((ImageTypeEnum.HOLD_IDENTITY.getValue()) == (img.getImgType().getValue())) {
                    userBaseReponse.setScImaUrl(img.getImgUrl());
                }
                if ((ImageTypeEnum.CONFIM.getValue()) == (img.getImgType().getValue())) {
                    userBaseReponse.setQrImaUrl(img.getImgUrl());
                }
            }
        }
        UserBaseReponse userEmptyReponse = new UserBaseReponse();
        if (userEmptyReponse.equals(userBaseReponse)) {
            response.setSuccess(false);
        } else {
            response.setData(userBaseReponse);
            response.setSuccess(true);
        }
        LOGGER.info("调用查询用户基本信息方法结束{}", response);
        return response;
    }

    /**
     * 用户工作信息查询
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qryUserWork(String userCode) throws Exception {
        LOGGER.info("调用查询用户工作开始,入参userCode:" + userCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        ClientWorkResponse clientWorkResponse = new ClientWorkResponse();
        //查询工作信息
        String stuUrl = crmUrl + "/userWork/query/" + userCode;
        String res = "";
        res = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserWorkResponse userResponseDT = objectMapper.readValue(res, UserWorkResponse.class);
        if (userResponseDT.isSuccess() == true && userResponseDT.isExecuted() == true) {
            UserWorkInfoResponse userWorkData = userResponseDT.getUserWorkData();
            if (userWorkData != null) {
                clientWorkResponse.setwAddressCompanyName(userWorkData.getwAddressCompanyName());
                clientWorkResponse.setwAddressDetail(userWorkData.getwAddressDetail());
                clientWorkResponse.setwAddressMobile(userWorkData.getwAddressMobile());
                clientWorkResponse.setProfession(userWorkData.getWorkJob());
                clientWorkResponse.setWorkPosition(userWorkData.getWorkPost());
            }
        }
        //查询该页面是否需要锁定
        clientWorkResponse.setLocked(isLocked(userCode));
        //查询用户详细信息
        String workUrl = crmUrl + "/user/query/" + userCode;
        String ret = restTemplate.getForObject(workUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userResponse.isSuccess() == true && userResponse.isExecuted() == true) {
            if (userResponse.getData().getUserHighesteducation() != null) {
                UserDetailInfoReponse data = userResponse.getData();
                if (data.getUserHighesteducation() != null) {
                    clientWorkResponse.setUserHighesteducation(data.getUserHighesteducation().getName());
                }
            }
            if (userResponse.getData().getUserIncomeResource() != null) {
                clientWorkResponse.setUserIncomeResource(userResponse.getData().getUserIncomeResource().getName());
            }
            clientWorkResponse.setUserIncome(userResponse.getData().getUserIncome());

        }
        ClientWorkResponse clientWorkResponseEmpty = new ClientWorkResponse();
        if (clientWorkResponseEmpty.equals(clientWorkResponse)) {

            response.setSuccess(false);
        } else {
            response.setData(clientWorkResponse);
            response.setSuccess(true);
        }
        LOGGER.info("调用查询用户工作信息结束:{}", response);
        return response;
    }

    /**
     * 查询用户联系人信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qryUserContacts(String userCode) throws Exception {
        LOGGER.info("调用查询用户联系人方法开始,入参userCode:" + userCode);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        UserLinkersResponse linkersResponse = new UserLinkersResponse();
        //查询用户联系人
        String url = crmUrl + "/userLinker/query?userCode=" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//ObjectMapper转换忽略多余字段
        UserLinkerResponse userResponseDTO = objectMapper.readValue(ret, UserLinkerResponse.class);
        if (userResponseDTO.isSuccess() && userResponseDTO.isExecuted()) {
            //查询该页面是否需要锁定
            linkersResponse.setLocked(isLocked(userCode));
            //查询用户是否结婚
            UserDetailResponse userDetailResponse = this.baseInfo(userCode);
            if (userDetailResponse != null) {
                EnumObject name = userDetailResponse.getData().getUserIsmarried();
                if (name != null) {
                    if (name.getName().equals(UserIsmarriedeEnum.UNMARRIED.getEnumName())) {
                        linkersResponse.setRelation(RelationshipEnum.SPOUSE.getEnumName());
                    }
                }
            }
            LinkerListOutResponse linkerListOutResponse = new LinkerListOutResponse();
            List<UserLinkerOutResponse> list = new ArrayList<>();
            List<UserLinkerInfoResponse> resultDatas = userResponseDTO.getResultDatas();
            if (resultDatas != null && resultDatas.size() > 0) {
                for (int i = 0; i < resultDatas.size(); i++) {
                    UserLinkerOutResponse userLinkerOutResponse = new UserLinkerOutResponse();
                    userLinkerOutResponse.setCityCode(userResponseDTO.getResultDatas().get(i).getCityCode());
                    userLinkerOutResponse.setDistrictCode(userResponseDTO.getResultDatas().get(i).getDistrictCode());
                    userLinkerOutResponse.setHomeAddress(userResponseDTO.getResultDatas().get(i).getHomeAddress());
                    userLinkerOutResponse.setLinkerName(userResponseDTO.getResultDatas().get(i).getLinkerName());
                    userLinkerOutResponse.setLinkPhone(userResponseDTO.getResultDatas().get(i).getLinkPhone());
                    userLinkerOutResponse.setNo(userResponseDTO.getResultDatas().get(i).getContactNcontactname().getName());
                    userLinkerOutResponse.setProvinceCode(userResponseDTO.getResultDatas().get(i).getProvinceCode());
                    userLinkerOutResponse.setRelation(userResponseDTO.getResultDatas().get(i).getLinkRelation().getName());
                    String cityCode = userResponseDTO.getResultDatas().get(i).getCityCode();
                    String provinceCode = userResponseDTO.getResultDatas().get(i).getProvinceCode();
                    String districtCode = userResponseDTO.getResultDatas().get(i).getDistrictCode();
                    String provinceName = "";
                    String cityName = "";
                    String disName = "";
                    provinceName = qryAreaName(provinceCode);
                    cityName = qryAreaName(cityCode);
                    disName = qryAreaName(districtCode);
                    String pcd = String.format("%s %s %s", provinceName, cityName, disName);
                    userLinkerOutResponse.setPcd(pcd);
                    list.add(userLinkerOutResponse);
                }
                linkerListOutResponse.setResultDatas(list);
            }
            linkersResponse.setContacts(list);
            response.setSuccess(true);
            response.setData(linkersResponse);
        } else {
            response.setSuccess(true);
            response.setData(linkersResponse);
        }
        LOGGER.info("调用查询用户联系人方法结束{}", response);
        return response;
    }

    /**
     * 根据code查询中文地方名
     *
     * @return
     * @throws Exception
     */
    public String qryAreaName(String code) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String name = "";
        //查询中文名
        if (code != null && (!code.isEmpty())) {
            AreaRequest requestDTO = new AreaRequest();
            requestDTO.setCode(code);
            String pcdUrl = dicRootUrl + dicArea + code;
            //http://192.168.1.54:8083/areas/getAreaInfo?code=150700
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            HttpEntity<AreaRequest> requestEntit = new HttpEntity<>(requestDTO, httpHeaders);
            ResponseEntity<AreaTreeInfoResponse> areaTreeInfoResponse = restTemplate.exchange(pcdUrl, HttpMethod.GET, requestEntit, AreaTreeInfoResponse.class);
            if (areaTreeInfoResponse.getBody().isSuccess() && areaTreeInfoResponse.getBody().isExecuted()) {
                List<AreaInfoResponse> data = areaTreeInfoResponse.getBody().getData();
                name = data.get(0).getName();
            }
        }
        return name;
    }

    /**
     * 查询银行卡页面信息
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qryUserBank(String userCode) throws Exception {
        LOGGER.info("调用查询用户银行卡开始,入参userCode:" + userCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        UserAllBankResponse userAllBankResponse = new UserAllBankResponse();
        //查询用户详细信息
        String url = crmUrl + "/user/query/" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userDetailResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userDetailResponse.isSuccess() && userDetailResponse.isExecuted()) {
            userAllBankResponse.setName(userDetailResponse.getData().getUserName());
            userAllBankResponse.setUserNationalid(userDetailResponse.getData().getUserNationalid());
            List<UserBankInfoResponse> userBankInfoResponses = userBank(userCode);
            if (userBankInfoResponses != null) {
                String userPhone = userBankInfoResponses.get(0).getBankPhone();
                userAllBankResponse.setUserPhone(userPhone);
            } else {
                userAllBankResponse.setUserPhone(userDetailResponse.getData().getUserPhone());
            }
        }
        //查询用户订单列表
        //http://192.168.1.53:8090/outOrder/56/getOrdersByUserCode
        String stuUrl = orderUrl + "/outOrder/" + userCode + "/getOrdersByUserCode";
        String result = "";
        result = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserOrderListResponse userOrderListResponse = objectMapper.readValue(result, UserOrderListResponse.class);
        if (userOrderListResponse.isSuccess() && userOrderListResponse.isExecuted()) {
            List<UserOrderListInfoResponse> resultData = userOrderListResponse.getResultData();
            boolean resul = false;
            for (int i = 0; i < resultData.size(); i++) {
                int state = resultData.get(i).getState().getValue();
                int[] st = {OrderStatusEnum.LETTER_BY.getValue(),
                        OrderStatusEnum.AUDIT_ING.getValue(),
                        OrderStatusEnum.WAIT_PAY.getValue(),
                        OrderStatusEnum.PAY_MONEY_ING.getValue()};
                for (int m = 0; m < st.length; m++) {
                    if (st[m] == (Integer.valueOf(state))) {
                        userAllBankResponse.setLocked(true);
                        resul = true;
                        break;
                    }
                    userAllBankResponse.setLocked(false);
                }
                if (resul) {
                    break;
                }
            }

        } else {
            userAllBankResponse.setLocked(false);
        }
        //查询银行卡基本信息
        String bankUrl = crmUrl + "/bank/query/" + userCode + "/All";
        String res = restTemplate.getForObject(bankUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserBankResopnse userResponseDTO = objectMapper.readValue(res, UserBankResopnse.class);
        if (userResponseDTO.isSuccess() && userResponseDTO.isExecuted()) {
            userAllBankResponse.setBankCardImgUrl(userResponseDTO.getListData().get(0).getBankCardImgUrl());
            userAllBankResponse.setBankCardnumber(userResponseDTO.getListData().get(0).getBankCardnumber());
            userAllBankResponse.setBizid(userResponseDTO.getListData().get(0).getBizid());
            String bankId = userResponseDTO.getListData().get(0).getBankId();
            List<com.aishang.asjf.client.crmserver.response.BankResponse> bankListResponse = qryBankCode(bankId);
            if (bankListResponse != null && bankListResponse.size() > 0) {
                String dataName = bankListResponse.get(0).getDataName();
                userAllBankResponse.setBankName(dataName);
            }
        }
        response.setSuccess(true);
        response.setData(userAllBankResponse);
        LOGGER.info("调用查询用户银行卡结束，response:{" + response + "}");
        return response;
    }


    /**
     * 银行卡BIN
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper qryCardBin(ApiResultBankbinRequest apiResultBankbinRequest) throws Exception {
        LOGGER.info("卡BIN验证开始,入参apiResultBankbinRequest:" + apiResultBankbinRequest);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<ApiResultBankbinRequest> request = new HttpEntity<>(apiResultBankbinRequest, httpHeaders);
        String url = crmUrl + "/apiResultBankbin/query";
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ApiResultBankbinResponse apiResultBankbinResponse = restTemplate.postForObject(url, request, ApiResultBankbinResponse.class);
        if (apiResultBankbinResponse.isSuccess() && apiResultBankbinResponse.isExecuted()) {
            response.setSuccess(true);
            response.setData(apiResultBankbinResponse.getResultDatas());
        } else {
            response.setSuccess(false);
        }
        LOGGER.info("卡BIN验证结束，response:{" + response + "}");
        return response;
    }

    /**
     * 查询客户订单剩余应还和客户资料完善度（客户资料一级查询页面）
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getCompletion(String userCode) throws Exception {
        LOGGER.info("查询客户资料完善度开始{}:" + userCode);
        ClientResponseWrapper response = new ClientResponseWrapper();
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        userProfileResponse.setCode(userCode);
        //查询客户订单剩余应还

        //查询用户资料完善度
        //http://192.168.1.53:8091/out/user/getDataCompletion/CUST2017112709382578882
        String url = crmUrl + "/user/getDataCompletion/" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserProfileCompleteResponse userResponse = null;
        userResponse = objectMapper.readValue(ret, UserProfileCompleteResponse.class);
        if (userResponse.isExecuted() && userResponse.isSuccess()) {
            userProfileResponse.setUserProfileComplete(userResponse.getUserProfileComplete());
//            BigDecimal oddMoney = new BigDecimal("235");
//            userProfileResponse.setOddMoney(oddMoney);
            //当前用户的订单数量
            String stuUrl = orderUrl + "/outOrder/" + userCode + "/getOrdersByUserCode";
            String res = restTemplate.getForObject(stuUrl, String.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            UserOrderListResponse userOrderListResponse = objectMapper.readValue(res, UserOrderListResponse.class);
            if (userOrderListResponse.getResultData() == null) {
                userProfileResponse.setOrderNum("0");
            } else {
                userProfileResponse.setOrderNum(String.valueOf(userOrderListResponse.getResultData().size()));
            }
            response.setData(userProfileResponse);
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }
        LOGGER.info("查询客户资料完善度结束:{}", response);
        return response;
    }

    /**
     * 保存用户通讯录接口
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveAddressList(UserSaveTeleListRequest userSaveTeleListRequest, String userCode) throws Exception {
        LOGGER.info("保存用户通讯录,入参userSaveTeleListRequest:" + userSaveTeleListRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //保存联系人基本信息
        String linkUrl = crmUrl + "/userTelephonedirectory/save";
        List<TeleSaveRequest> linkerList = userSaveTeleListRequest.getUserTelList();
        UserTeleListRequest userTeleListRequest = new UserTeleListRequest();
        List<TelepRequest> userTelList = new ArrayList<>();
        if (linkerList != null && linkerList.size() > 0) {
            for (int i = 0; i < linkerList.size(); i++) {
                TelepRequest telepRequest = new TelepRequest();
                telepRequest.setUserCode(userCode);
                telepRequest.setDisplayname(userSaveTeleListRequest.getUserTelList().get(i).getDisplayname());
                telepRequest.setPhone(userSaveTeleListRequest.getUserTelList().get(i).getPhone());
                telepRequest.setPhoneType(PhoneEnum.MOBILE);
                userTelList.add(telepRequest);
            }
        }
        userTeleListRequest.setUserTelList(userTelList);
        HttpEntity<UserTeleListRequest> requestEntity = new HttpEntity<>(userTeleListRequest, httpHeaders);
        CilentBaseResponse baseResponse = restTemplate.postForObject(linkUrl, requestEntity, CilentBaseResponse.class);
        if (!baseResponse.isExecuted()) {
            response.setSuccess(false);
            response.setMessage("通讯录保存失败");
            return response;
        }
        //修改授权
        //http://192.168.1.54:8090/outOrder/2452/updateOrderIsTelDictionary
        String orderCode = userSaveTeleListRequest.getOrderCode();
        String Url = orderUrl + "/outOrder/" + orderCode + "/updateOrderIsTelDictionary";
        ResponseEntity<CilentBaseResponse> baseRespo = restTemplate.exchange(Url, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseRespo.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("操作失败");
            return response;
        }
        response.setSuccess(true);
        LOGGER.info("保存用户通讯录方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 授权页面
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getCustomerId(CustomerRequest customerRequestDTO) throws Exception {
        LOGGER.info("获得CustomerId,入参customerRequestDTO:" + customerRequestDTO);
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //获取custmerId
        String linkUrl = apiUrl + "/wecash/getCustomerId";
        //String linkUrl = "http://192.168.1.53:8084/wecash/getCustomerId" + "/wecash/getCustomerId";
        HttpEntity<CustomerRequest> requestEntity = new HttpEntity<>(customerRequestDTO, httpHeaders);
        WecashResponse wecashResponse = restTemplate.postForObject(linkUrl, requestEntity, WecashResponse.class);
        if (!wecashResponse.isSuccess()) {
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
        String orderCode = customerRequestDTO.getOrderCode();
        String custmerId = wecashResponse.getData().getCustmerId();
        //绑定custmerId和orderCode
        //http://192.168.1.54:8090/outOrder/151135250794413XF3ASJ/141/updateOrderAuthCode
        String orderAuthUrl = orderUrl + "/outOrder/" + orderCode + "/" + custmerId + "/updateOrderAuthCode";
        ResponseEntity<CilentBaseResponse> exchange = restTemplate.exchange(orderAuthUrl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!exchange.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("2");
            return response;
        }
        LOGGER.info("订单编号和customerId绑定成功");
        CashOutResponse cashOutResponse = new CashOutResponse();
        String pageUrl = String.format("%s%s%s%s", wecashResponse.getData().getPageUrl(), "?returnUrl=", asjfRootUrl, callback);
        cashOutResponse.setCustmerId(custmerId);
        cashOutResponse.setPageUrl(pageUrl);
        response.setData(cashOutResponse);
        response.setSuccess(true);
        response.setMessage("成功");
        LOGGER.info("授权方法结束，response:{" + response + "}");
        return response;
    }


    /**
     * 上传用户其他资料
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper saveUserOthers(SaveUserOtherImgRequest saveUserOtherImgRequest, String userCode) throws Exception {
        LOGGER.info("上传用户其他资料,入参saveUserOtherImgRequest:" + saveUserOtherImgRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //上传用户其他资料
        String imgurl = crmUrl + "/images/save";
        //循环给userCode赋值
        SaveUserImgRequest saveUserImgRequest = new SaveUserImgRequest();
        List<String> data = saveUserOtherImgRequest.getData();
        List<UserImgRequest> list = new ArrayList<>();
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                UserImgRequest userImgRequest = new UserImgRequest();
                userImgRequest.setImgUrl(data.get(i));
                userImgRequest.setImgType(ImageTypeEnum.CREDIT_OHTERS);
                userImgRequest.setUserCode(userCode);
                list.add(userImgRequest);
            }
            saveUserImgRequest.setData(list);
        }
        HttpEntity<SaveUserImgRequest> requestEntity = new HttpEntity<>(saveUserImgRequest, httpHeaders);
        CilentBaseResponse baseResponse = null;
        baseResponse = restTemplate.postForObject(imgurl, requestEntity, CilentBaseResponse.class);
        if (!baseResponse.isExecuted()) {
            response.setSuccess(false);
            response.setMessage("上传用户其他资料失败");
            return response;
        }
        response.setSuccess(true);
        response.setMessage("上传用户其他资料保存成功");
        LOGGER.info("上传用户其他资料方法结束，response:{" + response + "}");
        return response;
    }

    /**
     * 银行卡列表
     *
     * @return
     */
    public String[] getBankList() throws Exception {
        LOGGER.info("银行卡列表开始");
        ClientResponseWrapper wrapper = new ClientResponseWrapper();
        String bankUrl = dictRootUrl + dictBankRootUrl;
        BankResponse response = restTemplate.getForObject(bankUrl, BankResponse.class);
        String list = "";
        for (int i = 0; i < response.getData().size(); i++) {
            if (null != response.getData().get(i)) {
                BankListInfoResponse listInfo = new BankListInfoResponse();
                String dataValue = response.getData().get(i).getDataValue();
                list += dataValue + ",";
            }
        }
        String[] str = list.split(",");
        LOGGER.info("银行卡列表结束:{}", list);
        return str;
    }

    /**
     * 解绑银行卡
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper releaseBank(String bizid, String userCode) throws Exception {
        LOGGER.info("解绑银行卡,入参bizid:" + bizid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ClientResponseWrapper response = new ClientResponseWrapper();
        //http://192.168.1.54:8091/out/bank/updateBankInfo/CUST2017120119294286335/2c7de6b8fb664f8eb02c8d3fe6c0ee54
        String imgurl = crmUrl + "/bank/updateBankInfo/" + userCode + "/" + bizid;
        ResponseEntity<CilentBaseResponse> baseResponse = null;
        baseResponse = restTemplate.exchange(imgurl, HttpMethod.PUT, null, CilentBaseResponse.class);
        if (!baseResponse.getBody().isExecuted()) {
            response.setSuccess(false);
            response.setMessage("解绑银行卡失败");
            return response;
        }
        response.setSuccess(true);
        LOGGER.info("解绑银行卡方法结束，response:{" + response + "}");
        return response;
    }


    /**
     * 推送数据
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper pushData(String orderCode, String userCode) throws Exception {

        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //查询用户资料完善度
        //http://192.168.1.53:8091/out/user/getDataCompletion/CUST2017112709382578882
        String urll = crmUrl + "/user/getDataCompletion/" + userCode;
        String rett = restTemplate.getForObject(urll, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserProfileCompleteResponse userResponse = null;
        userResponse = objectMapper.readValue(rett, UserProfileCompleteResponse.class);
        if (userResponse.isExecuted() && userResponse.isSuccess()) {
            List<UserProfileCompleteResponse.Data> userProfileComplete = userResponse.getUserProfileComplete();
            int o = 3;
            boolean first = false;
            boolean sencond = false;
            boolean third = false;
            boolean fourth = false;
            if (userProfileComplete != null && userProfileComplete.size() > o) {
                first = userProfileComplete.get(0).isCompleted();
                sencond = userProfileComplete.get(1).isCompleted();
                third = userProfileComplete.get(2).isCompleted();
                fourth = userProfileComplete.get(3).isCompleted();
            }
            if ((!first) || (!sencond) || (!third) || (!fourth)) {
                response.setSuccess(false);
                response.setMessage("3");
                LOGGER.info("用户资料完善度，response:{" + userProfileComplete + "}");
                return response;
            }
        }
        PushDataRequestClient pushDataRequestClient = new PushDataRequestClient();//认证+推送数据(1)参数
        JsonNode orderJsonNode = this.orderClient.getOrderInfo(orderCode);
        UserWorkResponse userWork = this.userWork(userCode);
        List<UserBankInfoResponse> userBank = this.userBank(userCode);
        UserLinkerResponse userContacts = this.userContacts(userCode);
        UserDetailResponse userJsonNode = this.baseInfo(userCode);
        if (userWork == null) {
            LOGGER.info("用户工作信息为空");
            response.setMessage("3");
            response.setSuccess(false);
            return response;
        }
        if (userBank == null && userBank.size() < 1) {
            LOGGER.info("用户银行卡信息为空");
            response.setMessage("3");
            response.setSuccess(false);
            return response;
        }
        String bankId = userBank.get(0).getBankId();
        String bankNo=userBank.get(0).getBankCardnumber();
        List<com.aishang.asjf.client.crmserver.response.BankResponse> bankListResponse = qryBankCode(bankId);
        if (bankListResponse == null && bankListResponse.size() < 1) {
            LOGGER.info("银行卡列表为空");
            response.setMessage("3");
            response.setSuccess(false);
            return response;
        }
        String dataReark = bankListResponse.get(0).getDataReark();
        if (userContacts == null) {
            LOGGER.info("联系人为空");
            response.setMessage("3");
            response.setSuccess(false);
            return response;
        }
        if (userJsonNode == null) {
            LOGGER.info("用户基本信息为空");
            response.setMessage("3");
            response.setSuccess(false);
            return response;
        }
        UserDetailInfoReponse userDetailInfoReponse = userJsonNode.getData();
        pushDataRequestClient.setOrder_no(orderCode);//订单编号
        String type = orderCode.substring(orderCode.length() - 6, orderCode.length() - 4);
        String productType = "3C";
        if (type.equals("XF")) {
            productType = "3C";
        }
        pushDataRequestClient.setProduct_no(productType);//产品类型
        UserInfoRequestClient userInfoRequestClient = new UserInfoRequestClient();//用户信息
        userInfoRequestClient.setPhone(userDetailInfoReponse.getUserPhone());//用户手机号
        userInfoRequestClient.setName(userDetailInfoReponse.getUserName());//用户名称
        userInfoRequestClient.setIdCardNo(userDetailInfoReponse.getUserNationalid());//身份证号
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        if (userJsonNode.getData().getUserValiddaterange() != null) {
            Long date = userJsonNode.getData().getUserValiddaterange().getTime();
            userInfoRequestClient.setIdCardTerm(sm.format(date));//身份证有效时间
        }
        if (userJsonNode.getData().getUserIsmarried() != null) {
            int userIsmarried = (Integer) (userJsonNode.getData().getUserIsmarried().getValue());
            int isMarried = 1;
            switch (userIsmarried) {
                case 1:
                    isMarried = 1;
                    break;
                case 2:
                    isMarried = 2;
                    break;
                case 3:
                    isMarried = 3;
                    break;
                default:
                    isMarried = 1;
                    break;
            }
            userInfoRequestClient.setIsMarried(isMarried);//婚姻状况
        }
        if (userDetailInfoReponse.getUserHighesteducation() != null) {
            int userHighesteducation = (Integer) (userDetailInfoReponse.getUserHighesteducation().getValue());
            int education = 0;
            switch (userHighesteducation) {
                case 1:
                    education = 7;
                    break;
                case 2:
                    education = 6;
                    break;
                case 3:
                    education = 2;
                    break;
                case 4:
                    education = 2;
                    break;
                case 5:
                    education = 1;
                    break;
            }
            userInfoRequestClient.setEducation(education);//学历
        }
        userInfoRequestClient.setHomeAddress(userDetailInfoReponse.getUserHomeaddress());//住址
        userInfoRequestClient.setIncome(userDetailInfoReponse.getUserIncome());//收入
        userInfoRequestClient.setProvinceCode(orderJsonNode.get("provinceCode") == null ? null : orderJsonNode.get("provinceCode").asText());//省编号
        userInfoRequestClient.setCityCode(orderJsonNode.get("cityCode") == null ? null : orderJsonNode.get("cityCode").asText());//市编号
        userInfoRequestClient.setDistrictCode(orderJsonNode.get("districtCode") == null ? null : orderJsonNode.get("districtCode").asText());//区编号
        userInfoRequestClient.setCustomerType(1);//客户类型
        pushDataRequestClient.setUserInfoRequestDTO(userInfoRequestClient);
        LOGGER.info("整合用户信息结束:{}", userInfoRequestClient);

        // 借款信息
        LoanInfoRequestClient loanInfoRequestClient = new LoanInfoRequestClient();
        loanInfoRequestClient.setInstallments(orderJsonNode.get("payTime") == null ? null : orderJsonNode.get("payTime").asText());//期数、
        loanInfoRequestClient.setDownPayment(orderJsonNode.get("firstPayMoney") == null ? null : orderJsonNode.get("firstPayMoney").decimalValue());//首付金额
        loanInfoRequestClient.setLoanAmount(orderJsonNode.get("monthMoney") == null ? null : orderJsonNode.get("monthMoney").decimalValue());//贷款金额

        pushDataRequestClient.setLoanInfoRequestDTO(loanInfoRequestClient);
        LOGGER.info("整合借款信息结束:{}", loanInfoRequestClient);

        //银行卡信息
        BankInfoRequestClient bankInfoRequestClient = new BankInfoRequestClient();
        bankInfoRequestClient.setBankCardNumber(bankNo);//银行卡号
        //orderJsonNode.get("bankCard").asText()通过编号获取银行编号，然后转换为小雨点卡id
        bankInfoRequestClient.setBankId(Integer.valueOf(dataReark));

        pushDataRequestClient.setBankInfoRequestDTO(bankInfoRequestClient);
        LOGGER.info("整合银行卡信息结束:{}", bankInfoRequestClient);


        //联系人信息
        ContactInfoRequestClient requestClient = new ContactInfoRequestClient();
        //第一联系人

        if (null != userContacts.getResultDatas() && userContacts.getResultDatas().size() >= 1) {
            requestClient.setFirstContactGx(userContacts.getResultDatas().get(0).getContactNcontactname().getDisplayName());//第一联系人关系
            requestClient.setFirstContactName(userContacts.getResultDatas().get(0).getLinkerName());//第一联系人名称
            requestClient.setFirstContactPhone(userContacts.getResultDatas().get(0).getLinkPhone());//第一联系人手机号
        }
        //第二联系人
        if (null != userContacts.getResultDatas() && userContacts.getResultDatas().size() >= 2) {
            requestClient.setSecondContacGx(userContacts.getResultDatas().get(1).getLinkRelation().getDisplayName());
            requestClient.setSecondContactName(userContacts.getResultDatas().get(1).getLinkerName());
            requestClient.setSecondContactPhone(userContacts.getResultDatas().get(1).getLinkPhone());
        }
        //第三联系人
        if (null != userContacts.getResultDatas() && userContacts.getResultDatas().size() >= 3) {
            requestClient.setThirdContacGx(userContacts.getResultDatas().get(2).getLinkRelation().getDisplayName());
            requestClient.setThirdContactName(userContacts.getResultDatas().get(2).getLinkerName());
            requestClient.setThirdContactPhone(userContacts.getResultDatas().get(2).getLinkPhone());
        }

        pushDataRequestClient.setContactInfoRequestDTO(requestClient);
        LOGGER.info("整合联系人信息结束:{}", requestClient);

        //商品信息
        GoodsInfoRequestClient goodsInfoRequestClient = new GoodsInfoRequestClient();
        if (orderJsonNode.get("commodityName") != null) {
            goodsInfoRequestClient.setName(orderJsonNode.get("commodityName").asText());
        }
        if (orderJsonNode.get("commodityPrice") != null) {
            goodsInfoRequestClient.setPrice(orderJsonNode.get("commodityPrice").decimalValue());
        }

        pushDataRequestClient.setGoodsInfoRequestDTO(goodsInfoRequestClient);
        LOGGER.info("整合商品信息结束:{}", goodsInfoRequestClient);
        //单位信息

        WorkInfoRequestClient workInfoRequestClient = new WorkInfoRequestClient();
        if (null != userWork) {
            workInfoRequestClient.setCompanyName(userWork.getUserWorkData().getwAddressCompanyName());//单位名称
            workInfoRequestClient.setCompanyPhone(userWork.getUserWorkData().getwAddressMobile());//单位电话
            workInfoRequestClient.setPosition(userWork.getUserWorkData().getWorkPost());//职位
        }

        pushDataRequestClient.setWorkInfoRequestDTO(workInfoRequestClient);
        System.out.println(pushDataRequestClient);
        LOGGER.info("整合单位信息结束:{}", workInfoRequestClient);
        String url = fundsUrl + "/xyd/auth";
        //String url ="http://funds.test.api.aishangjinrong.com"+"/xyd/auth";
        HttpEntity<PushDataRequestClient> reques = new HttpEntity<>(pushDataRequestClient, httpHeaders);
        ResponseEntity<PushDataResponse> pushDataResponseResponseEntity = restTemplate.postForEntity(url, reques, PushDataResponse.class);
        if (!pushDataResponseResponseEntity.getBody().isSuccess()) {
            response.setSuccess(false);
            response.setMessage("3");
            LOGGER.info("推送数据失败");
            return response;
        }
        if (pushDataResponseResponseEntity.getBody().isSuccess()) {
            LOGGER.info("推送数据成功");
            response.setSuccess(true);
            response.setMessage("推送数据成功");
            /*XydFlowRequest xydFlowRequest=new XydFlowRequest();
            CilentXydResponse cilentXydResponse = updateXydFlow(xydFlowRequest, orderCode);
            if(!cilentXydResponse.isSuccess()){
                response.setSuccess(false);
                response.setMessage("3");
                LOGGER.info("更新小雨点签约流程表失败");
                return response;
            }*/
            //更新签约表
            OrderSignRequest orderSignRequest=new OrderSignRequest();
            boolean a = updateSign(orderSignRequest, orderCode);
            if(!a){
                response.setSuccess(false);
                response.setMessage("3");
                LOGGER.info("更新签约表失败");
                return response;
            }
        }
        return response;
    }

    /**
     * 根据通道选择签约小雨点或爱尚
     *
     * @return
     * @throws Exception
     */
    public CilentXydResponse xydSignature(String orderCode, String userCode, MoneyResourceEnum name) throws Exception {
        CilentXydResponse response = new CilentXydResponse();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        if (name.equals(MoneyResourceEnum.XYD)) {
            ClientResponseWrapper clientResponseWrapper = this.pushData(orderCode, userCode);
            if (!clientResponseWrapper.isSuccess()) {
                if (clientResponseWrapper.getMessage().equals("3")) {
                    response.setSuccess(false);
                    response.setMessage("3");
                    return response;
                }
            }
            if (clientResponseWrapper.isSuccess()) {
                CilentXydResponse xydSignature = this.getXydSignature(orderCode);
                if (xydSignature.isSuccess()) {
                    response.setSuccess(true);
                    response.setData(xydSignature.getData());
                    response.setMessage("查询电子签成功");
                } else {
                    response.setSuccess(false);
                    response.setMessage("3");
                }
                return response;
            }
        }
        if (name.equals(MoneyResourceEnum.AS)) {
            String sigUrl = fundsUrl+"/sign/"+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+asCallbackUrl+"&firmNo="+firmNo;
            //String sigUrl = "http://192.168.1.54:8093"+"/sign/"+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+asCallbackUrl+"&firmNo="+firmNo;
            response.setSuccess(true);
            response.setMessage("获取爱尚签约地址成功");
            response.setData(sigUrl);
        }
        return response;
    }


    /**
     * 查询小雨点签约url
     *
     * @return
     * @throws Exception
     */
    public CilentXydResponse getXydSignature(String orderCode) throws Exception {
        CilentXydResponse response = new CilentXydResponse();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String rediUrl = "";
        SigUrlRequest sigUrlRequest = new SigUrlRequest();
        sigUrlRequest.setProductNo("3C");
        sigUrlRequest.setOrderNo(orderCode);
        String redirectUrl = String.format("%s%s", asjfRootUrl, callback);
        sigUrlRequest.setRedirectUrl(redirectUrl);
        //String sigUrl ="http://funds.test.api.aishangjinrong.com"+"/xyd/getSiginUrl";
        String sigUrl = fundsUrl + "/xyd/getSiginUrl";
        HttpEntity<SigUrlRequest> requestEntity = new HttpEntity<>(sigUrlRequest, httpHeaders);
        ResponseEntity<SigUrlResponse> entity = restTemplate.postForEntity(sigUrl, requestEntity, SigUrlResponse.class);
        if (!entity.getBody().isSuccess()) {
            response.setSuccess(false);
            response.setMessage("3");
            return response;
        }
        if (entity.getBody().isSuccess()) {
            SigUrlResponse body = entity.getBody();
            if (body != null) {
                SigDataResponse data = body.getData();
                if (data != null) {
                    SignaUrlResponse signdatas = data.getDatas();
                    if (signdatas != null) {
                        rediUrl = signdatas.getUrl();
                    }
                }
            }
        }
        response.setSuccess(true);
        response.setData(rediUrl);
        response.setMessage("获取小雨点电子签成功");
        return response;
    }

    /**
     * 更新小雨点流程表
     *
     * @return
     * @throws Exception
     */
    public boolean updateXydFlow(XydFlowRequest xydFlowRequest, String orderCode) throws Exception {
        boolean rel=false;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String xydFlowUrl = orderUrl + "/outOrder/" + orderCode + "/updateXydFlowByOrderCode";
        //http://192.168.1.54:8090/outOrder/1545/addXydFlowByOrderCode
        HttpEntity<XydFlowRequest> requestEntity = new HttpEntity<>(xydFlowRequest, httpHeaders);
        ResponseEntity<SigUrlResponse> entity = restTemplate.exchange(xydFlowUrl, HttpMethod.PUT, requestEntity, SigUrlResponse.class);
        if (entity.getBody().isSuccess()) {
            rel=true;
            return rel;
        }
        return rel;
    }

    /**
     * 更新签约表
     *
     * @return
     * @throws Exception
     */
    public boolean updateSign(OrderSignRequest orderSignRequest, String orderCode) throws Exception {
        boolean rel=false;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String xydFlowUrl = orderUrl + "/outOrder/" + orderCode + "/updateOrderSignByOrderCode";
        //http://192.168.1.54:8090/outOrder/1545/addXydFlowByOrderCode
        HttpEntity<OrderSignRequest> requestEntity = new HttpEntity<>(orderSignRequest, httpHeaders);
        ResponseEntity<SigUrlResponse> entity = restTemplate.exchange(xydFlowUrl, HttpMethod.PUT, requestEntity, SigUrlResponse.class);
        if (entity.getBody().isSuccess()) {
            rel=true;
            return rel;
        }
        return rel;
    }


    /**
     * 用户基本信息查询(JsonNode)
     *
     * @return
     * @throws Exception
     */
    public UserDetailResponse baseInfo(String userCode) throws Exception {
        //查询用户详细信息
        //查询新住址信息
        if (userCode == null) {
            return null;
        }
        String url = crmUrl + "/user/query/" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDetailResponse userDetailResponse = objectMapper.readValue(ret, UserDetailResponse.class);
        if (userDetailResponse.isSuccess() && userDetailResponse.isExecuted()) {
            return userDetailResponse;
        }
        return null;
    }

    /**
     * 用户工作信息查询(JsonNode)
     *
     * @return
     * @throws Exception
     */
    public UserWorkResponse userWork(String userCode) throws Exception {
        //查询工作信息
        //查询新住址信息
        if (userCode == null) {
            return null;
        }
        String stuUrl = crmUrl + "/userWork/query/" + userCode;
        String res = "";
        res = restTemplate.getForObject(stuUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserWorkResponse userResponse = objectMapper.readValue(res, UserWorkResponse.class);
        if (userResponse.isSuccess() == true && userResponse.isExecuted() == true) {
            return userResponse;
        }
        return null;
    }

    /**
     * 查询用户联系人信息(JsonNode)
     *
     * @return
     * @throws Exception
     */
    public UserLinkerResponse userContacts(String userCode) throws Exception {
        //查询用户联系人
        if (userCode == null) {
            return null;
        }
        String url = crmUrl + "/userLinker/query?userCode=" + userCode;
        String ret = restTemplate.getForObject(url, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//ObjectMapper转换忽略多余字段
        UserLinkerResponse userResponseDTO = objectMapper.readValue(ret, UserLinkerResponse.class);
        if (userResponseDTO.isSuccess() && userResponseDTO.isExecuted()) {
            return userResponseDTO;
        }
        return null;
    }

    /**
     * 查询银行卡页面信息(JsonNode)
     *
     * @return
     * @throws Exception
     */
    public List<UserBankInfoResponse> userBank(String userCode) throws Exception {
        //查询银行卡基本信息
        if (userCode == null) {
            return null;
        }
        String bankUrl = crmUrl + "/bank/query/" + userCode + "/All";
        String res = restTemplate.getForObject(bankUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserBankResopnse userResponseDTO = objectMapper.readValue(res, UserBankResopnse.class);
        if (userResponseDTO.isSuccess() && userResponseDTO.isExecuted()) {
            return userResponseDTO.getListData();
        }
        return null;
    }


    /**
     * 查询用户现居地址
     *
     * @return
     * @throws Exception
     */
    public UserAddressResponse userAddress(String userCode) throws Exception {
        //查询新住址信息
        if (userCode == null) {
            return null;
        }
        String addUrl = crmUrl + "/user/" + userCode + "/getUserAddress";
        String resu = restTemplate.getForObject(addUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserAddressResponse userAddressResponse = objectMapper.readValue(resu, UserAddressResponse.class);
        if (userAddressResponse.isSuccess() && userAddressResponse.isExecuted()) {
            return userAddressResponse;
        }
        return null;
    }


    /**
     * 根据bankId查询银行code
     *
     * @return
     * @throws Exception
     */
    public List<com.aishang.asjf.client.crmserver.response.BankResponse> qryBankCode(String bankId) throws Exception {
        if (bankId == null) {
            return null;
        }
        String bankUrl = dicRootUrl + qryBankUrl + bankId;
        // http://192.168.1.54:8083/dictionarys/findBytypeAndDataValueNew?dicTypeEnum=BANK&dataValue=CCB
        String resu = restTemplate.getForObject(bankUrl, String.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BankListResponse bankListResponse = objectMapper.readValue(resu, BankListResponse.class);
        if (bankListResponse.isSuccess() && bankListResponse.isExecuted()) {
            return bankListResponse.getResultData();
        }
        return null;
    }


   /* *//**
     * 是否签约成功
     *
     * @return
     * @throws Exception
     *//*
    public ClientResponseWrapper yqbSig(String orderCode) throws Exception {
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String sigUrl = "http://192.168.1.54:8093"+"/sign/"+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+asCallbackUrl+"&firmNo="+firmNo;
        //String sigUrl = fundsUrl+"/sign/"+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+callback+"&firmNo="+firmNo;
        //String sigUrl="http://192.168.1.54:8093/sign/2017122414573966966XJQBQB/eqbHtml?notifyUrl=56465&firmNo=AB858B5E4A844CCFA2C84B8B58C3FC70";
        ModelAndView exchange = restTemplate.getForObject(sigUrl, ModelAndView.class);
        return response;

    }*/

    /**
     * e签宝创建个人账户
     *
     * @return
     * @throws Exception
     */
    public boolean userYqbRegister(String userCode) throws Exception {
        boolean result = false;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //String receiveResuUrl=orderUrl+"/outOrder/"+orderCode+"/updateOrderSignByOrderCode";
        String regUrl = "http://192.168.1.53:8093/eqb/register/user";
        //String regUrl = fundsUrl + "/eqb/register/user";
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        UserDetailResponse userDetailResponse = this.baseInfo(userCode);
        UserDetailInfoReponse data = userDetailResponse.getData();
        userRegisterRequest.setEmail("881015478@163.com");
        userRegisterRequest.setIdNo(data.getUserNationalid());
        userRegisterRequest.setMobile(data.getUserPhone());
        userRegisterRequest.setName(data.getUserName());
        HttpEntity<UserRegisterRequest> requestEntity = new HttpEntity<>(userRegisterRequest, httpHeaders);
        ResponseEntity<YqbRegisResponse> exchange = restTemplate.postForEntity(regUrl, requestEntity, YqbRegisResponse.class);
        if (exchange.getBody().isSuccess()) {
            result = true;
            return result;
        } else {
            return result;
        }
    }


    /**
     * 根据手机号码查询易签宝注册个人账户的账号（accountId）
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper getAccountId(String userCode) throws Exception {
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //String receiveResuUrl=orderUrl+"/outOrder/"+orderCode+"/updateOrderSignByOrderCode";
        String regUrl = "http://192.168.1.53:8093/eqb/user/sendAuthCode";
        ResponseEntity<CilentBaseResponse> exchange = restTemplate.postForEntity(regUrl, null, CilentBaseResponse.class);
        if (exchange.getBody().isSuccess()) {
            response.setSuccess(true);
            response.setMessage("注册成功");
            return response;
        } else {
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
    }


    /**
     * 易签宝获取短信验证码
     *
     * @return
     * @throws Exception
     */
    public ClientResponseWrapper sendAuthCode(String accountId) throws Exception {
        ClientResponseWrapper response = new ClientResponseWrapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //String receiveResuUrl=orderUrl+"/outOrder/"+orderCode+"/updateOrderSignByOrderCode";
        //String regUrl = fundsUrl+"/eqb/user/sendAuthCode";
        String regUrl = "http://192.168.1.53:8093/eqb/user/sendAuthCode";
        ResponseEntity<CilentBaseResponse> exchange = restTemplate.postForEntity(regUrl, null, CilentBaseResponse.class);
        if (exchange.getBody().isSuccess()) {
            response.setSuccess(true);
            response.setMessage("获取成功");
            return response;
        } else {
            response.setSuccess(false);
            response.setMessage("1");
            return response;
        }
    }

    /**
     * 查询页面是否需要锁(除银行信息查询页面)
     *
     * @return
     * @throws Exception
     */
    public boolean isLocked(String userCode) throws Exception {
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
                int state = resultData.get(i).getState().getValue();
                int[] st = {OrderStatusEnum.SUDMITTED_LETTER.getValue(),
                        OrderStatusEnum.LETTER_IN.getValue(),
                        OrderStatusEnum.WAIT_PICKUPGOODS.getValue(),
                        OrderStatusEnum.LETTER_BY.getValue(),
                        OrderStatusEnum.AUDIT_ING.getValue(),
                        OrderStatusEnum.WAIT_PAY.getValue(),
                        OrderStatusEnum.PAY_MONEY_ING.getValue(),
                        OrderStatusEnum.WAIT_PAYBACK.getValue()};
                for (int m = 0; m < st.length; m++) {
                    if (st[m] == state) {
                        resul = true;
                        break;
                    }
                }
                if (resul) {
                    break;
                }
            }
        } else {
            return false;
        }
        return resul;
    }

    /**
     * 给小雨点推前置模型
     *
     * @return
     * @throws Exception
     */
    public boolean preModel(String userCode,String orderCode) throws Exception {
        boolean resul = false;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        AsPreModelRequest asPreModelRequest=new AsPreModelRequest();
        //给小雨点推前置模型
        //String preUrl = "http://funds.test.api.aishangjinrong.com"+ "/xyd/asPreModel";
        String preUrl = fundsUrl + "/xyd/asPreModel";
        UserDetailResponse userDetailResponse = this.baseInfo(userCode);
        JsonNode orderInfo = orderClient.getOrderInfo(orderCode);
        UserLinkerResponse userLinkerResponse = this.userContacts(userCode);
        String firstLinkerName="";
        String firstLinkerPhone="";
        if(userLinkerResponse!=null){
            List<UserLinkerInfoResponse> resultDatas = userLinkerResponse.getResultDatas();
            if(resultDatas!=null&&resultDatas.size()>0){
                firstLinkerName=resultDatas.get(0).getLinkerName();
                firstLinkerPhone=resultDatas.get(0).getLinkPhone();
            }
        }
        String userName = userDetailResponse.getData().getUserName();
        String userNationalid = userDetailResponse.getData().getUserNationalid();
        String userPhone = userDetailResponse.getData().getUserPhone();
        String userHomeaddress = userDetailResponse.getData().getUserHomeaddress();
        String storeCode = orderInfo.get("storeCode").asText();
        String empCode =orderInfo.get("empNameCode").asText();
        String preModelUid= UUID.randomUUID().toString().replaceAll("-", "");
        asPreModelRequest.setBusinessNo(empCode);
        asPreModelRequest.setFirstContactName(firstLinkerName);
        asPreModelRequest.setFirstContactPhone(firstLinkerPhone);
        asPreModelRequest.setHomeAddress(userHomeaddress);
        asPreModelRequest.setName(userName);
        asPreModelRequest.setNationalId(userNationalid);
        asPreModelRequest.setPhone(userPhone);
        asPreModelRequest.setOrderNo(orderCode);
        asPreModelRequest.setPreModelUid(preModelUid);
        asPreModelRequest.setProductNo("3C");
        asPreModelRequest.setStoreId(storeCode);
        HttpEntity<AsPreModelRequest> requestEntity = new HttpEntity<>(asPreModelRequest, httpHeaders);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PreModelResponse preModelResponse = restTemplate.postForObject(preUrl, requestEntity,PreModelResponse.class);
        if (preModelResponse.isSuccess()) {
            String result="";
            ModelResultDataResponse data = preModelResponse.getData();
            if(data!=null){
                ModelResultResponse modelResult = data.getModelResult();
                if(modelResult!=null){
                    result= modelResult.getModelResult();
                }
            }
            XydFlowRequest xydFlowRequest=new XydFlowRequest();
            xydFlowRequest.setAsTag(result);
            xydFlowRequest.setAsTagTime(new Long(System.currentTimeMillis()));
            updateXydFlow(xydFlowRequest,orderCode);
            resul=true;
            return resul;
        }
        return resul;
    }

}
