package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class OrderManagerResponse  extends CilentBaseResponse {

    private  OrderDataManagerResponse data;


    @Override
    public String toString() {
        return "OrderManagerResponse{" +
                "data=" + data +
                '}';
    }

    public OrderDataManagerResponse getData() {
        return data;
    }

    public void setData(OrderDataManagerResponse data) {
        this.data = data;
    }
}