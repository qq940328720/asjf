package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.MerchantNatureEnum;
import com.aishang.asjf.client.mallserver.response.info.MerchantStatusEnum;

/**
 * Created by mx on 17-12-4.
 */
public class MerchantInfoResponse extends CilentBaseResponse {

    private String merchantCode;//商户编码

    private String parentOrgCode;//上级机构编码

    private String adminCode;//对应 rule-manager.administrator.code

    private String merchantName;//商户名称

    private MerchantStatusEnum auditState;//审核状态 1,正常 2,待审核 3,已关闭 4,已驳回 5.已拒绝

    private String merchantFullName;//商户全称

    private String provinceCode;//所属省编码

    private String cityCode;//所属市编码

    private String districtCode;//所属区编码

    private String detailedAddress;//详细地址

    private String lon;//经度

    private String lat;//纬度

    private MerchantNatureEnum merchantNature;//商户/门店性质：1个人 2，单位 3，自然人 4，虚拟商户/门店

    private String managerName;//负责人姓名

    private String managerPhone;//负责人手机号

    private String managerIdcert;//负责人身份证

    private Byte deleted;//是否删除 1y  0n

    private String bizid;//业务id

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public MerchantStatusEnum getAuditState() {
        return auditState;
    }

    public void setAuditState(MerchantStatusEnum auditState) {
        this.auditState = auditState;
    }

    public String getMerchantFullName() {
        return merchantFullName;
    }

    public void setMerchantFullName(String merchantFullName) {
        this.merchantFullName = merchantFullName;
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

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public MerchantNatureEnum getMerchantNature() {
        return merchantNature;
    }

    public void setMerchantNature(MerchantNatureEnum merchantNature) {
        this.merchantNature = merchantNature;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerIdcert() {
        return managerIdcert;
    }

    public void setManagerIdcert(String managerIdcert) {
        this.managerIdcert = managerIdcert;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantInfoResponse that = (MerchantInfoResponse) o;

        if (merchantCode != null ? !merchantCode.equals(that.merchantCode) : that.merchantCode != null) return false;
        if (parentOrgCode != null ? !parentOrgCode.equals(that.parentOrgCode) : that.parentOrgCode != null)
            return false;
        if (adminCode != null ? !adminCode.equals(that.adminCode) : that.adminCode != null) return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (auditState != null ? !auditState.equals(that.auditState) : that.auditState != null) return false;
        if (merchantFullName != null ? !merchantFullName.equals(that.merchantFullName) : that.merchantFullName != null)
            return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        if (detailedAddress != null ? !detailedAddress.equals(that.detailedAddress) : that.detailedAddress != null)
            return false;
        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (merchantNature != null ? !merchantNature.equals(that.merchantNature) : that.merchantNature != null)
            return false;
        if (managerName != null ? !managerName.equals(that.managerName) : that.managerName != null) return false;
        if (managerPhone != null ? !managerPhone.equals(that.managerPhone) : that.managerPhone != null) return false;
        if (managerIdcert != null ? !managerIdcert.equals(that.managerIdcert) : that.managerIdcert != null)
            return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        return bizid != null ? bizid.equals(that.bizid) : that.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = merchantCode != null ? merchantCode.hashCode() : 0;
        result = 31 * result + (parentOrgCode != null ? parentOrgCode.hashCode() : 0);
        result = 31 * result + (adminCode != null ? adminCode.hashCode() : 0);
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (auditState != null ? auditState.hashCode() : 0);
        result = 31 * result + (merchantFullName != null ? merchantFullName.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (detailedAddress != null ? detailedAddress.hashCode() : 0);
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (merchantNature != null ? merchantNature.hashCode() : 0);
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (managerPhone != null ? managerPhone.hashCode() : 0);
        result = 31 * result + (managerIdcert != null ? managerIdcert.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MerchantInfoResponse{" +
                "merchantCode='" + merchantCode + '\'' +
                ", parentOrgCode='" + parentOrgCode + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", auditState=" + auditState +
                ", merchantFullName='" + merchantFullName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", merchantNature=" + merchantNature +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerIdcert='" + managerIdcert + '\'' +
                ", deleted=" + deleted +
                ", bizid='" + bizid + '\'' +
                '}';
    }
}
