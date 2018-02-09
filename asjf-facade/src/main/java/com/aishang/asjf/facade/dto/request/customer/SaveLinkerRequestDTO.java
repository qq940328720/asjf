package com.aishang.asjf.facade.dto.request.customer;


import com.aishang.asjf.client.crmserver.enums.ContactNcontactnameEnum;
import com.aishang.asjf.client.crmserver.enums.RelationshipEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaveLinkerRequestDTO {


    @NotNull
    private ContactNcontactnameEnum no;     //第n联系人

    @NotNull(message = "联系人关系属性不能为空")
    private RelationshipEnum relation;           //联系人关系 1:父母 2:姊妹 3:同事 4夫妻 5其他

    @NotNull(message = "联系人姓名属性不能为空")
    @NotEmpty(message = "联系人姓名不能为空")
    private String linkerName;             //联系人姓名

    @NotNull(message = "联系人手机号码属性不能为空")
    @NotEmpty(message = "联系人手机号码不能为空")
    private String linkPhone;              //联系人手机号

    private String provinceCode;           //住址-省code

    private String cityCode;               //住址-市code

    private String districtCode;           //住址-区code

    private String homeAddress;            //详细住址


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveLinkerRequestDTO that = (SaveLinkerRequestDTO) o;

        if (no != that.no) return false;
        if (relation != that.relation) return false;
        if (linkerName != null ? !linkerName.equals(that.linkerName) : that.linkerName != null) return false;
        if (linkPhone != null ? !linkPhone.equals(that.linkPhone) : that.linkPhone != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
        return homeAddress != null ? homeAddress.equals(that.homeAddress) : that.homeAddress == null;
    }

    @Override
    public int hashCode() {
        int result = no != null ? no.hashCode() : 0;
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        result = 31 * result + (linkerName != null ? linkerName.hashCode() : 0);
        result = 31 * result + (linkPhone != null ? linkPhone.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        return result;
    }

    public ContactNcontactnameEnum getNo() {
        return no;
    }

    public void setNo(ContactNcontactnameEnum no) {
        this.no = no;
    }

    public RelationshipEnum getRelation() {
        return relation;
    }

    public void setRelation(RelationshipEnum relation) {
        this.relation = relation;
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
