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
import com.aishang.asjf.facade.dto.request.sig.SigRequestDTO;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cust/sig")
@Api(description = "客户签约接口")
public class CustSigController extends BaseController {

    @Autowired
    private SmsHelper smsHelper;
    @Autowired
    private CrmServerClient crmServerClient;

    @Value("${asjf.server.url.root}")
    private String asjfRootUrl;

    @Value("${asjf.as.callback.url}")
    private String asCallbackUrl;//资金渠道服务地址

    @Value("${firmNo.url}")
    private String firmNo;//资金渠道服务地址

    @Value("${server.funds.manager.root}")
    private String fundsUrl;//资金渠道服务地址



    @GetMapping("sms/v1")
    @ApiOperation(value = "发送短信验证码（签约爱尚）", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper sendVerificationMsgCode() throws Exception {
        /*ClientResponseWrapper clientResponseWrapper = crmServerClient.sendAuthCode(getuserCode());
        if(!clientResponseWrapper.isSuccess()){
            createResponse(ErrorCode.SMS_SEND_FAILURE);
        }*/
        ClientResponseWrapper clientResponseWrapper =new ClientResponseWrapper();
        clientResponseWrapper.setData("4856");
        return createResponse(clientResponseWrapper.getData());
    }


    @PostMapping("/{orderCode}/contract/v1")
    @ApiOperation(value = "爱尚签约接口", response = ResponseDTOWrapper.class)
    public void sig(@Valid @PathVariable String orderCode,HttpServletResponse response) throws Exception {
        String sigUrl = fundsUrl+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+asCallbackUrl+"&firmNo="+firmNo;
        //String sigUrl = "http://192.168.1.54:8093"+"/sign/"+orderCode+"/eqbHtml?notifyUrl="+asjfRootUrl+asCallbackUrl+"&firmNo="+firmNo;
        response.sendRedirect(sigUrl);
    }



}
