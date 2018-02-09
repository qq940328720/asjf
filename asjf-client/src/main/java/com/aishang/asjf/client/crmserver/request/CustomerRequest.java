package com.aishang.asjf.client.crmserver.request;


public class CustomerRequest {


    private String userAccount;

    private String passWord;

    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    @Override
    public String toString() {
        return "CustomerRequestDTO{" +
                "userAccount='" + userAccount + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
