package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.MallNameCodeInfo;

import java.util.List;

/**
 * Created by mx on 17-11-22.
 */
public class ChooseMallResponse extends CilentBaseResponse {

    private List<MallNameCodeInfo> data;

    public List<MallNameCodeInfo> getData() {
        return data;
    }

    public void setData(List<MallNameCodeInfo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChooseMallResponse that = (ChooseMallResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChooseMallResponse{" +
                "data=" + data +
                '}';
    }
}
