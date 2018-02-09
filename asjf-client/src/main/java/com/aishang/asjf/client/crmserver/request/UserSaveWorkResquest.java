package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.UserHighesteducationEnum;
import com.aishang.asjf.client.crmserver.enums.UserIncomeResourceEnum;

import java.math.BigDecimal;

/**
 * @Author whb
 * @Data 17-12-07 上午9:30
 */
public class UserSaveWorkResquest {

    private String wAddressDetail;//单位地址-单位详细地址

    private String wAddressCompanyName;//单位地址-单位名称

    private String wAddressMobile;//联系方式-手机

    private String profession;//职业

    private String workPosition ;//职位

    private UserIncomeResourceEnum userIncomeResource;//收入来源

    private UserHighesteducationEnum userHighesteducation;//最高学历

    private BigDecimal userIncome;//月收入

    public String getwAddressDetail() {
        return wAddressDetail;
    }

    public void setwAddressDetail(String wAddressDetail) {
        this.wAddressDetail = wAddressDetail;
    }

    public String getwAddressCompanyName() {
        return wAddressCompanyName;
    }

    public void setwAddressCompanyName(String wAddressCompanyName) {
        this.wAddressCompanyName = wAddressCompanyName;
    }

    public String getwAddressMobile() {
        return wAddressMobile;
    }

    public void setwAddressMobile(String wAddressMobile) {
        this.wAddressMobile = wAddressMobile;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public UserIncomeResourceEnum getUserIncomeResource() {
        return userIncomeResource;
    }

    public void setUserIncomeResource(UserIncomeResourceEnum userIncomeResource) {
        this.userIncomeResource = userIncomeResource;
    }

    public UserHighesteducationEnum getUserHighesteducation() {
        return userHighesteducation;
    }

    public void setUserHighesteducation(UserHighesteducationEnum userHighesteducation) {
        this.userHighesteducation = userHighesteducation;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSaveWorkResquest that = (UserSaveWorkResquest) o;

        if (wAddressDetail != null ? !wAddressDetail.equals(that.wAddressDetail) : that.wAddressDetail != null)
            return false;
        if (wAddressCompanyName != null ? !wAddressCompanyName.equals(that.wAddressCompanyName) : that.wAddressCompanyName != null)
            return false;
        if (wAddressMobile != null ? !wAddressMobile.equals(that.wAddressMobile) : that.wAddressMobile != null)
            return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (workPosition != null ? !workPosition.equals(that.workPosition) : that.workPosition != null) return false;
        if (userIncomeResource != that.userIncomeResource) return false;
        if (userHighesteducation != that.userHighesteducation) return false;
        return userIncome != null ? userIncome.equals(that.userIncome) : that.userIncome == null;
    }

    @Override
    public int hashCode() {
        int result = wAddressDetail != null ? wAddressDetail.hashCode() : 0;
        result = 31 * result + (wAddressCompanyName != null ? wAddressCompanyName.hashCode() : 0);
        result = 31 * result + (wAddressMobile != null ? wAddressMobile.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (workPosition != null ? workPosition.hashCode() : 0);
        result = 31 * result + (userIncomeResource != null ? userIncomeResource.hashCode() : 0);
        result = 31 * result + (userHighesteducation != null ? userHighesteducation.hashCode() : 0);
        result = 31 * result + (userIncome != null ? userIncome.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserSaveWorkResquest{" +
                "wAddressDetail='" + wAddressDetail + '\'' +
                ", wAddressCompanyName='" + wAddressCompanyName + '\'' +
                ", wAddressMobile='" + wAddressMobile + '\'' +
                ", profession='" + profession + '\'' +
                ", workPosition='" + workPosition + '\'' +
                ", userIncomeResource=" + userIncomeResource +
                ", userHighesteducation=" + userHighesteducation +
                ", userIncome=" + userIncome +
                '}';
    }
}
