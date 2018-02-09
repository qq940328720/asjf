package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class UserImgResponse extends CilentBaseResponse {
    private List<UserImgInfoResponse> data;

    public List<UserImgInfoResponse> getData() {
        return data;
    }

    public void setData(List<UserImgInfoResponse> data) {
        this.data = data;
    }
}
