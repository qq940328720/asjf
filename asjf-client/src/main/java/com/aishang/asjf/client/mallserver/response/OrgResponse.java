package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.OrgInfo;

import java.util.List;

/**
 * Created by mx on 17-12-6.
 */
public class OrgResponse extends CilentBaseResponse {
    private List<OrgInfo> data;

    public List<OrgInfo> getData() {
        return data;
    }

    public void setData(List<OrgInfo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgResponse that = (OrgResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrgResponse{" +
                "data=" + data +
                '}';
    }
}
