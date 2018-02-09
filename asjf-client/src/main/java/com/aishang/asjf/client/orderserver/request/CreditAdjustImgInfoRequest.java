package com.aishang.asjf.client.orderserver.request;


import com.aishang.asjf.client.orderserver.enums.CreditImageType;

public class CreditAdjustImgInfoRequest {

    private CreditImageType imgTypeCode;

    private Integer imgTypeno;

    private String imgUrl;

    public CreditImageType getImgTypeCode() {
        return imgTypeCode;
    }

    public void setImgTypeCode(CreditImageType imgTypeCode) {
        this.imgTypeCode = imgTypeCode;
    }

    public Integer getImgTypeno() {
        return imgTypeno;
    }

    public void setImgTypeno(Integer imgTypeno) {
        this.imgTypeno = imgTypeno;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
