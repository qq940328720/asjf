package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ImageTypeEnum;

public class UserImgRequest {

    private String userCode;

    private ImageTypeEnum imgType;//照片类型:1.身份证正面照 2.身份证反面照 3.手持身份证照片 4.手持确认书照片

    private String imgUrl;//照片url


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImgRequest that = (UserImgRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (imgType != that.imgType) return false;
        return imgUrl != null ? imgUrl.equals(that.imgUrl) : that.imgUrl == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (imgType != null ? imgType.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }
}
