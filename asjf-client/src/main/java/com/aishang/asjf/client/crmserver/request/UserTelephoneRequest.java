package com.aishang.asjf.client.crmserver.request;

public class UserTelephoneRequest {


    private String userCode;//客户编号


    private String address;//地址

    private String displayname;//通讯录中的人名字

    private String phone;//电话号码

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTelephoneRequest that = (UserTelephoneRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (displayname != null ? displayname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }


}
