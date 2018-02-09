package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class PushDataResponse extends CilentBaseResponse {

    private String data;

    private Object errorCode;

    @Override
    public String toString() {
        return "PushDataResponse{" +
                "data='" + data + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}