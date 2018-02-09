package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

public class YqbRegisResponse extends CilentBaseResponse {

    private YqbResponse data;

    @Override
    public String toString() {
        return "YqbRegisResponse{" +
                "data=" + data +
                '}';
    }

    public YqbResponse getData() {
        return data;
    }

    public void setData(YqbResponse data) {
        this.data = data;
    }
}
