package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.crmserver.enums.EnumObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserLinkerOutResponse implements Serializable {

    private String no;//第n联系人

    private String relation;//联系人关系 1:父母 2:姊妹 3:同事 4夫妻 5其他

    private String linkerName;//联系人姓名

    private String linkPhone;//联系人手机号

    private String provinceCode;//住址-省code

    private String cityCode;//住址-市code

    private String districtCode;//住址-区code

    private String homeAddress;//详细住址

    private String pcd;


    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    @Override
    public String toString() {
        return "UserLinkerOutResponse{" +
                "no='" + no + '\'' +
                ", relation='" + relation + '\'' +
                ", linkerName='" + linkerName + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", pcd='" + pcd + '\'' +
                '}';
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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
