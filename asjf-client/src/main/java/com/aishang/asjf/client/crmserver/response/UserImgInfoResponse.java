package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.crmserver.enums.EnumObject;
import com.aishang.asjf.client.crmserver.response.info.EnumImage;

import java.io.Serializable;

/**
 * 图片查询实体
 * Created by whb on 17-11-20.
 */
public class UserImgInfoResponse implements Serializable {

    private String userCode;

    private EnumImage imgType;//照片类型:1.身份证正面照 2.身份证反面照 3.手持身份证照片 4.手持确认书照片

    private String imgUrl;//照片url

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (imgType != null ? imgType.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserImgInfoResponse{" +
                "userCode='" + userCode + '\'' +
                ", imgType=" + imgType +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public EnumImage getImgType() {
        return imgType;
    }

    public void setImgType(EnumImage imgType) {
        this.imgType = imgType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
