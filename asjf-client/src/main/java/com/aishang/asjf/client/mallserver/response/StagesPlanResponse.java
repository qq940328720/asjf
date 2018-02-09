package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.StagesPlanInfo;

import java.util.List;

/**
 * Created by mx on 17-11-21.
 */
public class StagesPlanResponse extends CilentBaseResponse {

    private List<StagesPlanInfo> resultData;

    public List<StagesPlanInfo> getResultData() {
        return resultData;
    }

    public void setResultData(List<StagesPlanInfo> resultData) {
        this.resultData = resultData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StagesPlanResponse that = (StagesPlanResponse) o;

        return resultData != null ? resultData.equals(that.resultData) : that.resultData == null;
    }

    @Override
    public int hashCode() {
        return resultData != null ? resultData.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StagesPlanResponse{" +
                "resultData=" + resultData +
                '}';
    }
}
