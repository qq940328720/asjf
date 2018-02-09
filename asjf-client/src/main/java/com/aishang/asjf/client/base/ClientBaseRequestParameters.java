package com.aishang.asjf.client.base;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by mx on 2017-11-22.
 */
public class ClientBaseRequestParameters implements Serializable {


    private Integer limit = 20;//当前页数

    private Integer offset = 0;//起始页

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBaseRequestParameters that = (ClientBaseRequestParameters) o;
        return Objects.equals(limit, that.limit) &&
                Objects.equals(offset, that.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "RequestParameters{" +
                "limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
