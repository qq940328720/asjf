package com.aishang.asjf.client.crmserver.request;

public class ApiResultFactors4BankRequest {

    private String bankCardId;//银行卡号
    private String id;//身份证号
    private String name;//客户姓名
    private String orderCode;//客户编号
    private String phoneNumber;//客户姓名
    private String userCode;//客户编号

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiResultFactors4BankRequest that = (ApiResultFactors4BankRequest) o;

        if (bankCardId != null ? !bankCardId.equals(that.bankCardId) : that.bankCardId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        return userCode != null ? userCode.equals(that.userCode) : that.userCode == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardId != null ? bankCardId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        return result;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(String bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    @Override
    public String toString() {
        return "ApiResultFactors3BankRequest{" +
                "bankCardId='" + bankCardId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
