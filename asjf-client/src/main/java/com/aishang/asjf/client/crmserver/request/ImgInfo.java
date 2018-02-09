package com.aishang.asjf.client.crmserver.request;

import com.aishang.asjf.client.orderserver.enums.PickupImageType;

/**
 * Created by whb on 17-12-21.
 */
public class ImgInfo {

    private String imgTypeCode;

    private Integer imgTypeno;

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

        ImgInfo imgInfo = (ImgInfo) o;

        if (imgTypeCode != null ? !imgTypeCode.equals(imgInfo.imgTypeCode) : imgInfo.imgTypeCode != null) return false;
        if (imgTypeno != null ? !imgTypeno.equals(imgInfo.imgTypeno) : imgInfo.imgTypeno != null) return false;
        return imgUrl != null ? imgUrl.equals(imgInfo.imgUrl) : imgInfo.imgUrl == null;
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
        return "ImgInfo{" +
                "imgTypeCode='" + imgTypeCode + '\'' +
                ", imgTypeno=" + imgTypeno +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
