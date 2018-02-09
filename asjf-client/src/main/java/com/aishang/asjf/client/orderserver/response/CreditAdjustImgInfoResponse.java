package com.aishang.asjf.client.orderserver.response;

import java.io.Serializable;

public class CreditAdjustImgInfoResponse implements Serializable{

    private Object imgTypeCode;

    private Integer imgTypeno;

    private String imgUrl;

    public Object getImgTypeCode() {
        return imgTypeCode;
    }

    public void setImgTypeCode(Object imgTypeCode) {
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
