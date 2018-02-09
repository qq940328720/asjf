package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.MallInfo;

import java.util.List;

/**
 * Created by mx on 17-11-21.
 */
public class MallResponse extends CilentBaseResponse {

    private List<MallInfo> list;
    private Integer total;

    public List<MallInfo> getList() {
        return list;
    }

    public void setList(List<MallInfo> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallResponse that = (MallResponse) o;

        if (list != null ? !list.equals(that.list) : that.list != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = list != null ? list.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MallResponse{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
