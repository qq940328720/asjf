package com.aishang.asjf.facade.dto.info;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by whb on 17-12-11.
 */
public class RejectImgInfo {

    @ApiModelProperty(value = "照片类型: 字典编码 1.身份证正面照 2.身份证反面照 3.手持身份证照片 4.征信照片 5.其他照片 ")
    private String imgTypeCode;

    @ApiModelProperty(value = "同类型图片编号 ")
    private Integer imgTypeno;

    @ApiModelProperty(value = "照片URL")
    private String imgUrl;

    public String getImgTypeCode() {
        return imgTypeCode;
    }

    public void setImgTypeCode(String imgTypeCode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RejectImgInfo that = (RejectImgInfo) o;

        if (imgTypeCode != null ? !imgTypeCode.equals(that.imgTypeCode) : that.imgTypeCode != null) return false;
        if (imgTypeno != null ? !imgTypeno.equals(that.imgTypeno) : that.imgTypeno != null) return false;
        return imgUrl != null ? imgUrl.equals(that.imgUrl) : that.imgUrl == null;
    }

    @Override
    public int hashCode() {
        int result = imgTypeCode != null ? imgTypeCode.hashCode() : 0;
        result = 31 * result + (imgTypeno != null ? imgTypeno.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RejectImgInfo{" +
                "imgTypeCode='" + imgTypeCode + '\'' +
                ", imgTypeno=" + imgTypeno +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

