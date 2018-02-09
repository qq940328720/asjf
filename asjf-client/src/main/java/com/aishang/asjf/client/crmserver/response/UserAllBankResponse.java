package com.aishang.asjf.client.crmserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserAllBankResponse implements Serializable {

    private String userCode ;//客户编号

    private String bankCardnumber ;//银行卡号

    private String bankId ;//银行 id

    private String bankName ;//银行名称

    private String bankCardImgUrl ;//银行卡照片

    private String name;

    private String userPhone;//手机号码

    private String userNationalid;//身份证号码

    private boolean locked;

    private String bizid;


    @Override
    public String toString() {
        return "UserAllBankResponse{" +
                "userCode='" + userCode + '\'' +
                ", bankCardnumber='" + bankCardnumber + '\'' +
                ", bankId='" + bankId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCardImgUrl='" + bankCardImgUrl + '\'' +
                ", name='" + name + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", locked=" + locked +
                ", bizid='" + bizid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAllBankResponse that = (UserAllBankResponse) o;

        if (locked != that.locked) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (bankCardnumber != null ? !bankCardnumber.equals(that.bankCardnumber) : that.bankCardnumber != null)
            return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (bankCardImgUrl != null ? !bankCardImgUrl.equals(that.bankCardImgUrl) : that.bankCardImgUrl != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        return bizid != null ? bizid.equals(that.bizid) : that.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (bankCardnumber != null ? bankCardnumber.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (bankCardImgUrl != null ? bankCardImgUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getBankCardnumber() {
        return bankCardnumber;
    }

    public void setBankCardnumber(String bankCardnumber) {
        this.bankCardnumber = bankCardnumber;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardImgUrl() {
        return bankCardImgUrl;
    }

    public void setBankCardImgUrl(String bankCardImgUrl) {
        this.bankCardImgUrl = bankCardImgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

}
