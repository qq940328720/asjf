package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.crmserver.response.info.DicBankInfo;

import java.util.List;

public class DicBankResponse extends CilentBaseResponse {
    private List<DicBankInfo> data;

    public List<DicBankInfo> getData() {
        return data;
    }

    public void setData(List<DicBankInfo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DicBankResponse that = (DicBankResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DicBankResponse{" +
                "data=" + data +
                '}';
    }
}
