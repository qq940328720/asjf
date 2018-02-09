package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

public class UserDetailResponse extends CilentBaseResponse {

    private UserDetailInfoReponse data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailResponse that = (UserDetailResponse) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserDetailResponse{" +
                "data=" + data +
                '}';
    }

    public UserDetailInfoReponse getData() {
        return data;
    }

    public void setData(UserDetailInfoReponse data) {
        this.data = data;
    }
}
