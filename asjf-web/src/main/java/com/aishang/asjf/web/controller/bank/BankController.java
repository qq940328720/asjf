package com.aishang.asjf.web.controller.bank;


import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.request.UserBankRequest;
import com.aishang.asjf.client.crmserver.request.UserBankResquest;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.request.customer.UserBankResquestDTO;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.aishang.asjf.web.controller.cust.CustController.getuserCode;

@RestController
@RequestMapping("cust/bank")
@Api(description = "银行相关接口")
public class BankController extends BaseController {

    @Autowired
    private CrmServerClient crmServerClient;


  /*  @PostMapping("/cardBin/v1")
    @ApiOperation(value = "银行卡卡BIN接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qryUserWork(@Valid @RequestBody ApiResultBankbinRequest apiResultBankbinRequest) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qryCardBin(apiResultBankbinRequest);
        if (clientResponseWrapper.isSuccess() == false) {
            return createResponse(ErrorCode.NO_DATA);
        }
        return createResponse(clientResponseWrapper.getData());
    }*/


    @PutMapping("/{orderCode}/saveBank/v1")
    @ApiOperation(value = "保存用户银行卡信息(订单编号为唯一)", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveBankInfoOrder(@Valid @RequestBody UserBankRequest request) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveBankInfoOrder(request,getuserCode());
        wrapperDTO.setMessage(clientResponseWrapper.getMessage());
        if(clientResponseWrapper.getMessage()==null){
            return createResponse(clientResponseWrapper.getData());
        }
        if(wrapperDTO.getMessage().equals("1")){
            return createResponse(ErrorCode.FAILURE_OF_BANK_CARD_VERIFICATION);
        }
        if(wrapperDTO.getMessage().equals("2")){
            return createResponse(ErrorCode.DO_NOT_SUPPORT_CREDIT_CARDS);
        }
        if(wrapperDTO.getMessage().equals("3")){
            return createResponse(ErrorCode.DO_NOT_SUPPORT_THE_BANK);
        }
        if(wrapperDTO.getMessage().equals("4")){
            return createResponse(ErrorCode.USER_INFO_INCOMPLETE);
        }
        if(wrapperDTO.getMessage().equals("5")){
            return createResponse(ErrorCode.USER_THREE__ESSENTIAL_NO_PASS);
        }
        if(wrapperDTO.getMessage().equals("6")){
            return createResponse(ErrorCode.USER_SAVE_BANK_FAILED);
        }
        if(wrapperDTO.getMessage().equals("7")){
            return createResponse(ErrorCode.USER_UPDATE_COMPETION_FAILED);
        }
        if(wrapperDTO.getMessage().equals("8")){
            return createResponse(ErrorCode.USER__BANK_ILLEGAL);
        }
        if(wrapperDTO.getMessage().equals("9")){
            return createResponse(ErrorCode.GET_PRODUCT_IS_SUPPORT_AS_FAILURE);
        }
        return createResponse();
    }

    @PutMapping("/userBank/v1")
    @ApiOperation(value = "保存客户银行卡信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper saveUserBank(@Valid @RequestBody UserBankResquestDTO resquestDTO) throws Exception {
        UserBankResquest resquest = new UserBankResquest();
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        resquest.setBankCardImgUrl(resquestDTO.getBankCardImgUrl());
        resquest.setBankCardnumber(resquestDTO.getBankCardnumber());
        resquest.setBizid(resquestDTO.getBizid());
        resquest.setBankPhone(resquestDTO.getBankPhone());
        ClientResponseWrapper clientResponseWrapper = crmServerClient.saveBankInfo(resquest, getuserCode());
        wrapperDTO.setMessage(clientResponseWrapper.getMessage());
        if(clientResponseWrapper.getMessage()==null){
            return createResponse();
        }
        if(wrapperDTO.getMessage().equals("1")){
            return createResponse(ErrorCode.FAILURE_OF_BANK_CARD_VERIFICATION);
        }
        if(wrapperDTO.getMessage().equals("2")){
            return createResponse(ErrorCode.DO_NOT_SUPPORT_CREDIT_CARDS);
        }
        if(wrapperDTO.getMessage().equals("3")){
            return createResponse(ErrorCode.DO_NOT_SUPPORT_THE_BANK);
        }
        if(wrapperDTO.getMessage().equals("4")){
            return createResponse(ErrorCode.USER_INFO_INCOMPLETE);
        }
        if(wrapperDTO.getMessage().equals("5")){
            return createResponse(ErrorCode.USER_THREE__ESSENTIAL_NO_PASS);
        }
        if(wrapperDTO.getMessage().equals("6")){
            return createResponse(ErrorCode.USER_SAVE_BANK_FAILED);
        }
        if(wrapperDTO.getMessage().equals("7")){
            return createResponse(ErrorCode.USER_UPDATE_COMPETION_FAILED);
        }
        if(wrapperDTO.getMessage().equals("8")){
            return createResponse(ErrorCode.USER__BANK_ILLEGAL);
        }
        return createResponse();
    }


    @GetMapping("/userBank/v1")
    @ApiOperation(value = "查询客户银行卡信息接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qryUserBank() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = crmServerClient.qryUserBank(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }


  /*  @PostMapping("/{bizid}/bank/v1")
    @ApiOperation(value = "银行卡解绑接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper UserWork(@PathVariable String bizid) throws Exception {
        ClientResponseWrapper clientResponseWrapper = crmServerClient.releaseBank(bizid,getuserCode());
        if (clientResponseWrapper.isSuccess() == false) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }*/
}
