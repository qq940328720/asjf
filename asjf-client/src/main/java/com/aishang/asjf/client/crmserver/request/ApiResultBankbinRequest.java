package com.aishang.asjf.client.crmserver.request;

public class ApiResultBankbinRequest {

    private String userCode;//客户编号

    private String verificationBankno;//所验证银行卡号

    private String verificationBank;//所验证银行

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiResultBankbinRequest that = (ApiResultBankbinRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (verificationBankno != null ? !verificationBankno.equals(that.verificationBankno) : that.verificationBankno != null)
            return false;
        return verificationBank != null ? verificationBank.equals(that.verificationBank) : that.verificationBank == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (verificationBankno != null ? verificationBankno.hashCode() : 0);
        result = 31 * result + (verificationBank != null ? verificationBank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ApiResultBankbinRequest{" +
                "userCode='" + userCode + '\'' +
                ", verificationBankno='" + verificationBankno + '\'' +
                ", verificationBank='" + verificationBank + '\'' +
                '}';
    }
}
