package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class ModelResultResponse implements Serializable {

    private String message;
    private String modelResult;
    private String code;

    @Override
    public String toString() {
        return "ModelResultResponse{" +
                "message='" + message + '\'' +
                ", modelResult='" + modelResult + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getModelResult() {
        return modelResult;
    }

    public void setModelResult(String modelResult) {
        this.modelResult = modelResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
