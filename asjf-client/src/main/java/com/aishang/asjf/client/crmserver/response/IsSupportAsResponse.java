package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;


public class IsSupportAsResponse extends CilentBaseResponse {

    private int data;

    @Override
    public String toString() {
        return "IsSupportAsResponse{" +
                "data=" + data +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
