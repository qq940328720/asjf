package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class WecashResponse extends CilentBaseResponse {

    private CustUrlResponse data;

    public CustUrlResponse getData() {
        return data;
    }

    public void setData(CustUrlResponse data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WecashResponse that = (WecashResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WecashResponse{" +
                "data=" + data +
                '}';
    }


}