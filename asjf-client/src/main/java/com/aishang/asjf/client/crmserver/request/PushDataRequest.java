package com.aishang.asjf.client.crmserver.request;


public class PushDataRequest {

    private String orderCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PushDataRequest that = (PushDataRequest) o;

        return orderCode != null ? orderCode.equals(that.orderCode) : that.orderCode == null;
    }

    @Override
    public int hashCode() {
        return orderCode != null ? orderCode.hashCode() : 0;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
