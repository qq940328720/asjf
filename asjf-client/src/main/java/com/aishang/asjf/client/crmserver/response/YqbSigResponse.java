package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class YqbSigResponse implements Serializable {

    private boolean success;

    private Object data;

    @Override
    public String toString() {
        return "YqbSigResponse{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
