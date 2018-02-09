package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class SigDataResponse implements Serializable {


    private Object signdata;

    private Object code;

    private SignaUrlResponse signdatas;

    private SignaUrlResponse datas;

    private Object id;

    private Object modelResult;

    private String message;


    @Override
    public String toString() {
        return "SigDataResponse{" +
                "signdata=" + signdata +
                ", code=" + code +
                ", signdatas=" + signdatas +
                ", id=" + id +
                ", modelResult=" + modelResult +
                ", message='" + message + '\'' +
                '}';
    }


    public SignaUrlResponse getDatas() {
        return datas;
    }

    public void setDatas(SignaUrlResponse datas) {
        this.datas = datas;
    }

    public Object getSigndata() {
        return signdata;
    }

    public void setSigndata(Object signdata) {
        this.signdata = signdata;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public SignaUrlResponse getSigndatas() {
        return signdatas;
    }

    public void setSigndatas(SignaUrlResponse signdatas) {
        this.signdatas = signdatas;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getModelResult() {
        return modelResult;
    }

    public void setModelResult(Object modelResult) {
        this.modelResult = modelResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
