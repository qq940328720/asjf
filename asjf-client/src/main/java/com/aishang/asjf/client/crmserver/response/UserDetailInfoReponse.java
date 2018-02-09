package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.crmserver.enums.EnumObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserDetailInfoReponse implements Serializable {

    private String userName ;//姓名

    private String userPhone ;//手机号码

    private String userNationalid ;//身份证号码

    @JsonFormat(pattern = "yyyyMMdd")
    private Date userValiddaterange;//身份证有效期 0000-00-00为长期

    private EnumObject userGender;//性别 1，男   2，女

    private EnumObject userIsmarried ;//'婚姻状态 未婚:1 已婚:2 初婚:3 其他',

    private EnumObject userHighesteducation;//学历 1，小学及以下 2，中学 3，大学专科 4，大学本科 5，研究生及以上

    private String userHomeaddress;//户籍详细住址

    private BigDecimal userIncome;//月收入

    private EnumObject userIncomeResource;//收入来源

    private EnumObject isFormal;//是否为正式客户 1,是  2,否

    private EnumObject clientResource;//终端来源 1,android  2,ios

    private String ascriptionPersonCode;//归属人

    private BigDecimal dataCompletion;//资料填写进度

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailInfoReponse that = (UserDetailInfoReponse) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        if (userValiddaterange != null ? !userValiddaterange.equals(that.userValiddaterange) : that.userValiddaterange != null)
            return false;
        if (userGender != null ? !userGender.equals(that.userGender) : that.userGender != null) return false;
        if (userIsmarried != null ? !userIsmarried.equals(that.userIsmarried) : that.userIsmarried != null)
            return false;
        if (userHighesteducation != null ? !userHighesteducation.equals(that.userHighesteducation) : that.userHighesteducation != null)
            return false;
        if (userHomeaddress != null ? !userHomeaddress.equals(that.userHomeaddress) : that.userHomeaddress != null)
            return false;
        if (userIncome != null ? !userIncome.equals(that.userIncome) : that.userIncome != null) return false;
        if (userIncomeResource != null ? !userIncomeResource.equals(that.userIncomeResource) : that.userIncomeResource != null)
            return false;
        if (isFormal != null ? !isFormal.equals(that.isFormal) : that.isFormal != null) return false;
        if (clientResource != null ? !clientResource.equals(that.clientResource) : that.clientResource != null)
            return false;
        if (ascriptionPersonCode != null ? !ascriptionPersonCode.equals(that.ascriptionPersonCode) : that.ascriptionPersonCode != null)
            return false;
        return dataCompletion != null ? dataCompletion.equals(that.dataCompletion) : that.dataCompletion == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (userValiddaterange != null ? userValiddaterange.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (userIsmarried != null ? userIsmarried.hashCode() : 0);
        result = 31 * result + (userHighesteducation != null ? userHighesteducation.hashCode() : 0);
        result = 31 * result + (userHomeaddress != null ? userHomeaddress.hashCode() : 0);
        result = 31 * result + (userIncome != null ? userIncome.hashCode() : 0);
        result = 31 * result + (userIncomeResource != null ? userIncomeResource.hashCode() : 0);
        result = 31 * result + (isFormal != null ? isFormal.hashCode() : 0);
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        result = 31 * result + (ascriptionPersonCode != null ? ascriptionPersonCode.hashCode() : 0);
        result = 31 * result + (dataCompletion != null ? dataCompletion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetailInfoReponse{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", userValiddaterange=" + userValiddaterange +
                ", userGender=" + userGender +
                ", userIsmarried=" + userIsmarried +
                ", userHighesteducation=" + userHighesteducation +
                ", userHomeaddress='" + userHomeaddress + '\'' +
                ", userIncome=" + userIncome +
                ", userIncomeResource=" + userIncomeResource +
                ", isFormal=" + isFormal +
                ", clientResource=" + clientResource +
                ", ascriptionPersonCode='" + ascriptionPersonCode + '\'' +
                ", dataCompletion=" + dataCompletion +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public EnumObject getUserGender() {
        return userGender;
    }

    public void setUserGender(EnumObject userGender) {
        this.userGender = userGender;
    }

    public EnumObject getUserIsmarried() {
        return userIsmarried;
    }

    public void setUserIsmarried(EnumObject userIsmarried) {
        this.userIsmarried = userIsmarried;
    }

    public EnumObject getUserHighesteducation() {
        return userHighesteducation;
    }

    public void setUserHighesteducation(EnumObject userHighesteducation) {
        this.userHighesteducation = userHighesteducation;
    }

    public String getUserHomeaddress() {
        return userHomeaddress;
    }

    public void setUserHomeaddress(String userHomeaddress) {
        this.userHomeaddress = userHomeaddress;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }

    public EnumObject getUserIncomeResource() {
        return userIncomeResource;
    }

    public void setUserIncomeResource(EnumObject userIncomeResource) {
        this.userIncomeResource = userIncomeResource;
    }

    public EnumObject getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(EnumObject isFormal) {
        this.isFormal = isFormal;
    }

    public EnumObject getClientResource() {
        return clientResource;
    }

    public void setClientResource(EnumObject clientResource) {
        this.clientResource = clientResource;
    }

    public String getAscriptionPersonCode() {
        return ascriptionPersonCode;
    }

    public void setAscriptionPersonCode(String ascriptionPersonCode) {
        this.ascriptionPersonCode = ascriptionPersonCode;
    }

    public BigDecimal getDataCompletion() {
        return dataCompletion;
    }

    public void setDataCompletion(BigDecimal dataCompletion) {
        this.dataCompletion = dataCompletion;
    }


}
