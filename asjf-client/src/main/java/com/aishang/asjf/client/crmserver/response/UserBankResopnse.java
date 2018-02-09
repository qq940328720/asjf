package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class UserBankResopnse extends CilentBaseResponse {
    private List<UserBankInfoResponse> listData;

    private UserDetailInfoReponse data;

    public UserDetailInfoReponse getData() {
        return data;
    }

    public void setData(UserDetailInfoReponse data) {
        this.data = data;
    }

    public List<UserBankInfoResponse> getListData() {
        return listData;
    }

    public void setListData(List<UserBankInfoResponse> listData) {
        this.listData = listData;
    }
}
