package com.aishang.asjf.web.controller.cust;


import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.enums.ContactNcontactnameEnum;
import com.aishang.asjf.client.crmserver.enums.MoneyResourceEnum;
import com.aishang.asjf.client.crmserver.request.*;
import com.aishang.asjf.client.crmserver.response.CilentXydResponse;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.common.enums.SmsCodeType;
import com.aishang.asjf.common.redis.ASJFCacheConfig;
import com.aishang.asjf.common.sms.SmsHelper;
import com.aishang.asjf.facade.dto.request.customer.*;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.facade.dto.response.customer.CustomerDetailsResponseDTO;
import com.aishang.asjf.facade.service.ICustService;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cust")
@Api(description = "客户接口")
public class CustController extends BaseController {

    @Autowired
    private ICustService custService;
    @Autowired
    private SmsHelper smsHelper;
    @Autowired
    private CrmServerClient crmServerClient;

    @Value("${server.crm.manager.root}")
    private String crmUrl;

    @GetMapping("/profile/v1")
    @ApiOperation(value = "客户一级信息查询", response = ResponseDTOWrapper.class)
//    @Cacheable(value = ASJFCacheConfig.CACHE_CUSTOMER_PROFILE, key = "#principal.name")
    public ResponseDTOWrapper profile(Principal principal) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.getCompletion(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

    @GetMapping("/baseInfo/v1")
    @ApiOperation(value = "客户个人信息查询", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getbaseInfo() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qryUserBaseInfo(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

    @PutMapping("password/v1")
    @ApiOperation(value = "客户密码修改", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper modifyPassword(@Valid @RequestBody CustomerPasswordModifyRequestDTO requestDTO, Principal principal, Authentication authentication) throws Exception {
//        CustomerDetailsResponseDTO customerDetailsResponseDTO = custService.findByCustCode(requestDTO.getPhone());
        String code = smsHelper.getSmsCode(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
        if (null == code || !code.equals(requestDTO.getCode())) {
//            SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.SMS_CODE_INVALID);
        }
        if (!requestDTO.getPassword1().equals(requestDTO.getPassword2())) {
            return createResponse(ErrorCode.TWO_PASSWORD_NOT_EQUALS);
        }
        custService.modifyPassword(requestDTO);
        smsHelper.delete(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
//        SmsContainer.remove(requestDTO.getPhone());
        return createResponse();
    }

/*    @PostMapping("sig/v1")
    @ApiOperation(value = "爱尚确认签署合同", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sig(@Valid @RequestBody CustSigRequestDTO request) throws Exception {
        String code = smsHelper.getSmsCode(SmsCodeType.SIG_VERIFICATION_CODE, request.getPhone());
        if (null == code || !code.equals(request.getCode())) {
//            SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.SMS_CODE_INVALID);
        }
        smsHelper.delete(SmsCodeType.SIG_VERIFICATION_CODE, request.getPhone());
//        SmsContainer.remove(requestDTO.getPhone());
        return createResponse();
    }*/

    @PostMapping("reg/v1")
    @ApiOperation(value = "客户注册", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper reg(@Valid @RequestBody CustomerRegRequestDTO customerRegRequestDTO) throws Exception {
        String code = smsHelper.getSmsCode(SmsCodeType.REG, customerRegRequestDTO.getPhone());
        LOGGER.info("{}", code);
        if (null == code || !code.equals(customerRegRequestDTO.getCode())) {
//            SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.SMS_CODE_INVALID);
        }
        CustomerDetailsResponseDTO customerDetailsResponseDTO = custService.findByPhone(customerRegRequestDTO.getPhone());
        if (customerDetailsResponseDTO != null) {
//            SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.USER_EXIST);
        }
        if (!customerRegRequestDTO.getPassword1().equals(customerRegRequestDTO.getPassword2())) {
            return createResponse(ErrorCode.TWO_PASSWORD_NOT_EQUALS);
        }
        custService.reg(customerRegRequestDTO);
//        SmsContainer.remove(customerRegRequestDTO.getPhone());
        LOGGER.info("注册成功");
        smsHelper.delete(SmsCodeType.MODIFY_PASSWORD, customerRegRequestDTO.getPhone());
        return createResponse();
    }


    @PutMapping("userBaseInfo/v1")
    @ApiOperation(value = "保存客户基本信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveUserBaseInfo(@Valid @RequestBody UserSaveBaseRequestDTO userSaveBaseRequest) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        UserSaveBaseRequest request=new UserSaveBaseRequest();
        request.setCityCode(userSaveBaseRequest.getCityCode());
        request.setDistrictCode(userSaveBaseRequest.getDistrictCode());
        request.setFmImaUrl(userSaveBaseRequest.getFmImaUrl());
        request.setNowAddress(userSaveBaseRequest.getNowAddress());
        request.setProvinceCode(userSaveBaseRequest.getProvinceCode());
        request.setQrImaUrl(userSaveBaseRequest.getQrImaUrl());
        request.setRegisterAddress(userSaveBaseRequest.getRegisterAddress());
        request.setScImaUrl(userSaveBaseRequest.getScImaUrl());
        request.setUserGender(userSaveBaseRequest.getUserGender());
        request.setUserIsmarried(userSaveBaseRequest.getUserIsmarried());
        request.setUserName(userSaveBaseRequest.getUserName());
        request.setUserNationalid(userSaveBaseRequest.getUserNationalid());
        request.setValiddaterange(userSaveBaseRequest.getValiddaterange());
        request.setZmImaUrl(userSaveBaseRequest.getZmImaUrl());
        request.setClientResource(userSaveBaseRequest.getClientResource());
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveUserBaseInfo(request, getuserCode());
        if (clientResponseWrapper.getMessage().equals("1")) {
            return createResponse(ErrorCode.USER__IDCERT_NAME_UNMATCH);
        }
        if (clientResponseWrapper.getMessage().equals("2")) {
            return createResponse(ErrorCode.USER_CREDIT_IMAGE_INCOMPLETE);
        }
        if (clientResponseWrapper.getMessage().equals("3")) {
            return createResponse(ErrorCode.IDCERT_WILL_OVERDUE);
        }
        if (clientResponseWrapper.getMessage().equals("4")) {
            return createResponse(ErrorCode.IDCERT_OVERDUED);
        }
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse();
    }

    @PutMapping("/userWork/v1")
    @ApiOperation(value = "保存客户工作信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveUserWork(@Valid @RequestBody UserSaveWorkResquestDTO workResquest) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        UserSaveWorkResquest request=new UserSaveWorkResquest();
        request.setProfession(workResquest.getProfession());
        request.setUserHighesteducation(workResquest.getUserHighesteducation());
        request.setUserIncome(workResquest.getUserIncome());
        if(workResquest.getUserIncome().longValue()<=0){
            return createResponse(ErrorCode.USET_INCOME_NOT_LITTLE_TO_ZERO);
        }
        request.setUserIncomeResource(workResquest.getUserIncomeResource());
        request.setwAddressCompanyName(workResquest.getwAddressCompanyName());
        request.setwAddressDetail(workResquest.getwAddressDetail());
        request.setwAddressMobile(workResquest.getwAddressMobile());
        request.setWorkPosition(workResquest.getWorkPosition());
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveWorkInfo(request, getuserCode());
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getMessage());
    }

    @PutMapping("/userContacts/v1")
    @ApiOperation(value = "保存客户联系人信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveUserContacts(@Valid@RequestBody SaveLinkerListRequestDTO listRequestDTO) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        SaveLinkerListRequest request=new SaveLinkerListRequest();
        List<SaveLinkerRequestDTO> linklist = listRequestDTO.getLinkerList();
        Map<Byte, SaveLinkerRequestDTO> map = new HashMap<>();
        if (linklist != null && linklist.size() > 0) {
            List<SaveLinkerRequest> list=new ArrayList<>();
            for (SaveLinkerRequestDTO saveLinkerRequest1 : linklist) {
                SaveLinkerRequest saveLinkerRequest=new SaveLinkerRequest();
                saveLinkerRequest.setCityCode(saveLinkerRequest1.getCityCode());
                saveLinkerRequest.setDistrictCode(saveLinkerRequest1.getDistrictCode());
                saveLinkerRequest.setHomeAddress(saveLinkerRequest1.getHomeAddress());
                saveLinkerRequest.setLinkerName(saveLinkerRequest1.getLinkerName());
                saveLinkerRequest.setLinkPhone(saveLinkerRequest1.getLinkPhone());
                saveLinkerRequest.setNo(saveLinkerRequest1.getNo());
                saveLinkerRequest.setProvinceCode(saveLinkerRequest1.getProvinceCode());
                saveLinkerRequest.setRelation(saveLinkerRequest1.getRelation());
                list.add(saveLinkerRequest);
                map.put(saveLinkerRequest1.getNo().getValue(), saveLinkerRequest1);
            }
            request.setLinkerList(list);
        }
        SaveLinkerRequestDTO saveLinkRequest = map.get(ContactNcontactnameEnum.CONTACT_1ST.getValue());
        if (saveLinkRequest == null) {
            wrapperDTO.setSuccess(false);
            return createResponse(ErrorCode.FIRST_LINKER_INFO_CANT_EMPTY);
        }
        if (saveLinkRequest.getCityCode().isEmpty()) {
            return createResponse(ErrorCode.FIRST_LINKER_CANT_EMPTY);
        }
        if (saveLinkRequest.getDistrictCode().isEmpty()) {
            return createResponse(ErrorCode.FIRST_LINKER_CANT_EMPTY);
        }
        if (saveLinkRequest.getProvinceCode().isEmpty()) {
            return createResponse(ErrorCode.FIRST_LINKER_CANT_EMPTY);
        }
        if (saveLinkRequest.getHomeAddress().isEmpty()) {
            return createResponse(ErrorCode.FIRST_LINKER_ADDRESS_DETAILED_CANT_EMPTY);
        }
        SaveLinkerRequestDTO secondRequest = map.get(ContactNcontactnameEnum.CONTACT_2ND.getValue());
        if (secondRequest == null) {
            wrapperDTO.setSuccess(false);
            return createResponse(ErrorCode.SECOND_LINKER_INFO_CANT_EMPTY);
        }
        SaveLinkerRequestDTO thirdRequest = map.get(ContactNcontactnameEnum.CONTACT_3RD.getValue());
        if (thirdRequest == null) {
            wrapperDTO.setSuccess(false);
            return createResponse(ErrorCode.THIRD_LINKER_INFO_CANT_EMPTY);
        }
        List<SaveLinkerRequestDTO> linkerList = listRequestDTO.getLinkerList();
        //request.setLinkerList();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveContactInfo(request, getuserCode());
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getMessage());
    }

    @GetMapping("/userWork/v1")
    @ApiOperation(value = "查询客户工作信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qryUserWork() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qryUserWork(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

    @GetMapping("/userContacts/v1")
    @ApiOperation(value = "查询客户联系人信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qryUserContacts() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qryUserContacts(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

/*    @GetMapping("/userCompetition/v1")
    @ApiOperation(value = "查询客户资料完善度接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qryCompetition() throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.getCompletion(getuserCode());
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(clientResponseWrapper.getMessage());
        }
        return createResponse(clientResponseWrapper.getData());
    }*/


    @PutMapping("/addressList/v1")
    @ApiOperation(value = "保存用户通讯录接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveAddressList(@Valid @RequestBody UserSaveTeleListRequest userSaveTeleListRequest) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveAddressList(userSaveTeleListRequest, getuserCode());
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }

    @PostMapping("/custmerId/v1")
    @ApiOperation(value = "点击授权", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getCustmerId(@Valid @RequestBody CustomerRequest customerRequest) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.getCustomerId(customerRequest);
        if (clientResponseWrapper.getMessage().equals("1")) {
            return createResponse(ErrorCode.USER_GET_CUSTMERID_FAILURE);
        }
        if (clientResponseWrapper.getMessage().equals("2")) {
            return createResponse(ErrorCode.SAVE_CUSTMERID_FAILURE);
        }
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @PutMapping("/userOthers/v1")
    @ApiOperation(value = "上传用户其他资料", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveOthers(@Valid @RequestBody SaveUserOtherImgRequest saveUserImgRequest) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveUserOthers(saveUserImgRequest,getuserCode());
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }

    @PostMapping("/{name}/{orderCode}/v1")
    @ApiOperation(value = "查询电子签地址", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper pushData(@Valid @PathVariable String orderCode,@Valid @PathVariable MoneyResourceEnum name) throws Exception {
        CilentXydResponse clientResponseWrapper = crmServerClient.xydSignature(orderCode,getuserCode(),name);
        if (clientResponseWrapper.getMessage().equals("3")) {
            return createResponse(ErrorCode.GET_SIGNATRUE_FAILURE);
        }
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @GetMapping("/contract/{orderCode}/v1")
    @ApiOperation(value = "查询该产品的签约合同相关信息", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qrySignatureInfo(@Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qrySignatureInfo(orderCode,getuserCode());
        if (clientResponseWrapper.getMessage().equals("1")) {
            return createResponse(ErrorCode.GET_PRODUCT_SIGN_INFO_FAILURE);
        }
        if (clientResponseWrapper.getMessage().equals("2")) {
            return createResponse(ErrorCode.NO_PRODUCT_INFO);
        }
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getData());
    }


}
