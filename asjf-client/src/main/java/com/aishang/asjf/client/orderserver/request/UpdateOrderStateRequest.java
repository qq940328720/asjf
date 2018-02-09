package com.aishang.asjf.client.orderserver.request;


import com.aishang.asjf.client.orderserver.enums.CreditImageType;

public class UpdateOrderStateRequest {

    private String authCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateOrderStateRequest that = (UpdateOrderStateRequest) o;

        return authCode != null ? authCode.equals(that.authCode) : that.authCode == null;
    }

    @Override
    public int hashCode() {
        return authCode != null ? authCode.hashCode() : 0;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
