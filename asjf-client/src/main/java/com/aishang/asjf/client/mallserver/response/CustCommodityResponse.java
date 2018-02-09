package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.CustCommodityInfo;

/**
 * Created by mx on 17-12-4.
 */
public class CustCommodityResponse extends CilentBaseResponse {
    private CustCommodityInfo commData;

    public CustCommodityInfo getCommData() {
        return commData;
    }

    public void setCommData(CustCommodityInfo commData) {
        this.commData = commData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustCommodityResponse that = (CustCommodityResponse) o;

        return commData != null ? commData.equals(that.commData) : that.commData == null;
    }

    @Override
    public int hashCode() {
        return commData != null ? commData.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustCommodityResponse{" +
                "commData=" + commData +
                '}';
    }
}
