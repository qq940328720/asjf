package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.crmserver.response.info.BankbinInfo;

import java.util.List;

public class BankbinResponse extends CilentBaseResponse {

    private List<BankbinInfo> resultDatas;

    public List<BankbinInfo> getResultDatas() {
        return resultDatas;
    }

    public void setResultDatas(List<BankbinInfo> resultDatas) {
        this.resultDatas = resultDatas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankbinResponse that = (BankbinResponse) o;

        return resultDatas != null ? resultDatas.equals(that.resultDatas) : that.resultDatas == null;
    }

    @Override
    public int hashCode() {
        return resultDatas != null ? resultDatas.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BankbinResponse{" +
                "resultDatas=" + resultDatas +
                '}';
    }
}
