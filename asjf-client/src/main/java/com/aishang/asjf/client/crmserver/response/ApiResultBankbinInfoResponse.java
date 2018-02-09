package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class ApiResultBankbinInfoResponse implements Serializable {

    private String bankbinCallcode;//银行卡bin验证接口调用编码

    private String userCode;//客户编码

    private String verificationBankno;//所验证银行卡号

    private String verificationBank;//所验证银行

    private String bankbinResource;//银行卡bin验证渠道

    private String bankbinResult;//银行卡bin验证结果

    private String resultBankname;//返回_银行名称

    private String resultCardname;//返回_银行卡名称

    private String resultCardtype;//返回_银行卡类型

    private Object resultIsluhn;//返回_是否通过luhn算法

    private Object resultIscreditcard;//返回_是否信用卡 1为借记卡,2为信用卡

    private String callMoney;//调用费用

    public String getBankbinCallcode() {
        return bankbinCallcode;
    }

    public void setBankbinCallcode(String bankbinCallcode) {
        this.bankbinCallcode = bankbinCallcode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getVerificationBankno() {
        return verificationBankno;
    }

    public void setVerificationBankno(String verificationBankno) {
        this.verificationBankno = verificationBankno;
    }

    public String getVerificationBank() {
        return verificationBank;
    }

    public void setVerificationBank(String verificationBank) {
        this.verificationBank = verificationBank;
    }

    public String getBankbinResource() {
        return bankbinResource;
    }

    public void setBankbinResource(String bankbinResource) {
        this.bankbinResource = bankbinResource;
    }

    public String getBankbinResult() {
        return bankbinResult;
    }

    public void setBankbinResult(String bankbinResult) {
        this.bankbinResult = bankbinResult;
    }

    public String getResultBankname() {
        return resultBankname;
    }

    public void setResultBankname(String resultBankname) {
        this.resultBankname = resultBankname;
    }

    public String getResultCardname() {
        return resultCardname;
    }

    public void setResultCardname(String resultCardname) {
        this.resultCardname = resultCardname;
    }

    public String getResultCardtype() {
        return resultCardtype;
    }

    public void setResultCardtype(String resultCardtype) {
        this.resultCardtype = resultCardtype;
    }

    public Object getResultIsluhn() {
        return resultIsluhn;
    }

    public void setResultIsluhn(Object resultIsluhn) {
        this.resultIsluhn = resultIsluhn;
    }

    public Object getResultIscreditcard() {
        return resultIscreditcard;
    }

    public void setResultIscreditcard(Object resultIscreditcard) {
        this.resultIscreditcard = resultIscreditcard;
    }

    public String getCallMoney() {
        return callMoney;
    }

    public void setCallMoney(String callMoney) {
        this.callMoney = callMoney;
    }

    @Override
    public String toString() {
        return "ApiResultBankbinInfoResponse{" +
                "bankbinCallcode='" + bankbinCallcode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", verificationBankno='" + verificationBankno + '\'' +
                ", verificationBank='" + verificationBank + '\'' +
                ", bankbinResource='" + bankbinResource + '\'' +
                ", bankbinResult='" + bankbinResult + '\'' +
                ", resultBankname='" + resultBankname + '\'' +
                ", resultCardname='" + resultCardname + '\'' +
                ", resultCardtype='" + resultCardtype + '\'' +
                ", resultIsluhn=" + resultIsluhn +
                ", resultIscreditcard=" + resultIscreditcard +
                ", callMoney='" + callMoney + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiResultBankbinInfoResponse that = (ApiResultBankbinInfoResponse) o;

        if (bankbinCallcode != null ? !bankbinCallcode.equals(that.bankbinCallcode) : that.bankbinCallcode != null)
            return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (verificationBankno != null ? !verificationBankno.equals(that.verificationBankno) : that.verificationBankno != null)
            return false;
        if (verificationBank != null ? !verificationBank.equals(that.verificationBank) : that.verificationBank != null)
            return false;
        if (bankbinResource != null ? !bankbinResource.equals(that.bankbinResource) : that.bankbinResource != null)
            return false;
        if (bankbinResult != null ? !bankbinResult.equals(that.bankbinResult) : that.bankbinResult != null)
            return false;
        if (resultBankname != null ? !resultBankname.equals(that.resultBankname) : that.resultBankname != null)
            return false;
        if (resultCardname != null ? !resultCardname.equals(that.resultCardname) : that.resultCardname != null)
            return false;
        if (resultCardtype != null ? !resultCardtype.equals(that.resultCardtype) : that.resultCardtype != null)
            return false;
        if (resultIsluhn != null ? !resultIsluhn.equals(that.resultIsluhn) : that.resultIsluhn != null) return false;
        if (resultIscreditcard != null ? !resultIscreditcard.equals(that.resultIscreditcard) : that.resultIscreditcard != null)
            return false;
        return callMoney != null ? callMoney.equals(that.callMoney) : that.callMoney == null;
    }

    @Override
    public int hashCode() {
        int result = bankbinCallcode != null ? bankbinCallcode.hashCode() : 0;
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (verificationBankno != null ? verificationBankno.hashCode() : 0);
        result = 31 * result + (verificationBank != null ? verificationBank.hashCode() : 0);
        result = 31 * result + (bankbinResource != null ? bankbinResource.hashCode() : 0);
        result = 31 * result + (bankbinResult != null ? bankbinResult.hashCode() : 0);
        result = 31 * result + (resultBankname != null ? resultBankname.hashCode() : 0);
        result = 31 * result + (resultCardname != null ? resultCardname.hashCode() : 0);
        result = 31 * result + (resultCardtype != null ? resultCardtype.hashCode() : 0);
        result = 31 * result + (resultIsluhn != null ? resultIsluhn.hashCode() : 0);
        result = 31 * result + (resultIscreditcard != null ? resultIscreditcard.hashCode() : 0);
        result = 31 * result + (callMoney != null ? callMoney.hashCode() : 0);
        return result;
    }
}
