package com.aishang.asjf.web.controller.salesman;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.CommodityClient;
import com.aishang.asjf.client.mallserver.request.MallRequest;
import com.aishang.asjf.client.mallserver.request.PayMonthRequest;
import com.aishang.asjf.client.mallserver.response.MallResponseWrapper;
import com.aishang.asjf.client.mallserver.response.StagesPlanResponseWrapper;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.request.salesman.MallRequestDTO;
import com.aishang.asjf.facade.dto.request.salesman.PayMonthRequestDTO;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by mx on 17-11-22.
 */
@RestController
@RequestMapping("empl")
@Api(description = "商品")
@Validated
public class CommodityController extends BaseController {

    @Autowired
    private CommodityClient commodityClient;

    @GetMapping("/commodity/v1")
    @ApiOperation(value = "选择商品", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper selectMall(@Valid MallRequestDTO mallRequestDTO) throws Exception {
        MallRequest request = new MallRequest();
        if (null != mallRequestDTO.getLevel1Name()) {
            request.setLevel1Name(mallRequestDTO.getLevel1Name());
        } else {
            request.setLevel1Name("");
        }
        if (null != mallRequestDTO.getLevel2Name()) {
            request.setLevel2Name(mallRequestDTO.getLevel2Name());
        } else {
            request.setLevel2Name("");
        }
        if (null != mallRequestDTO.getLevel2Name()) {
            request.setLevel3Name(mallRequestDTO.getLevel3Name());
        } else {
            request.setLevel3Name("");
        }
        if (null != mallRequestDTO.getCommodityName()) {
            request.setCommodityName(mallRequestDTO.getCommodityName());
        } else {
            request.setCommodityName("");
        }
        if (null != mallRequestDTO.getSort()) {
            request.setSort(mallRequestDTO.getSort().toString());
        } else {
            request.setSort("");
        }
        request.setLimit(mallRequestDTO.getLimit());
        request.setOffset(mallRequestDTO.getOffset());
        MallResponseWrapper wrapper = commodityClient.selectMall(request);
        return createResponse(wrapper.getData(), wrapper.getTotal().longValue());
    }

    @GetMapping("/commodity/linkage/v1")
    @ApiOperation(value = "选择商品三级联动", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper chooseMall() throws Exception {
        ClientResponseWrapper wrapper = commodityClient.chooseMall();
        return createResponse(wrapper.getData());
    }

    @GetMapping("/stagesPlan/{commodityCode}/v1")
    @ApiOperation(value = "分期方案", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper stagesPlan(@PathVariable String commodityCode) throws Exception {
        StagesPlanResponseWrapper wrapper = commodityClient.stagesPlan(commodityCode);
        return createResponse(wrapper.getData());
    }

    @GetMapping("/commodity/{code}/v1")
    @ApiOperation(value = "商品详情", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper MallInfo(@ApiParam(value = "商品code") @PathVariable String code) throws Exception {
        ClientResponseWrapper wrapper = commodityClient.getMallInfo(code);
        return createResponse(wrapper.getData());
    }

    @GetMapping("/payMonth/v1")
    @ApiOperation(value = "计算月供", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper CalculationPayMonth(@Valid PayMonthRequestDTO requestDTO) throws Exception {
        PayMonthRequest request = new PayMonthRequest();
        request.setLoanMoney(requestDTO.getLoanMoney());
        request.setPayTime(requestDTO.getPayTime());
        request.setProductCode(requestDTO.getProductCode());

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
        ClientResponseWrapper wrapper = commodityClient.getCalculationPayMonth(request);
        if(!wrapper.isSuccess()){
            return createResponse(ErrorCode.EXCEPTION);
        }
        return createResponse(wrapper.getData());
    }

}
