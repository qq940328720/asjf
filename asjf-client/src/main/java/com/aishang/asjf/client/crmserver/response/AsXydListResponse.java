package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;
import java.util.List;

public class AsXydListResponse implements Serializable {

    private List<AsXydResponse> list;

    @Override
    public String toString() {
        return "AsXydListResponse{" +
                "list=" + list +
                '}';
    }

    public List<AsXydResponse> getList() {
        return list;
    }

    public void setList(List<AsXydResponse> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsXydListResponse that = (AsXydListResponse) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
