package com.aishang.asjf.client.apiserver.response;

import java.io.Serializable;
import java.util.Objects;

public class SmsResponse implements Serializable {

    private String time;
    private String msgId;
    private String errorMsg;
    private String code;

    @Override
    public String toString() {
        return "SmsResponse{" +
                "time='" + time + '\'' +
                ", msgId='" + msgId + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsResponse that = (SmsResponse) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(msgId, that.msgId) &&
                Objects.equals(errorMsg, that.errorMsg) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, msgId, errorMsg, code);
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
