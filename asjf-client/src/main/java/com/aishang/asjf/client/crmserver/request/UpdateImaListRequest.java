package com.aishang.asjf.client.crmserver.request;


import java.util.List;

public class UpdateImaListRequest {

    private List<UpdateImaRequest> list;

    @Override
    public String toString() {
        return "UpdateImaListRequest{" +
                "list=" + list +
                '}';
    }

    public List<UpdateImaRequest> getList() {
        return list;
    }

    public void setList(List<UpdateImaRequest> list) {
        this.list = list;
    }
}
