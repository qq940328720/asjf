package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class SignaUrlResponse implements Serializable {


    private String url;

    private String resCode;

    private String resMsg;

    private String type;

    @Override
    public String toString() {
        return "SignaUrlResponse{" +
                "url='" + url + '\'' +
                ", resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
