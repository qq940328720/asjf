package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class UserBankInfoResponse implements Serializable {
    private String userCode;//客户编号
    private String bankCardnumber;//银行卡号
    private String bankId;//银行 id
    private String bankPlace;//银行所在地
    private String bankCardImgUrl;//银行卡照片
    private String bankPhone;//预留手机号
    private String bizid;//业务id
    private Object enabled;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBankInfoResponse that = (UserBankInfoResponse) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (bankCardnumber != null ? !bankCardnumber.equals(that.bankCardnumber) : that.bankCardnumber != null)
            return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (bankPlace != null ? !bankPlace.equals(that.bankPlace) : that.bankPlace != null) return false;
        if (bankCardImgUrl != null ? !bankCardImgUrl.equals(that.bankCardImgUrl) : that.bankCardImgUrl != null)
            return false;
        if (bankPhone != null ? !bankPhone.equals(that.bankPhone) : that.bankPhone != null) return false;
        if (bizid != null ? !bizid.equals(that.bizid) : that.bizid != null) return false;
        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (bankCardnumber != null ? bankCardnumber.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + (bankPlace != null ? bankPlace.hashCode() : 0);
        result = 31 * result + (bankCardImgUrl != null ? bankCardImgUrl.hashCode() : 0);
        result = 31 * result + (bankPhone != null ? bankPhone.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserBankInfoResponse{" +
                "userCode='" + userCode + '\'' +
                ", bankCardnumber='" + bankCardnumber + '\'' +
                ", bankId='" + bankId + '\'' +
                ", bankPlace='" + bankPlace + '\'' +
                ", bankCardImgUrl='" + bankCardImgUrl + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", bizid='" + bizid + '\'' +
                ", enabled=" + enabled +
                '}';
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

    public String getBankPlace() {
        return bankPlace;
    }

    public void setBankPlace(String bankPlace) {
        this.bankPlace = bankPlace;
    }

    public String getBankCardImgUrl() {
        return bankCardImgUrl;
    }

    public void setBankCardImgUrl(String bankCardImgUrl) {
        this.bankCardImgUrl = bankCardImgUrl;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }
}
