package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class WecashrResponse extends CilentBaseResponse {

    private Object data;

    @Override
    public String toString() {
        return "WecashrResponse{" +
                "data=" + data +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
