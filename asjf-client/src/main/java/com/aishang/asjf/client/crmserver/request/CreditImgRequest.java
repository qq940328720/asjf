package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ImageTypeEnum;

public class CreditImgRequest {

    private ImageTypeEnum imgType;//照片类型:1.身份证正面照 2.身份证反面照 3.手持身份证照片 4.手持确认书照片

    private String imgUrl;//照片url

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditImgRequest that = (CreditImgRequest) o;

        if (imgType != that.imgType) return false;
        return imgUrl != null ? imgUrl.equals(that.imgUrl) : that.imgUrl == null;
    }

    @Override
    public int hashCode() {
        int result = imgType != null ? imgType.hashCode() : 0;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }

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
}
