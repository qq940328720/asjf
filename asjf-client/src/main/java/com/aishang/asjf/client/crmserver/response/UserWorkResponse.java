package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

/**
 * @Author whb
 * @Data 17-11-10 上午9:30
 */
public class UserWorkResponse extends CilentBaseResponse {

    private UserWorkInfoResponse userWorkData;

    @Override
    public String toString() {
        return "UserWorkResponse{" +
                "userWorkData=" + userWorkData +
                '}';
    }

    public UserWorkInfoResponse getUserWorkData() {
        return userWorkData;
    }

    public void setUserWorkData(UserWorkInfoResponse userWorkData) {
        this.userWorkData = userWorkData;
    }
}
