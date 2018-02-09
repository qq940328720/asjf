package com.aishang.asjf.client.apiserver.response;

import com.aishang.asjf.client.apiserver.response.info.BankInfo;
import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

/**
 * Created by mx on 17-12-9.
 */
public class BankResponse extends CilentBaseResponse {

    private List<BankInfo> data;

    public List<BankInfo> getData() {
        return data;
    }

    public void setData(List<BankInfo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankResponse that = (BankResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BankResponse{" +
                "data=" + data +
                '}';
    }
}
