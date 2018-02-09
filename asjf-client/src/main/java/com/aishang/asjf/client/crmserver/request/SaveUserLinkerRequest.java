package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.ContactNcontactnameEnum;
import com.aishang.asjf.client.crmserver.enums.RelationshipEnum;

public class SaveUserLinkerRequest {

    private String userCode;                //客户编号

    private ContactNcontactnameEnum contactNcontactname;     //第n联系人

    private RelationshipEnum linkRelation;           //联系人关系 1:父母 2:姊妹 3:同事 4夫妻 5其他

    private String linkerName;             //联系人姓名

    private String linkPhone;              //联系人手机号

    private String provinceCode;           //住址-省code

    private String cityCode;               //住址-市code

    private String districtCode;           //住址-区code

    private String homeAddress;            //详细住址

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public ContactNcontactnameEnum getContactNcontactname() {
        return contactNcontactname;
    }

    public void setContactNcontactname(ContactNcontactnameEnum contactNcontactname) {
        this.contactNcontactname = contactNcontactname;
    }

    public RelationshipEnum getLinkRelation() {
        return linkRelation;
    }

    public void setLinkRelation(RelationshipEnum linkRelation) {
        this.linkRelation = linkRelation;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
