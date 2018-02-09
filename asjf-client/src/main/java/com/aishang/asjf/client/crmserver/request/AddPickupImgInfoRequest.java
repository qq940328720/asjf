package com.aishang.asjf.client.crmserver.request;

import com.aishang.asjf.client.orderserver.enums.PickupImageType;

public class AddPickupImgInfoRequest {
    private PickupImageType imgTypeCode;

    private Integer imgTypeno;

    private String imgUrl;

    public PickupImageType getImgTypeCode() {
        return imgTypeCode;
    }

    public void setImgTypeCode(PickupImageType imgTypeCode) {
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
