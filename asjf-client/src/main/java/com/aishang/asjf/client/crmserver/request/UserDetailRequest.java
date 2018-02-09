package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ClientResourceEnum;
import com.aishang.asjf.client.crmserver.enums.IsFormalEnum;
import com.aishang.asjf.client.crmserver.enums.UserGenderEnum;
import com.aishang.asjf.client.crmserver.enums.UserIsmarriedeEnum;

import java.util.Date;

public class UserDetailRequest {


    private String userName;//真实姓名

    private String userNationalid;//身份证号码

    private Date userValiddaterange;//身份证有效期 0000-00-00为长期

    private String rangeStr;

    private String userHomeaddress;//户籍详细住址

    private UserGenderEnum userGender;//性别 1，男   2，女

    private UserIsmarriedeEnum userIsmarried;//'婚姻状态 未婚:1 已婚:2 初婚:3 其他',

    private ClientResourceEnum clientResource;

    private IsFormalEnum isFormal;


    public ClientResourceEnum getClientResource() {
        return clientResource;
    }

    public void setClientResource(ClientResourceEnum clientResource) {
        this.clientResource = clientResource;
    }

    public IsFormalEnum getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(IsFormalEnum isFormal) {
        this.isFormal = isFormal;
    }

    public String getRangeStr() {
        return rangeStr;
    }

    public void setRangeStr(String rangeStr) {
        this.rangeStr = rangeStr;
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

    public String getUserHomeaddress() {
        return userHomeaddress;
    }

    public void setUserHomeaddress(String userHomeaddress) {
        this.userHomeaddress = userHomeaddress;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetailRequest that = (UserDetailRequest) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userNationalid != null ? !userNationalid.equals(that.userNationalid) : that.userNationalid != null)
            return false;
        if (userValiddaterange != null ? !userValiddaterange.equals(that.userValiddaterange) : that.userValiddaterange != null)
            return false;
        if (rangeStr != null ? !rangeStr.equals(that.rangeStr) : that.rangeStr != null) return false;
        if (userHomeaddress != null ? !userHomeaddress.equals(that.userHomeaddress) : that.userHomeaddress != null)
            return false;
        if (userGender != that.userGender) return false;
        if (userIsmarried != that.userIsmarried) return false;
        if (clientResource != that.clientResource) return false;
        return isFormal == that.isFormal;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userNationalid != null ? userNationalid.hashCode() : 0);
        result = 31 * result + (userValiddaterange != null ? userValiddaterange.hashCode() : 0);
        result = 31 * result + (rangeStr != null ? rangeStr.hashCode() : 0);
        result = 31 * result + (userHomeaddress != null ? userHomeaddress.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (userIsmarried != null ? userIsmarried.hashCode() : 0);
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        result = 31 * result + (isFormal != null ? isFormal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetailRequest{" +
                ", userName='" + userName + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", userValiddaterange=" + userValiddaterange +
                ", rangeStr='" + rangeStr + '\'' +
                ", userHomeaddress='" + userHomeaddress + '\'' +
                ", userGender=" + userGender +
                ", userIsmarried=" + userIsmarried +
                '}';
    }
}
