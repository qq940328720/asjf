package com.aishang.asjf.client.crmserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserBaseReponse implements Serializable {
    
    private String zmImaUrl;

    private String fmImaUrl;

    private String scImaUrl;

    private String qrImaUrl;

    private String pcd;

    private String userName;//姓名

    private String userNationalid ;//身份证号码

    private Date userValiddaterange;//身份证有效期 0000-00-00为长期

    private Object userGender ;//性别 1，男   2，女

    private Object userIsmarried ;//'婚姻状态 未婚:1 已婚:2 初婚:3 其他',

    private String registerAddress ;//户籍详细住址

    private String provinceCode ;//省code

    private String cityCode ;//市code

    private String districtCode ;//区code

    private String nowAddress ;//详细住址

    private boolean locked ;


    public String getZmImaUrl() {
        return zmImaUrl;
    }

    public void setZmImaUrl(String zmImaUrl) {
        this.zmImaUrl = zmImaUrl;
    }

    public String getFmImaUrl() {
        return fmImaUrl;
    }

    public void setFmImaUrl(String fmImaUrl) {
        this.fmImaUrl = fmImaUrl;
    }

    public String getScImaUrl() {
        return scImaUrl;
    }

    public void setScImaUrl(String scImaUrl) {
        this.scImaUrl = scImaUrl;
    }

    public String getQrImaUrl() {
        return qrImaUrl;
    }

    public void setQrImaUrl(String qrImaUrl) {
        this.qrImaUrl = qrImaUrl;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNationalid() {
        return userNationalid;
    }

    public void setUserNationalid(String userNationalid) {
        this.userNationalid = userNationalid;
    }

    public Date getUserValiddaterange() {
        return userValiddaterange;
    }

    public void setUserValiddaterange(Date userValiddaterange) {
        this.userValiddaterange = userValiddaterange;
    }

    public Object getUserGender() {
        return userGender;
    }

    public void setUserGender(Object userGender) {
        this.userGender = userGender;
    }

    public Object getUserIsmarried() {
        return userIsmarried;
    }

    public void setUserIsmarried(Object userIsmarried) {
        this.userIsmarried = userIsmarried;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBaseReponse that = (UserBaseReponse) o;

        if (locked != that.locked) return false;
        if (zmImaUrl != null ? !zmImaUrl.equals(that.zmImaUrl) : that.zmImaUrl != null) return false;
        if (fmImaUrl != null ? !fmImaUrl.equals(that.fmImaUrl) : that.fmImaUrl != null) return false;
        if (scImaUrl != null ? !scImaUrl.equals(that.scImaUrl) : that.scImaUrl != null) return false;
        if (qrImaUrl != null ? !qrImaUrl.equals(that.qrImaUrl) : that.qrImaUrl != null) return false;
        if (pcd != null ? !pcd.equals(that.pcd) : that.pcd != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        if (userValiddaterange != null ? !userValiddaterange.equals(that.userValiddaterange) : that.userValiddaterange != null)
            return false;
        if (userGender != null ? !userGender.equals(that.userGender) : that.userGender != null) return false;
        if (userIsmarried != null ? !userIsmarried.equals(that.userIsmarried) : that.userIsmarried != null)
            return false;
        if (registerAddress != null ? !registerAddress.equals(that.registerAddress) : that.registerAddress != null)
            return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        return nowAddress != null ? nowAddress.equals(that.nowAddress) : that.nowAddress == null;
    }

    @Override
    public int hashCode() {
        int result = zmImaUrl != null ? zmImaUrl.hashCode() : 0;
        result = 31 * result + (fmImaUrl != null ? fmImaUrl.hashCode() : 0);
        result = 31 * result + (scImaUrl != null ? scImaUrl.hashCode() : 0);
        result = 31 * result + (qrImaUrl != null ? qrImaUrl.hashCode() : 0);
        result = 31 * result + (pcd != null ? pcd.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (userValiddaterange != null ? userValiddaterange.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (userIsmarried != null ? userIsmarried.hashCode() : 0);
        result = 31 * result + (registerAddress != null ? registerAddress.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (nowAddress != null ? nowAddress.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserBaseReponse{" +
                "zmImaUrl='" + zmImaUrl + '\'' +
                ", fmImaUrl='" + fmImaUrl + '\'' +
                ", scImaUrl='" + scImaUrl + '\'' +
                ", qrImaUrl='" + qrImaUrl + '\'' +
                ", pcd='" + pcd + '\'' +
                ", userName='" + userName + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", userValiddaterange=" + userValiddaterange +
                ", userGender=" + userGender +
                ", userIsmarried=" + userIsmarried +
                ", registerAddress='" + registerAddress + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", nowAddress='" + nowAddress + '\'' +
                ", locked=" + locked +
                '}';
    }
}
