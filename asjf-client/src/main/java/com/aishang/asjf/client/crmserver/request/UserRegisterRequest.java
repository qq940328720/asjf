package com.aishang.asjf.client.crmserver.request;

public class UserRegisterRequest {

    private String email;

    private String mobile;

    private String name;

    private String idNo;

    private String personArea;

    private String organ;

    private String title;

    private String address;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPersonArea() {
        return personArea;
    }

    public void setPersonArea(String personArea) {
        this.personArea = personArea;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserRegisterRequestDTO{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", personArea='" + personArea + '\'' +
                ", organ='" + organ + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
