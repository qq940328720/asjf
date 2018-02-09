package com.aishang.asjf.client.crmserver.request;


public class UserBankRequest {

    private String bankCardnumber;//银行卡号

    private String bankCardImgUrl;//银行卡照片

    private String bankPhone;//手机号码

    private String bizid;

    private String orderCode;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBankRequest that = (UserBankRequest) o;

        if (bankCardnumber != null ? !bankCardnumber.equals(that.bankCardnumber) : that.bankCardnumber != null)
            return false;
        if (bankCardImgUrl != null ? !bankCardImgUrl.equals(that.bankCardImgUrl) : that.bankCardImgUrl != null)
            return false;
        if (bankPhone != null ? !bankPhone.equals(that.bankPhone) : that.bankPhone != null) return false;
        if (bizid != null ? !bizid.equals(that.bizid) : that.bizid != null) return false;
        return orderCode != null ? orderCode.equals(that.orderCode) : that.orderCode == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardnumber != null ? bankCardnumber.hashCode() : 0;
        result = 31 * result + (bankCardImgUrl != null ? bankCardImgUrl.hashCode() : 0);
        result = 31 * result + (bankPhone != null ? bankPhone.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        return result;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getBankCardnumber() {
        return bankCardnumber;
    }

    public void setBankCardnumber(String bankCardnumber) {
        this.bankCardnumber = bankCardnumber;
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
}
