package com.aishang.asjf.client.crmserver.request;

public class ApiResultFactors3BankRequest {

    private String bankCardId;//银行卡号
    private String id;//身份证号
    private String name;//客户姓名
    private String userCode;//客户编号

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiResultFactors3BankRequest that = (ApiResultFactors3BankRequest) o;

        if (bankCardId != null ? !bankCardId.equals(that.bankCardId) : that.bankCardId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return userCode != null ? userCode.equals(that.userCode) : that.userCode == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardId != null ? bankCardId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        return result;
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
