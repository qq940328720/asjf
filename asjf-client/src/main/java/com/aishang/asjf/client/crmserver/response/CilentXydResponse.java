package com.aishang.asjf.client.crmserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CilentXydResponse implements Serializable {

    private String data;
    private boolean success;
    private boolean executed;
    private String message;

    @Override
    public String toString() {
        return "CilentXydResponse{" +
                "data='" + data + '\'' +
                ", success=" + success +
                ", executed=" + executed +
                ", message='" + message + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
