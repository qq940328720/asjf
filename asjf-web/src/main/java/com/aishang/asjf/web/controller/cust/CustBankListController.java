package com.aishang.asjf.web.controller.cust;

import com.aishang.asjf.client.apiserver.CustBankClient;
import com.aishang.asjf.client.base.ClientResponseWrapper;
import com.aishang.asjf.common.redis.ASJFCacheConfig;
import com.aishang.asjf.facade.dto.response.base.ClientResponseWrapperDTO;
import com.aishang.asjf.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.asjf.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mx on 17-12-9.
 */
@RestController
@RequestMapping("cust/bank")
@Api(description = "银行卡列表")
@Validated
public class CustBankListController extends BaseController {

    @Autowired
    private CustBankClient custBankClient;

    @GetMapping("/list/v1")
    @ApiOperation(value = "银行卡列表", response = ResponseDTOWrapper.class)
    @Cacheable(value = ASJFCacheConfig.CACHE_BANKS)
    public ResponseDTOWrapper ScanCodeApplyInfo() throws Exception {
        ClientResponseWrapperDTO wrapperDTO = new ClientResponseWrapperDTO();
        ClientResponseWrapper qrCodeInfo = custBankClient.getBankList();
        wrapperDTO.setData(qrCodeInfo.getData());
        return createResponse(wrapperDTO.getData());
    }

}
