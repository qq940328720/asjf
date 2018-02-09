package com.aishang.asjf.client.crmserver.request;


import java.math.BigDecimal;

/**
 * @Author whb
 * @Data 17-11-10 上午9:30
 */
public class ClientWorkResquest {


    private String wAddressDetail;//单位地址-单位详细地址

    private String wAddressCompanyName;//单位地址-单位名称

    private String wAddressMobile;//联系方式-手机

    private String workJob;//职业

    private String workPost;//职位

    private Object userHighesteducation;

    private BigDecimal userIncome;//月收入

    public String getwAddressDetail() {
        return wAddressDetail;
    }

    public void setwAddressDetail(String wAddressDetail) {
        this.wAddressDetail = wAddressDetail;
    }

    public String getwAddressCompanyName() {
        return wAddressCompanyName;
    }

    public void setwAddressCompanyName(String wAddressCompanyName) {
        this.wAddressCompanyName = wAddressCompanyName;
    }

    public String getwAddressMobile() {
        return wAddressMobile;
    }

    public void setwAddressMobile(String wAddressMobile) {
        this.wAddressMobile = wAddressMobile;
    }

    public String getWorkJob() {
        return workJob;
    }

    public void setWorkJob(String workJob) {
        this.workJob = workJob;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
    }

    public Object getUserHighesteducation() {
        return userHighesteducation;
    }

    public void setUserHighesteducation(Object userHighesteducation) {
        this.userHighesteducation = userHighesteducation;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }
}
