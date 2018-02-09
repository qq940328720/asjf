package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class SigUrlResponse implements Serializable {


    private SigDataResponse data;

    private boolean success;

    private Object errorCode;

    @Override
    public String toString() {
        return "SigUrlResponse{" +
                "data=" + data +
                ", success=" + success +
                ", errorCode=" + errorCode +
                '}';
    }

    public SigDataResponse getData() {
        return data;
    }

    public void setData(SigDataResponse data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }
}
