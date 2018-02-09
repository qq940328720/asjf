package com.aishang.asjf.web.controller.cust;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.request.PayMonthRequest;
import com.aishang.asjf.facade.dto.request.salesman.PayMonthRequestDTO;
import com.aishang.asjf.common.utils.IpUtils;
import com.aishang.asjf.client.mallserver.CustQrInfoClient;
import com.aishang.asjf.client.mallserver.QrServerClient;
import com.aishang.asjf.client.mallserver.request.CustPreOrderRequest;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.request.customer.CustPreOrderRequestDTO;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by mx on 17-11-23.
 */
@RestController
@RequestMapping("cust/qrApplyInfo")
@Api(description = "客户申请购买页面")
@Validated
public class CustQrInfoController extends BaseController {

    @Autowired
    private CustQrInfoClient custQrInfoClient;

    @Autowired
    private QrServerClient qrServerClient;

    //获得userCode
    public static String getuserCode() {
        Object account = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return account.toString();
    }

    //传入二维码编号拿到二维码信息，根据二维码表里面存入的code查询相关信息
    @GetMapping("/scanCodeApply/v1")
    @ApiOperation(value = "客户申请购买页面信息", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper ScanCodeApplyInfo(@ApiParam(value = "二维码编号") @RequestParam String qrCode) throws Exception {
        //先判断此二维码是否有效
        ClientResponseWrapper dimensionalTime = qrServerClient.getQrValidity(qrCode);
        if (!dimensionalTime.isSuccess()) {
            return createResponse(ErrorCode.QR_CODE_INVALID);
        }
        //getuserCode()
        ClientResponseWrapper qrCodeInfo = custQrInfoClient.getQrCodeInfo(qrCode,getuserCode());
        //1单子被拒绝
        if(null != qrCodeInfo.getMessage() && qrCodeInfo.getMessage().equals("1")){
            Object data = qrCodeInfo.getData();
            ResponseDTOWrapper response = createResponse(ErrorCode.REFUSAL_RECORD,String.valueOf(data));
            return response;
        }
        //2相同类型的单子只能下一个
        if(null != qrCodeInfo.getMessage() && qrCodeInfo.getMessage().equals("2")){
            return createResponse(ErrorCode.UNFINISHED_ORDERS);
        }
        return createResponse(qrCodeInfo.getData());
    }


    @PostMapping("/createOrder/v1")
    @ApiOperation(value = "客户下单", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper CustPreOrder(HttpServletRequest request,@Valid @RequestBody CustPreOrderRequestDTO requestDTO) throws Exception {
        //先判断此二维码是否有效
        /*ClientResponseWrapper dimensionalTime = qrServerClient.getQrValidity(qrCode);
        if (!dimensionalTime.isSuccess()) {
            return createResponse(ErrorCode.QR_CODE_INVALID);
        }*/

        CustPreOrderRequest custRequest = new CustPreOrderRequest();
        String qrCode = requestDTO.getQrCode();
        custRequest.setUserCode(requestDTO.getUserCode());//用户编号
        custRequest.setFirstPayMoney(requestDTO.getFirstPayMoney());//首付金额
        custRequest.setPayTime(requestDTO.getPayTime());//期数
        custRequest.setIsQuickPayPackage(requestDTO.getIsQuickPayPackage());//是否有提前还款包
        custRequest.setLng(requestDTO.getLng());//经度
        custRequest.setLat(requestDTO.getLat());//纬度
        //终端来源
        if("ANDROID".equals(requestDTO.getClientResource().toString())){
            custRequest.setClientResource(Integer.valueOf(requestDTO.getClientResource().getValue()));
        }
        if("IOS".equals(requestDTO.getClientResource().toString())){
            custRequest.setClientResource(Integer.valueOf(requestDTO.getClientResource().getValue()));
        }
        String ip = getIP(request);

        //下单时判断状态
        ClientResponseWrapper wrapper = custQrInfoClient.addCustPreOrder(custRequest,qrCode,ip);
        String message = wrapper.getMessage();
        if ("1".equals(message)) {
            return createResponse(ErrorCode.COMMODITY_STATE_EXCEPTION);
        }
        if ("2".equals(message)) {
            return createResponse(ErrorCode.STORE_STATE_EXCEPTION);
        }
        if ("3".equals(message)) {
            return createResponse(ErrorCode.PRODUCT_STATE_EXCEPTION);
        }
        //该业务员是否在门店范围内
        if ("4".equals(message)) {
            return createResponse(ErrorCode.NOT_IN_STORE);
        }
        //二维码是否有效
        if ("5".equals(message)) {
            return createResponse(ErrorCode.QR_CODE_INVALID);
        }
        if (!wrapper.isSuccess()) {
            return createResponse(ErrorCode.FAILURE);
        }

        return createResponse(wrapper.getData());
    }

    /**
     * 获取IP
     */
    private String getIP(HttpServletRequest request) {
        InetAddress addr = null;
        String ip = null;
//        if (IpUtils.isMobileDevice(request) == true) {// 判断当前登录人设备是电脑还是手机进行判断
            // 获得手机IP
            if (request.getHeader("x-forwarded-for") == null) {
                ip = request.getRemoteAddr();
            } else {
                ip = request.getHeader("x-forwarded-for");
            }
//        } else {
//            try {
//                addr = InetAddress.getLocalHost();
//            } catch (UnknownHostException
//                    e) {
//                e.printStackTrace();
//            }
//            // 获取电脑IP
//            ip = addr.getHostAddress();
//        }
        return ip;
    }


    @GetMapping("/payMonth/v1")
    @ApiOperation(value = "客户月供", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper CalculationPayMonth(@Valid PayMonthRequestDTO requestDTO) throws Exception {
        PayMonthRequest request = new PayMonthRequest();
        request.setLoanMoney(requestDTO.getLoanMoney());
        request.setPayTime(requestDTO.getPayTime());

        if (null == requestDTO.getPayTimeUnit()) {
            request.setPayTimeUnit("");
        } else {
            request.setPayTimeUnit(requestDTO.getPayTimeUnit().getEnumName().toString());
        }
        if (null == requestDTO.getInterestType()) {
            request.setInterestType("");
        } else {
            request.setInterestType(requestDTO.getInterestType().getEnumName().toString());
        }
        if (null == requestDTO.getIsPrePay()) {
            request.setIsPrePay(0);
        } else {
            request.setIsPrePay(requestDTO.getIsPrePay());
        }
        request.setTotalRate(requestDTO.getTotalRate());
        ClientResponseWrapper wrapper = custQrInfoClient.getCalculationPayMonth(request);
        if(!wrapper.isSuccess()){
            return createResponse(ErrorCode.EXCEPTION);
        }
        return createResponse(wrapper.getData());
    }


    @GetMapping("/allEnum/v1")
    @ApiOperation(value = "省市区以及订单所有枚举", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper CalculationPayMonth() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper wrapper = custQrInfoClient.getAllEnum();
        wrapperDTO.setData(wrapper.getData());
        return createResponse(wrapper.getData());
    }


}
