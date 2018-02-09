package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class PreModelResponse extends CilentBaseResponse {

    private ModelResultDataResponse data;

    private Object errorCode;

    @Override
    public String toString() {
        return "PreModelResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                '}';
    }

    public ModelResultDataResponse getData() {
        return data;
    }

    public void setData(ModelResultDataResponse data) {
        this.data = data;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }
}