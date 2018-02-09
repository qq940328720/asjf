package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class UserNipResponse implements Serializable {

    private String userName;//姓名

    private String userPhone;//手机号码

    private String userNationalid;//身份证号码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNationalid() {
        return userNationalid;
    }

    public void setUserNationalid(String userNationalid) {
        this.userNationalid = userNationalid;
    }
}
