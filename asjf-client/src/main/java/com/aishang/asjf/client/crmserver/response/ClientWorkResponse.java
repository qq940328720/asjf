package com.aishang.asjf.client.crmserver.response;


import com.aishang.asjf.client.crmserver.enums.EnumObject;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author whb
 * @Data 17-11-10 上午9:30
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class ClientWorkResponse implements Serializable {


    private String wAddressDetail ;//单位地址-单位详细地址

    private String wAddressCompanyName;//单位地址-单位名称

    private String wAddressMobile;//联系方式-手机

    private String profession;//职业

    private String workPosition ;//职位

    private String userHighesteducation ;

    private BigDecimal userIncome;//月收入

    private String userIncomeResource;

    private boolean locked ;

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "ClientWorkResponse{" +
                "wAddressDetail='" + wAddressDetail + '\'' +
                ", wAddressCompanyName='" + wAddressCompanyName + '\'' +
                ", wAddressMobile='" + wAddressMobile + '\'' +
                ", profession='" + profession + '\'' +
                ", workPosition='" + workPosition + '\'' +
                ", userHighesteducation='" + userHighesteducation + '\'' +
                ", userIncome=" + userIncome +
                ", userIncomeResource='" + userIncomeResource + '\'' +
                ", locked=" + locked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientWorkResponse that = (ClientWorkResponse) o;

        if (locked != that.locked) return false;
        if (wAddressDetail != null ? !wAddressDetail.equals(that.wAddressDetail) : that.wAddressDetail != null)
            return false;
        if (wAddressCompanyName != null ? !wAddressCompanyName.equals(that.wAddressCompanyName) : that.wAddressCompanyName != null)
            return false;
        if (wAddressMobile != null ? !wAddressMobile.equals(that.wAddressMobile) : that.wAddressMobile != null)
            return false;
        if (profession != null ? !profession.equals(that.profession) : that.profession != null) return false;
        if (workPosition != null ? !workPosition.equals(that.workPosition) : that.workPosition != null) return false;
        if (userHighesteducation != null ? !userHighesteducation.equals(that.userHighesteducation) : that.userHighesteducation != null)
            return false;
        if (userIncome != null ? !userIncome.equals(that.userIncome) : that.userIncome != null) return false;
        return userIncomeResource != null ? userIncomeResource.equals(that.userIncomeResource) : that.userIncomeResource == null;
    }

    @Override
    public int hashCode() {
        int result = wAddressDetail != null ? wAddressDetail.hashCode() : 0;
        result = 31 * result + (wAddressCompanyName != null ? wAddressCompanyName.hashCode() : 0);
        result = 31 * result + (wAddressMobile != null ? wAddressMobile.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (workPosition != null ? workPosition.hashCode() : 0);
        result = 31 * result + (userHighesteducation != null ? userHighesteducation.hashCode() : 0);
        result = 31 * result + (userIncome != null ? userIncome.hashCode() : 0);
        result = 31 * result + (userIncomeResource != null ? userIncomeResource.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        return result;
    }

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

    public String getUserHighesteducation() {
        return userHighesteducation;
    }

    public void setUserHighesteducation(String userHighesteducation) {
        this.userHighesteducation = userHighesteducation;
    }

    public String getUserIncomeResource() {
        return userIncomeResource;
    }

    public void setUserIncomeResource(String userIncomeResource) {
        this.userIncomeResource = userIncomeResource;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }
}
