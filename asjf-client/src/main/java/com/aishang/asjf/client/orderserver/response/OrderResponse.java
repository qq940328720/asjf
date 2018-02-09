package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class OrderResponse extends CilentBaseResponse {

    private OrderInfoResponse data;

    public OrderInfoResponse getData() {
        return data;
    }

    public void setData(OrderInfoResponse data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderResponse that = (OrderResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "data=" + data +
                '}';
    }
}
