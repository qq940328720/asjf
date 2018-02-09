package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.MallInfoResponse;

/**
 * Created by mx on 17-11-23.
 */
public class MallCodeResponse extends CilentBaseResponse {

    private MallInfoResponse commData;

    public MallInfoResponse getCommData() {
        return commData;
    }

    public void setCommData(MallInfoResponse commData) {
        this.commData = commData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallCodeResponse that = (MallCodeResponse) o;

        return commData != null ? commData.equals(that.commData) : that.commData == null;
    }

    @Override
    public int hashCode() {
        return commData != null ? commData.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MallCodeResponse{" +
                "commData=" + commData +
                '}';
    }
}
