package com.aishang.asjf.web.controller.empl;

import com.aishang.asjf.client.apiserver.ApiServerClient;
import com.aishang.asjf.client.employee.EmplServerClient;
import com.aishang.asjf.client.employee.response.EmplClientResponse;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.common.enums.SmsCodeType;
import com.aishang.asjf.common.redis.ASJFCacheConfig;
import com.aishang.asjf.common.sms.SmsHelper;
import com.aishang.asjf.common.utils.ConstantClassFunction;
import com.aishang.asjf.common.utils.Md5SHA1Util;
import com.aishang.asjf.facade.dto.request.employee.EmplModifyPassWordRequestDTO;
import com.aishang.asjf.facade.dto.request.employee.EmployeeFindRequestDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.facade.dto.response.employee.EmplClientResponseDTO;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.security.Principal;

/**
 * Created by mx on 17-11-24.
 */
@RestController
@RequestMapping("empl")
@Api(description = "业务员接口")
public class EmplController extends BaseController {

    @Autowired
    private EmplServerClient emplServerClient;

    @Autowired
    private SmsHelper smsHelper;

    @Value("${sms.password.modify}")
    private String passwordModifyMsg;

    @Autowired
    private ApiServerClient apiServerClient;

    @GetMapping("/profile/v1")
    @ApiOperation(value = "业务员个人信息查询", response = ResponseDTOWrapper.class)
//    @Cacheable(value = ASJFCacheConfig.CACHE_EMPLOYEE_PROFILE, key = "#principal.name")
    public ResponseDTOWrapper profile(Principal principal) {
//        Object account = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EmplClientResponseDTO responseDTO = new EmplClientResponseDTO();
        EmplClientResponse emplInfo = emplServerClient.getEmplInfo(principal.getName());
        responseDTO.setData(emplInfo.getData());
        return createResponse(responseDTO.getData());
    }

//    @PutMapping("password/v1")
//    @ApiOperation(value = "业务员密码修改", response = ResponseDTOWrapper.class)
//    public ResponseDTOWrapper modifyPassword(@Valid @RequestBody CustomerPasswordModifyRequestDTO requestDTO, Principal principal) throws Exception {
//
////        EmployeeDetailsResponseDTO employeeDetailsResponseDTO = new EmployeeDetailsResponseDTO();
//
//        EmplClientResponse emplInfo = emplServerClient.getEmplInfo(principal.getName());
//        if (emplInfo.getData() == null){
//            return createResponse(ErrorCode.EXCEPTION);
//        }
////        String code = smsHelper.getSmsCode(SmsCodeType.MODIFY_PASSWORD, emplInfo.getData());
//        String code = null;
//        if (null == code || !code.equals(requestDTO.getCode())) {
////            SmsContainer.remove(customerRegRequestDTO.getPhone());
//            return createResponse(ErrorCode.SMS_CODE_INVALID);
//        }
//        if (!requestDTO.getPassword1().equals(requestDTO.getPassword2())) {
//            return createResponse(ErrorCode.TWO_PASSWORD_NOT_EQUALS);
//        }
////        custService.modifyPassword(requestDTO);
//        smsHelper.delete(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
////        SmsContainer.remove(requestDTO.getPhone());
//        return createResponse();
//    }

    @PutMapping("/password/v1")
    @ApiOperation(value = "业务员密码修改", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper modifyPassword(@Valid @RequestBody EmplModifyPassWordRequestDTO requestDTO, Principal principal, Authentication authentication) throws Exception {
//        CustomerDetailsResponseDTO customerDetailsResponseDTO = custService.findByCustCode(principal.getName());
        EmplClientResponse emplInfo = emplServerClient.getEmplInfo(principal.getName());
        String code = smsHelper.getSmsCode(SmsCodeType.MODIFY_PASSWORD, emplInfo.getData().getMobileno());
        if (null == code || !code.equals(requestDTO.getCode())) {
            //SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.SMS_CODE_INVALID);
        }
        if (!requestDTO.getPassword1().equals(requestDTO.getPassword2())) {
            return createResponse(ErrorCode.TWO_PASSWORD_NOT_EQUALS);
        }
        String passWord = Md5SHA1Util.md5(requestDTO.getPassword2());
        emplServerClient.EmplModifyPassword(emplInfo.getData().getEmployeeCode(), passWord);
        /*custService.modifyPassword(requestDTO);*/
//        smsHelper.delete(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
//        SmsContainer.remove(requestDTO.getPhone());
        return createResponse();
    }



    @GetMapping("/sms/password/v1")
    @ApiOperation(value = "发送短信验证码（修改密码）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendModifyPasswordCode( Principal principal) throws Exception {
        EmplClientResponse emplInfo = emplServerClient.getEmplInfo(principal.getName());
//        String phone = smsHelper.getSmsCode(SmsCodeType.MODIFY_PASSWORD, emplInfo.getData().getMobileno());
        String code = smsHelper.generateCode(SmsCodeType.MODIFY_PASSWORD,emplInfo.getData().getMobileno());
        if (apiServerClient.sendSms(emplInfo.getData().getMobileno(), String.format(passwordModifyMsg, code))) {
            return createResponse();
        }
        return createResponse(ErrorCode.SMS_SEND_FAILURE);
    }




    @PutMapping("/find/password/v1")
    @ApiOperation(value = "业务员找回密码", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper findPassword(@Valid @RequestBody EmployeeFindRequestDTO requestDTO, Principal principal, Authentication authentication) throws Exception {
//        CustomerDetailsResponseDTO customerDetailsResponseDTO = custService.findByCustCode(principal.getName());
        EmplClientResponse emplInfo = emplServerClient.getEmplInfo(principal.getName());
        String code = smsHelper.getSmsCode(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
        if (null == code || !code.equals(requestDTO.getCode())) {
            //SmsContainer.remove(customerRegRequestDTO.getPhone());
            return createResponse(ErrorCode.SMS_CODE_INVALID);
        }
        if (!requestDTO.getPassword1().equals(requestDTO.getPassword2())) {
            return createResponse(ErrorCode.TWO_PASSWORD_NOT_EQUALS);
        }
        String passWord = Md5SHA1Util.md5(requestDTO.getPassword2());
        emplServerClient.EmplModifyPassword(emplInfo.getData().getEmployeeCode(), passWord);
        /*custService.modifyPassword(requestDTO);*/
//        smsHelper.delete(SmsCodeType.MODIFY_PASSWORD, requestDTO.getPhone());
//        SmsContainer.remove(requestDTO.getPhone());
        return createResponse();
    }


    @GetMapping("/sms/find/password/v1")
    @ApiOperation(value = "发送短信验证码（找回密码）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendFindPasswordCode(
            @ApiParam(value = "手机号")
            @RequestParam
            @Pattern(regexp = ConstantClassFunction.REG_MOBILEPHONE)
                    String phone
    ) throws Exception {
        String code = smsHelper.generateCode(SmsCodeType.MODIFY_PASSWORD, phone);
        if (apiServerClient.sendSms(phone, String.format(passwordModifyMsg, code))) {
            return createResponse();
        }
        return createResponse(ErrorCode.SMS_SEND_FAILURE);
    }
}