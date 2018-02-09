package com.aishang.asjf.client.crmserver.request;

public class TeleSaveRequest {


    private String displayname;//通讯录中的人名字

    private String phone;//电话号码

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

        TeleSaveRequest that = (TeleSaveRequest) o;

        if (displayname != null ? !displayname.equals(that.displayname) : that.displayname != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = displayname != null ? displayname.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
