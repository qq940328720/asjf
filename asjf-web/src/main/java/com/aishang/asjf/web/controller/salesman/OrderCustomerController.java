package com.aishang.asjf.web.controller.salesman;

import com.aishang.asjf.facade.dto.request.customer.CustomerRegRequestDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mx on 17-11-17.
 */
@RestController
@RequestMapping("orderCustomer")
@Api(description = "订单客户")
@Validated
public class OrderCustomerController extends BaseController {


    @GetMapping("/orderInfo/v1")
    @ApiOperation(value = "查询该业务员所有的订单", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper selectOrderInfo(@ApiParam(value = "业务员编号") @RequestParam String salesmanCode) throws Exception {
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        return createResponse(responseDTOWrapper);
    }

    @GetMapping("/customerInfo/v1")
    @ApiOperation(value = "客户", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getProduct(@Valid @RequestBody CustomerRegRequestDTO qrRequest, @ApiParam(value = "业务员编号") @RequestParam String salesmanCode) throws Exception {

        return createResponse();
    }

}
