package com.aishang.asjf.web.controller.cust;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.client.crmserver.request.AddPickupImgRequest;
import com.aishang.asjf.client.crmserver.request.ImgInfo;
import com.aishang.asjf.client.crmserver.request.UpdRejectImgRequest;
import com.aishang.asjf.client.crmserver.response.CilentXydResponse;
import com.aishang.asjf.client.orderserver.OrderServerClient;
import com.aishang.asjf.client.orderserver.request.UpdateCreditAdjustImgRequest;
import com.aishang.asjf.client.orderserver.request.UpdatePickupAdjustImgRequest;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.request.customer.ReceiveWecashAsynRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.UpdRejectImgDTO;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cust/order")
@Api(description = "客户订单接口")
public class CustOrderController extends BaseController {

    @Autowired
    private OrderServerClient orderServerClient;
    @Autowired
    private CrmServerClient crmServerClient;

    private Integer i =1;

    /**
     * new 查询驳回照片
     * @param orderCode
     * @return
     * @throws Exception
     */
    @GetMapping("/getImageList/{orderCode}/v1")
    @ApiOperation(value = "查询驳回照片(new)", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getImgList(@PathVariable @NotEmpty @NotNull String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.getCustImgList(orderCode);
        return createResponse(clientResponseWrapper.getData());
    }

    @PutMapping("/updImageList/{orderCode}/v1")
    @ApiOperation(value = "修改驳回照片(new)", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper updImageList(@RequestBody UpdRejectImgDTO rejectImgDTO,@PathVariable String orderCode) throws Exception {
        UpdRejectImgRequest request = new UpdRejectImgRequest();
        request.setStringCode(rejectImgDTO.getStringCode());
        List<ImgInfo> list = new ArrayList<>();
        for (int i = 0; i < rejectImgDTO.getRecieveData().size(); i++) {
            ImgInfo info = new ImgInfo();
            info.setImgTypeCode(rejectImgDTO.getRecieveData().get(i).getImgTypeCode());
            info.setImgTypeno(rejectImgDTO.getRecieveData().get(i).getImgTypeno());
            info.setImgUrl(rejectImgDTO.getRecieveData().get(i).getImgUrl());
            list.add(info);
        }
        request.setRecieveData(list);
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updateRejectImageList(request,orderCode,getuserCode());
        return createResponse(clientResponseWrapper.getData());
    }

    @GetMapping("/getCustOrderList/v1")
    @ApiOperation(value = "获得客户端订单列表", response = ResponseDTOWrapper.class)
//    @Cacheable(value = ASJFCacheConfig.CACHE_CUSTOMER_ORDERS, key = "#principal.name")
    public ResponseDTOWrapper getCustOrderList(Principal principal) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper clientResponseWrapper = orderServerClient.getOrderList(getuserCode());
        wrapperDTO.setData(clientResponseWrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

    @PostMapping("/{orderCode}/pickImage/v1")
    @ApiOperation(value = "保存提货照接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper savePickImage(@Valid @RequestBody AddPickupImgRequest addPickupImgRequest,@Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.savePickImage(addPickupImgRequest, getuserCode(),orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }

    @PutMapping("/{orderCode}/creditImage/v1")
    @ApiOperation(value = "修改用户信审照片接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper updCreditIma(@Valid @RequestBody UpdateCreditAdjustImgRequest updateCreditAdjustImgRequest, @Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updateCreditImage(updateCreditAdjustImgRequest, getuserCode(),orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }

    @PutMapping("/{orderCode}/pickImage/v1")
    @ApiOperation(value = "修改用户提货照片接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper updatePickImage(@Valid @RequestBody UpdatePickupAdjustImgRequest updatePickupAdjustImgRequest, @Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updatePickImage(updatePickupAdjustImgRequest, getuserCode(),orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getMessage());
    }

    @GetMapping("/{orderCode}/pickImage/v1")
    @ApiOperation(value = "查询被驳回提货照接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getPickupAdjustImg(@Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.getPickupAdjustImg(orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(clientResponseWrapper.getMessage());
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @GetMapping("/{orderCode}/auditImage/v1")
    @ApiOperation(value = "查询被驳回信审照接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getCreditAdjustImg(@Valid @PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.getCreditAdjustImg(orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(clientResponseWrapper.getMessage());
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @PutMapping("/{orderCode}/stateTOCredit/v1")
    @ApiOperation(value = "修改订单状态为待信审", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper updateOrderStateToCredit(@Valid@PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updateOrderStateToCredit(orderCode);
        JsonNode orderInfo = orderServerClient.getOrderInfo(orderCode);
        String authCode = orderInfo.get("authCode").asText();
        orderServerClient.getWecashMobile(authCode);
        if(i==1){
            boolean b = crmServerClient.preModel(getuserCode(), orderCode);
            if(!b){
                return createResponse(ErrorCode.FAILURE);
            }
        }
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse();
    }

    @PutMapping("/updateIfPushPreModel/v1")
    @ApiOperation(value = "是否推前置模型开关", response = ResponseDTOWrapper.class)
    public Integer updateIfPushPreModel() throws Exception {
        if(i==1){
            i=0;
        } else{
            i=1;
        }
        return i;
    }

    @GetMapping("/isMustDeImeIcode/{orderCode}/v1")
    @ApiOperation(value = "查询设备串码是否必填", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getIsMustDeImeIcode(@PathVariable String orderCode) throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper wrapper = orderServerClient.queryIsMustDeImeIcode(orderCode);
        wrapperDTO.setData(wrapper.getData());
        return createResponse(wrapperDTO.getData());
    }

    @GetMapping("/auth/{orderCode}/v1")
    @ApiOperation(value = "查询授权页面", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getIMustDeImeIcode(@PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.queryAuth(orderCode);
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(clientResponseWrapper.getMessage());
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @PutMapping("/isAuth/v1")
    @ApiOperation(value = "接收闪银异步通知接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper updateOrderIsAuth(@Valid @RequestBody ReceiveWecashAsynRequestDTO requestDTO) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updateOrderIsAuth(requestDTO.getOrderCode(),getuserCode());
        if (clientResponseWrapper.getMessage().equals("1") ) {
            return createResponse(ErrorCode.NOT_BELONG_USERSELF_ORDER);
        }
        if (!clientResponseWrapper.isSuccess() ) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse();
    }

    @GetMapping("/{orderCode}/repayList/v1")
    @ApiOperation(value = "查询还款计划列表接口", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getrepayList(@Valid@PathVariable String orderCode) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.getPayList(orderCode);
        if(!clientResponseWrapper.isSuccess()){
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getData());
    }

    @PutMapping("/{orderCode}/{payTime}/{payState}/payState/v1")
    @ApiOperation(value = "修改还款计划状态", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getrepst(@Valid@PathVariable String orderCode,@Valid @PathVariable String payTime,@Valid @PathVariable String payState) throws Exception {
        ClientResponseWrapper clientResponseWrapper = orderServerClient.updateOrderSignPayState(orderCode,payTime,payState);
        if(!clientResponseWrapper.isSuccess()){
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse();
    }

    @PutMapping("/sigResult/{orderCode}/v1")
    @ApiOperation(value = "接收小雨点签约成功的异步通知", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper qrytureInfo(@Valid @PathVariable String orderCode) throws Exception {
        CilentXydResponse clientResponseWrapper = orderServerClient.updateXydSigResult(orderCode);
        if (clientResponseWrapper.getMessage().equals("1")) {
            return createResponse(ErrorCode.FAILURE);
        }
        if (!clientResponseWrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(clientResponseWrapper.getData());
    }
}
