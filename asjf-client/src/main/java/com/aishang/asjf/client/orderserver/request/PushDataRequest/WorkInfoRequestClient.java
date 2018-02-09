package com.aishang.asjf.client.orderserver.request.PushDataRequest;

/**
 * @Author 李通
 * @Data 17-12-15 上午11:09
 */
//推送数据--单位信息请求对象
public class WorkInfoRequestClient {
    private String companyName;           // 单位名称

    private String companyPhone;          // 单位电话

    private String position;               // 职位

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkInfoRequestClient that = (WorkInfoRequestClient) o;

        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyPhone != null ? !companyPhone.equals(that.companyPhone) : that.companyPhone != null) return false;
        return position != null ? position.equals(that.position) : that.position == null;
    }

    @Override
    public int hashCode() {
        int result = companyName != null ? companyName.hashCode() : 0;
        result = 31 * result + (companyPhone != null ? companyPhone.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkInfoRequestClient{" +
                "companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
