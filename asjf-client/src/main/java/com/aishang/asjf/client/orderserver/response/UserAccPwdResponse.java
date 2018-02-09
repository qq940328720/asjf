package com.aishang.asjf.client.orderserver.response;

import java.io.Serializable;

public class UserAccPwdResponse implements Serializable {

    private String customerId;

    private String userAccount;

    private String passWord;

    @Override
    public String toString() {
        return "UserAccPwdResponse{" +
                "customerId='" + customerId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
