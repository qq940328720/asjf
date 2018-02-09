package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class ModelResultDataResponse implements Serializable {

    private ModelResultResponse modelResult;

    @Override
    public String toString() {
        return "ModelResultDataResponse{" +
                "modelResult=" + modelResult +
                '}';
    }

    public ModelResultResponse getModelResult() {
        return modelResult;
    }

    public void setModelResult(ModelResultResponse modelResult) {
        this.modelResult = modelResult;
    }
}
