package com.aishang.asjf.client.crmserver.request;

import com.aishang.asjf.client.crmserver.enums.PhoneEnum;

public class TelepRequest {

    private String userCode;                //客户编号

    private String address;     //地址

    private String displayname;           //通讯录中的人名字

    private String phone;             //电话号码

    private PhoneEnum phoneType;              //号码类型:1座机 2手机

    private String email;           //邮箱

    private String imaddresses;               //我的地址集合

    private String qqNo;           //qq号码

    private String wechat;            //微信号码

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PhoneEnum getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneEnum phoneType) {
        this.phoneType = phoneType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImaddresses() {
        return imaddresses;
    }

    public void setImaddresses(String imaddresses) {
        this.imaddresses = imaddresses;
    }

    public String getQqNo() {
        return qqNo;
    }

    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelepRequest that = (TelepRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (phoneType != that.phoneType) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (imaddresses != null ? !imaddresses.equals(that.imaddresses) : that.imaddresses != null) return false;
        if (qqNo != null ? !qqNo.equals(that.qqNo) : that.qqNo != null) return false;
        return wechat != null ? wechat.equals(that.wechat) : that.wechat == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (displayname != null ? displayname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (phoneType != null ? phoneType.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (imaddresses != null ? imaddresses.hashCode() : 0);
        result = 31 * result + (qqNo != null ? qqNo.hashCode() : 0);
        result = 31 * result + (wechat != null ? wechat.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "SaveUserTelephonedirectoryRequestDTO{" +
                "userCode='" + userCode + '\'' +
                ", address='" + address + '\'' +
                ", displayname='" + displayname + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneType=" + phoneType +
                ", email='" + email + '\'' +
                ", imaddresses='" + imaddresses + '\'' +
                ", qqNo='" + qqNo + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
