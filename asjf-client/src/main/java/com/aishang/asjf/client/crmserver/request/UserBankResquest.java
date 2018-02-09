package com.aishang.asjf.client.crmserver.request;


/**
 * @Author whb
 * @Data 17-11-22 上午9:30
 */
public class UserBankResquest {

    private String bankCardnumber;//银行卡号

    private String bankCardImgUrl;//银行卡照片

    private String bankPhone;//手机号码

    private String bizid;


    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBankResquest that = (UserBankResquest) o;

        if (bankCardnumber != null ? !bankCardnumber.equals(that.bankCardnumber) : that.bankCardnumber != null)
            return false;
        if (bankCardImgUrl != null ? !bankCardImgUrl.equals(that.bankCardImgUrl) : that.bankCardImgUrl != null)
            return false;
        if (bankPhone != null ? !bankPhone.equals(that.bankPhone) : that.bankPhone != null) return false;
        return bizid != null ? bizid.equals(that.bizid) : that.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardnumber != null ? bankCardnumber.hashCode() : 0;
        result = 31 * result + (bankCardImgUrl != null ? bankCardImgUrl.hashCode() : 0);
        result = 31 * result + (bankPhone != null ? bankPhone.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
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
