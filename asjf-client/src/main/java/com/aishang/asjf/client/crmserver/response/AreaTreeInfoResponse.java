package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class AreaTreeInfoResponse extends CilentBaseResponse {

    private List<AreaInfoResponse> data;

    @Override
    public String toString() {
        return "AreaTreeInfoResponse{" +
                "data=" + data +
                '}';
    }

    public List<AreaInfoResponse> getData() {
        return data;
    }

    public void setData(List<AreaInfoResponse> data) {
        this.data = data;
    }
}
