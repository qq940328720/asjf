package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

/**
 * 客户现住址信息实体
 * Created by whb on 17-11-10.
 */
public class UserAddressInfoResponse implements Serializable {

    private String code;//客户编号

    private String provinceCode;//省code

    private String cityCode;//市code

    private String districtCode;//区code

    private String homeAddress;//详细住址

    @Override
    public String toString() {
        return "UserAddressInfoResponse{" +
                "code='" + code + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
