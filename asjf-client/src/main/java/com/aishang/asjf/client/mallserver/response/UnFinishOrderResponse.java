package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

/**
 * Created by mx on 17-12-18.
 */
public class UnFinishOrderResponse extends CilentBaseResponse {

    private Integer data;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnFinishOrderResponse that = (UnFinishOrderResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UnFinishOrderResponse{" +
                "data=" + data +
                '}';
    }
}
