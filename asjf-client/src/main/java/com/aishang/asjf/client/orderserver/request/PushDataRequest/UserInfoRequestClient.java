package com.aishang.asjf.client.orderserver.request.PushDataRequest;

import java.math.BigDecimal;

/**
 * @Author 李通
 * @Data 17-12-15 上午10:57
 */
//推送数据--客户信息请求对象
public class UserInfoRequestClient {

    private String phone;//用户手机号码

    private String name;//用户姓名

    private String idCardNo;//身份证号码

    private String idCardTerm;//身份证有效期

    private int isMarried;//婚姻状态

    private int education;//学历：1研究生 2大学本科和专科 3中专或中技 4技术学校 5高中 6初中 7小学及以下

    private String homeAddress;//住址

    private String provinceCode;//省code

    private String cityCode;//市code

    private String districtCode;//区code

    private BigDecimal income;//收入

    private int customerType;//客户类型：1老客户 2店员 3运营商客户

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getIdCardTerm() {
        return idCardTerm;
    }

    public void setIdCardTerm(String idCardTerm) {
        this.idCardTerm = idCardTerm;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(int isMarried) {
        this.isMarried = isMarried;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
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

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoRequestClient that = (UserInfoRequestClient) o;

        if (isMarried != that.isMarried) return false;
        if (education != that.education) return false;
        if (customerType != that.customerType) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idCardNo != null ? !idCardNo.equals(that.idCardNo) : that.idCardNo != null) return false;
        if (idCardTerm != null ? !idCardTerm.equals(that.idCardTerm) : that.idCardTerm != null) return false;
        if (homeAddress != null ? !homeAddress.equals(that.homeAddress) : that.homeAddress != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        return income != null ? income.equals(that.income) : that.income == null;
    }

    @Override
    public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idCardNo != null ? idCardNo.hashCode() : 0);
        result = 31 * result + (idCardTerm != null ? idCardTerm.hashCode() : 0);
        result = 31 * result + isMarried;
        result = 31 * result + education;
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        result = 31 * result + customerType;
        return result;
    }

    @Override
    public String toString() {
        return "UserInfoRequestClient{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", idCardTerm='" + idCardTerm + '\'' +
                ", isMarried=" + isMarried +
                ", education=" + education +
                ", homeAddress='" + homeAddress + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", income=" + income +
                ", customerType=" + customerType +
                '}';
    }
}
