package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

/**
 * Created by whb on 18-01-18.
 */
public class PayStateResponse extends CilentBaseResponse {

    Object data;

    @Override
    public String toString() {
        return "PayStateResponse{" +
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
