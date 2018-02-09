package com.aishang.asjf.client.crmserver.request;


/**
 * @Author whb
 * @Data 17-11-10 上午9:30
 */
public class SaveWorkInfoRequest {

    private String userCode;

    private String wAddressDetail;//单位地址-单位详细地址

    private String wAddressCompanyName;//单位地址-单位名称

    private String wAddressMobile;//联系方式-手机

    private String workJob;//职业

    private String workPost ;//职位

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveWorkInfoRequest that = (SaveWorkInfoRequest) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (wAddressDetail != null ? !wAddressDetail.equals(that.wAddressDetail) : that.wAddressDetail != null)
            return false;
        if (wAddressCompanyName != null ? !wAddressCompanyName.equals(that.wAddressCompanyName) : that.wAddressCompanyName != null)
            return false;
        if (wAddressMobile != null ? !wAddressMobile.equals(that.wAddressMobile) : that.wAddressMobile != null)
            return false;
        if (workJob != null ? !workJob.equals(that.workJob) : that.workJob != null) return false;
        return workPost != null ? workPost.equals(that.workPost) : that.workPost == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (wAddressDetail != null ? wAddressDetail.hashCode() : 0);
        result = 31 * result + (wAddressCompanyName != null ? wAddressCompanyName.hashCode() : 0);
        result = 31 * result + (wAddressMobile != null ? wAddressMobile.hashCode() : 0);
        result = 31 * result + (workJob != null ? workJob.hashCode() : 0);
        result = 31 * result + (workPost != null ? workPost.hashCode() : 0);
        return result;
    }

}
