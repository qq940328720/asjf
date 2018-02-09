package com.aishang.asjf.client.crmserver.request;


import java.util.List;

public class AddPickupImgRequest {

    List<AddPickupImgInfoRequest> request;

    String stringCode;


    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    public List<AddPickupImgInfoRequest> getRequest() {
        return request;
    }

    public void setRequest(List<AddPickupImgInfoRequest> request) {
        this.request = request;
    }

}
