package com.aishang.asjf.client.crmserver.request;


import java.util.List;

public class UserImageMapRequest {

    private List<UpdateImaRequest> list;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImageMapRequest that = (UserImageMapRequest) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    public List<UpdateImaRequest> getList() {
        return list;
    }

    public void setList(List<UpdateImaRequest> list) {
        this.list = list;
    }
}
