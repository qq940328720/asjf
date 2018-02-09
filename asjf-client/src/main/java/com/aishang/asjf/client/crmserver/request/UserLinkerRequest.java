package com.aishang.asjf.client.crmserver.request;

/**
 * Created by mx on 17-11-13.
 */
public class UserLinkerRequest {


    private String userCode;//客户编号

    private String linkerName;//联系人姓名

    private String linkPhone;//电话号码

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLinkerName() {
        return linkerName;
    }

    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLinkerRequest that = (UserLinkerRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (linkerName != null ? !linkerName.equals(that.linkerName) : that.linkerName != null) return false;
        return linkPhone != null ? linkPhone.equals(that.linkPhone) : that.linkPhone == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (linkerName != null ? linkerName.hashCode() : 0);
        result = 31 * result + (linkPhone != null ? linkPhone.hashCode() : 0);
        return result;
    }


}
