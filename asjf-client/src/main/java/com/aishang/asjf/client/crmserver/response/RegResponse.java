package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.util.List;

public class RegResponse extends CilentBaseResponse {

    private UserDetailInfoReponse data;

    private Integer dataCompletion;//资料填写进度

    private List<UserProfileCompleteResponse> userProfileComplete;

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public UserDetailInfoReponse getData() {
        return data;
    }

    public void setData(UserDetailInfoReponse data) {
        this.data = data;
    }

    public Integer getDataCompletion() {
        return dataCompletion;
    }

    public void setDataCompletion(Integer dataCompletion) {
        this.dataCompletion = dataCompletion;
    }

    public List<UserProfileCompleteResponse> getUserProfileComplete() {
        return userProfileComplete;
    }

    public void setUserProfileComplete(List<UserProfileCompleteResponse> userProfileComplete) {
        this.userProfileComplete = userProfileComplete;
    }
}
