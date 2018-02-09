package com.aishang.asjf.client.crmserver.request;

import java.util.List;

public class SaveUserLinkerListRequest {


    private List<SaveUserLinkerRequest> linkerList;

    public List<SaveUserLinkerRequest> getLinkerList() {
        return linkerList;
    }

    public void setLinkerList(List<SaveUserLinkerRequest> linkerList) {
        this.linkerList = linkerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveUserLinkerListRequest that = (SaveUserLinkerListRequest) o;

        return linkerList != null ? linkerList.equals(that.linkerList) : that.linkerList == null;
    }

    @Override
    public int hashCode() {
        return linkerList != null ? linkerList.hashCode() : 0;
    }


}
