package com.aishang.asjf.client.crmserver.request;

import java.util.List;

public class SaveLinkerListRequest {

    private List<SaveLinkerRequest> linkerList;

    public List<SaveLinkerRequest> getLinkerList() {
        return linkerList;
    }

    public void setLinkerList(List<SaveLinkerRequest> linkerList) {
        this.linkerList = linkerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveLinkerListRequest that = (SaveLinkerListRequest) o;

        return linkerList != null ? linkerList.equals(that.linkerList) : that.linkerList == null;
    }

    @Override
    public int hashCode() {
        return linkerList != null ? linkerList.hashCode() : 0;
    }


}
