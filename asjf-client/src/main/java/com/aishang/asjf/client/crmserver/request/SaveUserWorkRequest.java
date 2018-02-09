package com.aishang.asjf.client.crmserver.request;

public class SaveUserWorkRequest {

    private String userCode;//客户编号

    private String workProvinceId;//单位地址-省

    private String wCityId;//单位地址-市

    private String wDistrictId;//单位地址-区县

    private String wAddressDetail;//单位地址-单位详细地址

    private String wAddressCompanyName;//单位地址-单位名称

    private String wAddressTelephone;//联系方式-座机

    private String wAddressMobile;//联系方式-手机

    private String workJob;//职业

    private String workPost;//职位

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveUserWorkRequest that = (SaveUserWorkRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (workProvinceId != null ? !workProvinceId.equals(that.workProvinceId) : that.workProvinceId != null)
            return false;
        if (wCityId != null ? !wCityId.equals(that.wCityId) : that.wCityId != null) return false;
        if (wDistrictId != null ? !wDistrictId.equals(that.wDistrictId) : that.wDistrictId != null) return false;
        if (wAddressDetail != null ? !wAddressDetail.equals(that.wAddressDetail) : that.wAddressDetail != null)
            return false;
        if (wAddressCompanyName != null ? !wAddressCompanyName.equals(that.wAddressCompanyName) : that.wAddressCompanyName != null)
            return false;
        if (wAddressTelephone != null ? !wAddressTelephone.equals(that.wAddressTelephone) : that.wAddressTelephone != null)
            return false;
        if (wAddressMobile != null ? !wAddressMobile.equals(that.wAddressMobile) : that.wAddressMobile != null)
            return false;
        if (workJob != null ? !workJob.equals(that.workJob) : that.workJob != null) return false;
        return workPost != null ? workPost.equals(that.workPost) : that.workPost == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (workProvinceId != null ? workProvinceId.hashCode() : 0);
        result = 31 * result + (wCityId != null ? wCityId.hashCode() : 0);
        result = 31 * result + (wDistrictId != null ? wDistrictId.hashCode() : 0);
        result = 31 * result + (wAddressDetail != null ? wAddressDetail.hashCode() : 0);
        result = 31 * result + (wAddressCompanyName != null ? wAddressCompanyName.hashCode() : 0);
        result = 31 * result + (wAddressTelephone != null ? wAddressTelephone.hashCode() : 0);
        result = 31 * result + (wAddressMobile != null ? wAddressMobile.hashCode() : 0);
        result = 31 * result + (workJob != null ? workJob.hashCode() : 0);
        result = 31 * result + (workPost != null ? workPost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SaveUserWorkMapperRequestDTO{" +
                "userCode='" + userCode + '\'' +
                ", workProvinceId='" + workProvinceId + '\'' +
                ", wCityId='" + wCityId + '\'' +
                ", wDistrictId='" + wDistrictId + '\'' +
                ", wAddressDetail='" + wAddressDetail + '\'' +
                ", wAddressCompanyName='" + wAddressCompanyName + '\'' +
                ", wAddressTelephone='" + wAddressTelephone + '\'' +
                ", wAddressMobile='" + wAddressMobile + '\'' +
                ", workJob='" + workJob + '\'' +
                ", workPost='" + workPost + '\'' +
                '}';
    }
}
