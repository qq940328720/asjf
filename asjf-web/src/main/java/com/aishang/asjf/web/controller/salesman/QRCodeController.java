package com.aishang.asjf.web.controller.salesman;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.QrServerClient;
import com.aishang.asjf.client.mallserver.request.QrListRequest;
import com.aishang.asjf.client.mallserver.request.QrRequest;
import com.aishang.asjf.client.mallserver.response.QrCodeResponse;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.common.redis.ASJFCacheConfig;
import com.aishang.asjf.facade.dto.request.salesman.QrListRequestDTO;
import com.aishang.asjf.facade.dto.request.salesman.QrRequestDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mx on 17-11-17.
 */
@RestController
@RequestMapping("empl/qr")
@Api(description = "二维码")
@Validated
public class QRCodeController extends BaseController {

    @Autowired
    private QrServerClient qrServerClient;

    @PostMapping("/generate/v1")
    @ApiOperation(value = "生成二维码返回二维码编号", response = ResponseDTOWrapper.class)
//    @CacheEvict(value = ASJFCacheConfig.CACHE_QR, allEntries = true)
    public ResponseDTOWrapper GeneratingQrCode(@Valid @RequestBody QrRequestDTO request) throws Exception {
        QrRequest qrRequest = new QrRequest();
        qrRequest.setCommodityCode(request.getCommodityCode());
        qrRequest.setEmployeeCode(request.getEmployeeCode());
        qrRequest.setProductCode(request.getProductCode());
        qrRequest.setProductPrice(request.getProductPrice());
        qrRequest.setStoreCode(request.getStoreCode());

        if(null == request.getIsWarning()){
            qrRequest.setIsWarning(0);
        }else{
            qrRequest.setIsWarning(Integer.valueOf(request.getIsWarning()));
        }
        if(null == request.getIsRecommend()){
            qrRequest.setIsRecommend(0);
        }else{
            qrRequest.setIsRecommend(Integer.valueOf(request.getIsRecommend()));
        }

        ClientResponseWrapper wrapper = qrServerClient.GeneratingTwoDimensionalCode(qrRequest);
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
        if ("4".equals(message)) {
            return createResponse(ErrorCode.FAILURE);
        }
        return createResponse(wrapper.getData());
    }


    @GetMapping("/{code}/v1")
    @ApiOperation(value = "根据二维码编号查询二维码信息", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getQrCodeInfo(@ApiParam(value = "二维码编号") @PathVariable String code) throws Exception {
        ClientResponseWrapper wrapper = qrServerClient.getQrCodeInfo(code);
        return createResponse(wrapper.getData());
    }


    @GetMapping("/qrList/v1")
    @ApiOperation(value = "根据员工工号查询二维码列表分页", response = ResponseDTOWrapper.class)
//    @Cacheable(value = ASJFCacheConfig.CACHE_QR, key = "#requestDTO.employeeCode")
    public ResponseDTOWrapper getQrCodeList(@Valid QrListRequestDTO requestDTO) throws Exception {
        QrListRequest request = new QrListRequest();
        request.setEmployeeCode(requestDTO.getEmployeeCode());
        if (null == requestDTO.getMallName()) {
            request.setMallName("");
        } else {
            request.setMallName(requestDTO.getMallName());
        }
        if (null == requestDTO.getOffset()) {//第几页
            request.setOffset(1);
        } else {
            request.setOffset(requestDTO.getOffset());
        }
        if (null == requestDTO.getLimit()) {//每业显示条数
            request.setLimit(20);
        } else {
            request.setLimit(requestDTO.getLimit());
        }
        QrCodeResponse wrapper = qrServerClient.getQrCodeList(request);
        return createResponse(wrapper.getData(), wrapper.getTotal().longValue());
    }

    //对外不暴露内部调用
/*    @GetMapping("/qrValidity/v1")
    @ApiOperation(value = "根据二维码编号查询二维码是否失效", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getQrCodeTime(@ApiParam(value = "二维码编号") @RequestParam String qrValidity) throws Exception {
        ClientResponseWrapper dimensionalTime = qrServerClient.getQrValidity(qrValidity);
        if(!dimensionalTime.isSuccess()){
            return createResponse(ErrorCode.QR_CODE_INVALID);
        }
        return createResponse();
    }*/

}
