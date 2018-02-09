package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.StoresInfo;

import java.util.List;

/**
 * Created by mx on 17-11-25.
 */
public class StoreNameResponse extends CilentBaseResponse {

    private List<StoresInfo> outerDTOS;

    public List<StoresInfo> getOuterDTOS() {
        return outerDTOS;
    }

    public void setOuterDTOS(List<StoresInfo> outerDTOS) {
        this.outerDTOS = outerDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreNameResponse that = (StoreNameResponse) o;

        return outerDTOS != null ? outerDTOS.equals(that.outerDTOS) : that.outerDTOS == null;
    }

    @Override
    public int hashCode() {
        return outerDTOS != null ? outerDTOS.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StoreNameResponse{" +
                "outerDTOS=" + outerDTOS +
                '}';
    }
}
