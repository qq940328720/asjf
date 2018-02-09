package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ImageTypeEnum;

public class UpdateImaRequest {

    private ImageTypeEnum imgType;//照片类型:1.身份证正面照 2.身份证反面照 3.手持身份证照片 4.手持确认书照片

    private String imgUrl;//照片url

    public ImageTypeEnum getImgType() {
        return imgType;
    }

    public void setImgType(ImageTypeEnum imgType) {
        this.imgType = imgType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "UpdateUserRequestDTO{" +
                "imgType=" + imgType +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
