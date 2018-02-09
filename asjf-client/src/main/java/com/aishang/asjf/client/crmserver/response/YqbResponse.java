package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class YqbResponse implements Serializable {

    private YqbRegisResultResponse resultData;

    @Override
    public String toString() {
        return "YqbResponse{" +
                "resultData=" + resultData +
                '}';
    }

    public YqbRegisResultResponse getResultData() {
        return resultData;
    }

    public void setResultData(YqbRegisResultResponse resultData) {
        this.resultData = resultData;
    }
}
