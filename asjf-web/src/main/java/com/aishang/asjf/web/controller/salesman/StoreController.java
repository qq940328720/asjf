package com.aishang.asjf.web.controller.salesman;

import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.client.mallserver.StoreClient;
import com.aishang.asjf.common.enums.ErrorCode;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mx on 17-11-22.
 */
@RestController
@RequestMapping("empl")
@Api(description = "门店")
@Validated
public class StoreController extends BaseController {

    @Autowired
    private StoreClient storeClient;

    @GetMapping("/{code}/store/v1")
    @ApiOperation(value = "选择门店", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getStores(@ApiParam(value = "业务员编号") @PathVariable @Length String code) throws Exception {
        ClientResponseWrapper dimensionalTime = storeClient.getStores(code);
        if (!dimensionalTime.isSuccess()) {
            return createResponse(ErrorCode.UNBOUNDU_STORES);
        }
        return createResponse(dimensionalTime.getData());
    }

}
