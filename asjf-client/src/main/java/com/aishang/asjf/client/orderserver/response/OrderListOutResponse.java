package com.aishang.asjf.client.orderserver.response;

import java.io.Serializable;
import java.util.List;

public class OrderListOutResponse implements Serializable {

    private List<OrderOutInfoResponse> resultData;


    @Override
    public String toString() {
        return "OrderListOutResponse{" +
                "resultData=" + resultData +
                '}';
    }

    public List<OrderOutInfoResponse> getResultData() {
        return resultData;
    }

    public void setResultData(List<OrderOutInfoResponse> resultData) {
        this.resultData = resultData;
    }
}
