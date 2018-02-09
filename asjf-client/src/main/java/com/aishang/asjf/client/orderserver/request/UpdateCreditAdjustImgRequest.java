package com.aishang.asjf.client.orderserver.request;


import java.util.List;

public class UpdateCreditAdjustImgRequest{

    List<CreditAdjustImgInfoRequest> recieveData;

    String stringCode;

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    public List<CreditAdjustImgInfoRequest> getRecieveData() {
        return recieveData;
    }

    public void setRecieveData(List<CreditAdjustImgInfoRequest> recieveData) {
        this.recieveData = recieveData;
    }
}
