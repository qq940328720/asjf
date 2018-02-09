package com.aishang.asjf.client.crmserver.request;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * class_name：UserRegisterRequestDTO
 * describe: 小雨点前置模型请求对象
 * user: cpb
 * date：2018-01-10
 */
public class AsPreModelRequest {

    private String preModelUid;

    private String productNo;

    private String name;

    private String nationalId;

    private String phone;

    private String storeId;

    private String businessNo;

    private String orderNo;

    private String homeAddress;

    private String firstContactName;

    private String firstContactPhone;


    @Override
    public String toString() {
        return "AsPreModelRequest{" +
                "preModelUid='" + preModelUid + '\'' +
                ", productNo='" + productNo + '\'' +
                ", name='" + name + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", phone='" + phone + '\'' +
                ", storeId='" + storeId + '\'' +
                ", businessNo='" + businessNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", firstContactName='" + firstContactName + '\'' +
                ", firstContactPhone='" + firstContactPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsPreModelRequest that = (AsPreModelRequest) o;

        if (preModelUid != null ? !preModelUid.equals(that.preModelUid) : that.preModelUid != null) return false;
        if (productNo != null ? !productNo.equals(that.productNo) : that.productNo != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nationalId != null ? !nationalId.equals(that.nationalId) : that.nationalId != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (businessNo != null ? !businessNo.equals(that.businessNo) : that.businessNo != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (homeAddress != null ? !homeAddress.equals(that.homeAddress) : that.homeAddress != null) return false;
        if (firstContactName != null ? !firstContactName.equals(that.firstContactName) : that.firstContactName != null)
            return false;
        return firstContactPhone != null ? firstContactPhone.equals(that.firstContactPhone) : that.firstContactPhone == null;
    }

    @Override
    public int hashCode() {
        int result = preModelUid != null ? preModelUid.hashCode() : 0;
        result = 31 * result + (productNo != null ? productNo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nationalId != null ? nationalId.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (businessNo != null ? businessNo.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (firstContactName != null ? firstContactName.hashCode() : 0);
        result = 31 * result + (firstContactPhone != null ? firstContactPhone.hashCode() : 0);
        return result;
    }

    public String getPreModelUid() {
        return preModelUid;
    }

    public void setPreModelUid(String preModelUid) {
        this.preModelUid = preModelUid;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getFirstContactName() {
        return firstContactName;
    }

    public void setFirstContactName(String firstContactName) {
        this.firstContactName = firstContactName;
    }

    public String getFirstContactPhone() {
        return firstContactPhone;
    }

    public void setFirstContactPhone(String firstContactPhone) {
        this.firstContactPhone = firstContactPhone;
    }

}
