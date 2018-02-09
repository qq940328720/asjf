package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class YqbRegisResultResponse implements Serializable {

    private Object errCode;

    private String msg;

    private boolean  errShow;

    private String accountId;

    private Object  fingerprint;

    @Override
    public String toString() {
        return "YqbRegisResultResponse{" +
                "errCode=" + errCode +
                ", msg='" + msg + '\'' +
                ", errShow=" + errShow +
                ", accountId=" + accountId +
                ", fingerprint=" + fingerprint +
                '}';
    }

    public Object getErrCode() {
        return errCode;
    }

    public void setErrCode(Object errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isErrShow() {
        return errShow;
    }

    public void setErrShow(boolean errShow) {
        this.errShow = errShow;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Object getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(Object fingerprint) {
        this.fingerprint = fingerprint;
    }
}
