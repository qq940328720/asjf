package com.aishang.asjf.web.controller.common;

import com.aishang.asjf.client.apiserver.ApiServerClient;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.response.CilentXydResponse;
import com.aishang.asjf.client.orderserver.OrderServerClient;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.common.enums.SmsCodeType;
import com.aishang.asjf.common.sms.SmsHelper;
import com.aishang.asjf.common.utils.ConstantClassFunction;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("sms")
@Api(description = "短信验证码")
@Validated
public class SmsController extends BaseController {

    @Autowired
    private ApiServerClient apiServerClient;

    @Autowired
    private CrmServerClient crmServerClient;

    @Autowired
    private OrderServerClient orderServerClient;

    @Autowired
    private SmsHelper smsHelper;

    @Value("${sms.reg.msg}")
    private String regMsg;

    @Value("${sms.password.modify}")
    private String passwordModifyMsg;

    @Value("${sms.sigVerification.msg}")
    private String sendVerificationMsg;


    @GetMapping("reg/v1")
    @ApiOperation(value = "发送短信验证码（注册）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendRegCode(
            @ApiParam(value = "手机号")
            @RequestParam
            @Pattern(regexp = ConstantClassFunction.REG_MOBILEPHONE)
                    String phone
    ) throws Exception {

        String code = smsHelper.generateCode(SmsCodeType.REG, phone);
        if (apiServerClient.sendSms(phone, String.format(regMsg, code))) {
            return createResponse();
        }
        return createResponse(ErrorCode.SMS_SEND_FAILURE);
    }

    @GetMapping("password/v1")
    @ApiOperation(value = "发送短信验证码（修改密码）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendModifyPasswordCode(
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

  /*  @GetMapping("sig/cust/v1")
    @ApiOperation(value = "发送短信验证码（签约爱尚）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendVerificationMsgCode(
            @ApiParam(value = "手机号")
            @RequestParam
            @Pattern(regexp = ConstantClassFunction.REG_MOBILEPHONE)
                    String phone
    ) throws Exception {
        String code = smsHelper.generateCode(SmsCodeType.SIG_VERIFICATION_CODE, phone);
        if (apiServerClient.sendSms(phone, String.format(sendVerificationMsg, code))) {
            return createResponse();
        }
        return createResponse(ErrorCode.SMS_SEND_FAILURE);
    }*/

}
