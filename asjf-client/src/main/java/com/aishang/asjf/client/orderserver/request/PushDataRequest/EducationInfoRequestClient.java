package com.aishang.asjf.client.orderserver.request.PushDataRequest;

public class EducationInfoRequestClient {
    private String city;              // 所在地区

    private String certificate_no;    // 证书号

    private String degree;            // 学位类型

    private String major;             // 专业

    private String school;            // 所在学校

    private String registration_date; // 入学时间

    private String graduate_date;     // 毕业时间

    private String department;        // 部门

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCertificate_no() {
        return certificate_no;
    }

    public void setCertificate_no(String certificate_no) {
        this.certificate_no = certificate_no;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getGraduate_date() {
        return graduate_date;
    }

    public void setGraduate_date(String graduate_date) {
        this.graduate_date = graduate_date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
