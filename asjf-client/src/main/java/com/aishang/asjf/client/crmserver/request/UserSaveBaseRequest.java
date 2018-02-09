package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ClientResourceEnum;
import com.aishang.asjf.client.crmserver.enums.UserGenderEnum;
import com.aishang.asjf.client.crmserver.enums.UserIsmarriedeEnum;

public class UserSaveBaseRequest {


    private String zmImaUrl;

    private String fmImaUrl;

    private String scImaUrl;

    private String qrImaUrl;

    private String provinceCode;//省code

    private String cityCode;//市code

    private String districtCode;//区code

    private String nowAddress;//详细住址

    private String userName;//真实姓名

    private String userNationalid;//身份证号码

    private String validdaterange;//身份证有效期 0000-00-00为长期

    private String registerAddress;//户籍详细住址

    private UserGenderEnum userGender;//性别 1，男   2，女

    private UserIsmarriedeEnum userIsmarried;//'婚姻状态 未婚:1 已婚:2 初婚:3 其他',

    private ClientResourceEnum clientResource;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSaveBaseRequest that = (UserSaveBaseRequest) o;

        if (zmImaUrl != null ? !zmImaUrl.equals(that.zmImaUrl) : that.zmImaUrl != null) return false;
        if (fmImaUrl != null ? !fmImaUrl.equals(that.fmImaUrl) : that.fmImaUrl != null) return false;
        if (scImaUrl != null ? !scImaUrl.equals(that.scImaUrl) : that.scImaUrl != null) return false;
        if (qrImaUrl != null ? !qrImaUrl.equals(that.qrImaUrl) : that.qrImaUrl != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        if (nowAddress != null ? !nowAddress.equals(that.nowAddress) : that.nowAddress != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        if (validdaterange != null ? !validdaterange.equals(that.validdaterange) : that.validdaterange != null)
            return false;
        if (registerAddress != null ? !registerAddress.equals(that.registerAddress) : that.registerAddress != null)
            return false;
        if (userGender != that.userGender) return false;
        if (userIsmarried != that.userIsmarried) return false;
        return clientResource == that.clientResource;
    }

    @Override
    public int hashCode() {
        int result = zmImaUrl != null ? zmImaUrl.hashCode() : 0;
        result = 31 * result + (fmImaUrl != null ? fmImaUrl.hashCode() : 0);
        result = 31 * result + (scImaUrl != null ? scImaUrl.hashCode() : 0);
        result = 31 * result + (qrImaUrl != null ? qrImaUrl.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (nowAddress != null ? nowAddress.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (validdaterange != null ? validdaterange.hashCode() : 0);
        result = 31 * result + (registerAddress != null ? registerAddress.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (userIsmarried != null ? userIsmarried.hashCode() : 0);
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        return result;
    }

    public ClientResourceEnum getClientResource() {
        return clientResource;
    }

    public void setClientResource(ClientResourceEnum clientResource) {
        this.clientResource = clientResource;
    }

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

    @Override
    public String toString() {
        return "UserSaveBaseRequest{" +
                "zmImaUrl='" + zmImaUrl + '\'' +
                ", fmImaUrl='" + fmImaUrl + '\'' +
                ", scImaUrl='" + scImaUrl + '\'' +
                ", qrImaUrl='" + qrImaUrl + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", nowAddress='" + nowAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", validdaterange='" + validdaterange + '\'' +
                ", registerAddress='" + registerAddress + '\'' +
                ", userGender=" + userGender +
                ", userIsmarried=" + userIsmarried +
                '}';
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
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

    public String getValiddaterange() {
        return validdaterange;
    }

    public void setValiddaterange(String validdaterange) {
        this.validdaterange = validdaterange;
    }

    public UserGenderEnum getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGenderEnum userGender) {
        this.userGender = userGender;
    }

    public UserIsmarriedeEnum getUserIsmarried() {
        return userIsmarried;
    }

    public void setUserIsmarried(UserIsmarriedeEnum userIsmarried) {
        this.userIsmarried = userIsmarried;
    }
}
