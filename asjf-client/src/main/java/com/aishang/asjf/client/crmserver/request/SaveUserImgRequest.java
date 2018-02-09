package com.aishang.asjf.client.crmserver.request;

import java.util.List;


public class SaveUserImgRequest {

    List<UserImgRequest> data;


    @Override
    public String toString() {
        return "SaveUserImgRequest{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveUserImgRequest that = (SaveUserImgRequest) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public List<UserImgRequest> getData() {
        return data;
    }

    public void setData(List<UserImgRequest> data) {
        this.data = data;
    }
}
