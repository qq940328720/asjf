package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class UserOrderListResponse extends CilentBaseResponse {

    List<UserOrderListInfoResponse> resultData;

    public List<UserOrderListInfoResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<UserOrderListInfoResponse> resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "UserOrderListResponse{" +
                "resultData=" + resultData +
                '}';
    }
}
