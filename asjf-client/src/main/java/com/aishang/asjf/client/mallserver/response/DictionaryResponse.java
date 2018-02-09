package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.DictionaryProvice;

import java.util.List;

/**
 * Created by mx on 17-12-7.
 */
public class DictionaryResponse extends CilentBaseResponse {

    private Object datas;

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryResponse that = (DictionaryResponse) o;

        return datas != null ? datas.equals(that.datas) : that.datas == null;
    }

    @Override
    public int hashCode() {
        return datas != null ? datas.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DictionaryResponse{" +
                "datas=" + datas +
                '}';
    }
}
