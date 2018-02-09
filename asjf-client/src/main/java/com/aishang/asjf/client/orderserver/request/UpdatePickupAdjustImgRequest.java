package com.aishang.asjf.client.orderserver.request;


import java.util.List;

public class UpdatePickupAdjustImgRequest {

    List<PickupAdjustImgInfoRequest> recieveData;

    String stringCode;

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    public List<PickupAdjustImgInfoRequest> getRecieveData() {
        return recieveData;
    }

    public void setRecieveData(List<PickupAdjustImgInfoRequest> recieveData) {
        this.recieveData = recieveData;
    }
}
