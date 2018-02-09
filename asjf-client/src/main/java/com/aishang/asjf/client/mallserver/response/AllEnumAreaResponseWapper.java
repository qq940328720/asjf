package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by whb on 17-12-23.
 */
public class AllEnumAreaResponseWapper implements Serializable {

    private DictionaryResponse area;
    private List<AllEnumResponse> incomeResource;//收入来源
    private List<AllEnumResponse> ismarriede;//婚姻状况
    private List<AllEnumResponse> highesteducation;//学历
    private List<AllEnumResponse> relationship;//联系人关系
    private List<AllEnumResponse> gender; //性别
    private List<AllEnumResponse> ncontactname;//第几联系人
    private List<AllEnumResponse> phones;//电话类型
    private List<AllEnumResponse> imageType;//照片类型
    private List<AllEnumResponse> orderStatus; //订单状态
    private List<AllEnumResponse> sendAuditState;//打款状态
    private List<AllEnumResponse> creditState;//信审状态
    private List<AllEnumResponse> pickupState;//提货照状态
    private List<AllEnumResponse> moneyResource;//资金渠道
    private List<AllEnumResponse> firstLinkerRelation;

    public List<AllEnumResponse> getFirstLinkerRelation() {
        return firstLinkerRelation;
    }

    public void setFirstLinkerRelation(List<AllEnumResponse> firstLinkerRelation) {
        this.firstLinkerRelation = firstLinkerRelation;
    }

    public List<AllEnumResponse> getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(List<AllEnumResponse> moneyResource) {
        this.moneyResource = moneyResource;
    }

    public DictionaryResponse getArea() {
        return area;
    }

    public void setArea(DictionaryResponse area) {
        this.area = area;
    }

    public List<AllEnumResponse> getIncomeResource() {
        return incomeResource;
    }

    public void setIncomeResource(List<AllEnumResponse> incomeResource) {
        this.incomeResource = incomeResource;
    }

    public List<AllEnumResponse> getIsmarriede() {
        return ismarriede;
    }

    public void setIsmarriede(List<AllEnumResponse> ismarriede) {
        this.ismarriede = ismarriede;
    }

    public List<AllEnumResponse> getHighesteducation() {
        return highesteducation;
    }

    public void setHighesteducation(List<AllEnumResponse> highesteducation) {
        this.highesteducation = highesteducation;
    }

    public List<AllEnumResponse> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<AllEnumResponse> relationship) {
        this.relationship = relationship;
    }

    public List<AllEnumResponse> getGender() {
        return gender;
    }

    public void setGender(List<AllEnumResponse> gender) {
        this.gender = gender;
    }

    public List<AllEnumResponse> getNcontactname() {
        return ncontactname;
    }

    public void setNcontactname(List<AllEnumResponse> ncontactname) {
        this.ncontactname = ncontactname;
    }

    public List<AllEnumResponse> getPhones() {
        return phones;
    }

    public void setPhones(List<AllEnumResponse> phones) {
        this.phones = phones;
    }

    public List<AllEnumResponse> getImageType() {
        return imageType;
    }

    public void setImageType(List<AllEnumResponse> imageType) {
        this.imageType = imageType;
    }

    public List<AllEnumResponse> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<AllEnumResponse> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<AllEnumResponse> getSendAuditState() {
        return sendAuditState;
    }

    public void setSendAuditState(List<AllEnumResponse> sendAuditState) {
        this.sendAuditState = sendAuditState;
    }

    public List<AllEnumResponse> getCreditState() {
        return creditState;
    }

    public void setCreditState(List<AllEnumResponse> creditState) {
        this.creditState = creditState;
    }

    public List<AllEnumResponse> getPickupState() {
        return pickupState;
    }

    public void setPickupState(List<AllEnumResponse> pickupState) {
        this.pickupState = pickupState;
    }

    @Override
    public String toString() {
        return "AllEnumAreaResponseWapper{" +
                "area=" + area +
                ", incomeResource=" + incomeResource +
                ", ismarriede=" + ismarriede +
                ", highesteducation=" + highesteducation +
                ", relationship=" + relationship +
                ", gender=" + gender +
                ", ncontactname=" + ncontactname +
                ", phones=" + phones +
                ", imageType=" + imageType +
                ", orderStatus=" + orderStatus +
                ", sendAuditState=" + sendAuditState +
                ", creditState=" + creditState +
                ", pickupState=" + pickupState +
                ", moneyResource=" + moneyResource +
                ", firstLinkerRelation=" + firstLinkerRelation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllEnumAreaResponseWapper that = (AllEnumAreaResponseWapper) o;

        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (incomeResource != null ? !incomeResource.equals(that.incomeResource) : that.incomeResource != null)
            return false;
        if (ismarriede != null ? !ismarriede.equals(that.ismarriede) : that.ismarriede != null) return false;
        if (highesteducation != null ? !highesteducation.equals(that.highesteducation) : that.highesteducation != null)
            return false;
        if (relationship != null ? !relationship.equals(that.relationship) : that.relationship != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (ncontactname != null ? !ncontactname.equals(that.ncontactname) : that.ncontactname != null) return false;
        if (phones != null ? !phones.equals(that.phones) : that.phones != null) return false;
        if (imageType != null ? !imageType.equals(that.imageType) : that.imageType != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (sendAuditState != null ? !sendAuditState.equals(that.sendAuditState) : that.sendAuditState != null)
            return false;
        if (creditState != null ? !creditState.equals(that.creditState) : that.creditState != null) return false;
        if (pickupState != null ? !pickupState.equals(that.pickupState) : that.pickupState != null) return false;
        if (moneyResource != null ? !moneyResource.equals(that.moneyResource) : that.moneyResource != null)
            return false;
        return firstLinkerRelation != null ? firstLinkerRelation.equals(that.firstLinkerRelation) : that.firstLinkerRelation == null;
    }

    @Override
    public int hashCode() {
        int result = area != null ? area.hashCode() : 0;
        result = 31 * result + (incomeResource != null ? incomeResource.hashCode() : 0);
        result = 31 * result + (ismarriede != null ? ismarriede.hashCode() : 0);
        result = 31 * result + (highesteducation != null ? highesteducation.hashCode() : 0);
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (ncontactname != null ? ncontactname.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (sendAuditState != null ? sendAuditState.hashCode() : 0);
        result = 31 * result + (creditState != null ? creditState.hashCode() : 0);
        result = 31 * result + (pickupState != null ? pickupState.hashCode() : 0);
        result = 31 * result + (moneyResource != null ? moneyResource.hashCode() : 0);
        result = 31 * result + (firstLinkerRelation != null ? firstLinkerRelation.hashCode() : 0);
        return result;
    }

}
