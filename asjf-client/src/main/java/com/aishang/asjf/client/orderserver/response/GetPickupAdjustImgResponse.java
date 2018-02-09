package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class GetPickupAdjustImgResponse extends CilentBaseResponse {

    List<PickupAdjustImgInfoResponse> resultData;

    public List<PickupAdjustImgInfoResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<PickupAdjustImgInfoResponse> resultData) {
        this.resultData = resultData;
    }
}
