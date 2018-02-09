package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class GetCreditAdjustImgResponse extends CilentBaseResponse {

    List<CreditAdjustImgInfoResponse> resultData;

    public List<CreditAdjustImgInfoResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<CreditAdjustImgInfoResponse> resultData) {
        this.resultData = resultData;
    }
}
