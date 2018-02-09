package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

/**
 * Created by whb on 18-01-18.
 */
public class UserPayBackPlansResponse extends CilentBaseResponse {

    List<UserPayBackPlansInfoResponse> resultData;

    public List<UserPayBackPlansInfoResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<UserPayBackPlansInfoResponse> resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "UserPayBackPlansResponse{" +
                "resultData=" + resultData +
                '}';
    }
}
