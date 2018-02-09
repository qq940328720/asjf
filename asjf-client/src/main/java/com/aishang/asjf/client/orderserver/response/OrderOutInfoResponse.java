package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.crmserver.enums.EnumObject;
import com.aishang.asjf.client.crmserver.response.EnumByteValue;
import com.aishang.asjf.client.crmserver.response.EnumIntValue;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class OrderOutInfoResponse implements Serializable {

    private String orderCode;//订单编码

    private String commodityName;//商品名称

    private BigDecimal commodityPrice;//商品价格

    private BigDecimal firstPayMoney;//首付金额

    private String payTime;    //期数

    private BigDecimal monthMoney;//月供

    private String orderState;

    private EnumObject payTimeUnit;

    Date sendMoneyEndTime;      //打款时间

    private String empNameCode;//业务员编号

    private EnumByteValue state;//订单状态 1,资料填写中 2,已提交,待信审 3,信审中 4,信审通过,待提货 5,提货完成,待打款 6,还款中 7,已取消 8,已完成

    private EnumObject orderAuditState;//信审结果 1,待审核  2,审核通过 3,审核拒绝 ４,审核驳回

    private EnumObject imgAuditState;//提货照审核结果  1,待审核  2,审核通过 3,审核拒绝 ４,审核驳回

    private EnumObject sendAuditState;//打款结果 1,待放款 2,放款通过 3,放款拒绝

    private String authCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public BigDecimal getFirstPayMoney() {
        return firstPayMoney;
    }

    public void setFirstPayMoney(BigDecimal firstPayMoney) {
        this.firstPayMoney = firstPayMoney;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(BigDecimal monthMoney) {
        this.monthMoney = monthMoney;
    }

    public Date getSendMoneyEndTime() {
        return sendMoneyEndTime;
    }

    public void setSendMoneyEndTime(Date sendMoneyEndTime) {
        this.sendMoneyEndTime = sendMoneyEndTime;
    }

    public String getEmpNameCode() {
        return empNameCode;
    }

    public void setEmpNameCode(String empNameCode) {
        this.empNameCode = empNameCode;
    }

    public EnumByteValue getState() {
        return state;
    }

    public void setState(EnumByteValue state) {
        this.state = state;
    }

    public EnumObject getOrderAuditState() {
        return orderAuditState;
    }

    public void setOrderAuditState(EnumObject orderAuditState) {
        this.orderAuditState = orderAuditState;
    }

    public EnumObject getImgAuditState() {
        return imgAuditState;
    }

    public void setImgAuditState(EnumObject imgAuditState) {
        this.imgAuditState = imgAuditState;
    }

    public EnumObject getSendAuditState() {
        return sendAuditState;
    }

    public void setSendAuditState(EnumObject sendAuditState) {
        this.sendAuditState = sendAuditState;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }


    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public EnumObject getPayTimeUnit() {
        return payTimeUnit;
    }

    public void setPayTimeUnit(EnumObject payTimeUnit) {
        this.payTimeUnit = payTimeUnit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderOutInfoResponse that = (OrderOutInfoResponse) o;

        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (commodityPrice != null ? !commodityPrice.equals(that.commodityPrice) : that.commodityPrice != null)
            return false;
        if (firstPayMoney != null ? !firstPayMoney.equals(that.firstPayMoney) : that.firstPayMoney != null)
            return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (monthMoney != null ? !monthMoney.equals(that.monthMoney) : that.monthMoney != null) return false;
        if (orderState != null ? !orderState.equals(that.orderState) : that.orderState != null) return false;
        if (payTimeUnit != null ? !payTimeUnit.equals(that.payTimeUnit) : that.payTimeUnit != null) return false;
        if (sendMoneyEndTime != null ? !sendMoneyEndTime.equals(that.sendMoneyEndTime) : that.sendMoneyEndTime != null)
            return false;
        if (empNameCode != null ? !empNameCode.equals(that.empNameCode) : that.empNameCode != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (orderAuditState != null ? !orderAuditState.equals(that.orderAuditState) : that.orderAuditState != null)
            return false;
        if (imgAuditState != null ? !imgAuditState.equals(that.imgAuditState) : that.imgAuditState != null)
            return false;
        if (sendAuditState != null ? !sendAuditState.equals(that.sendAuditState) : that.sendAuditState != null)
            return false;
        return authCode != null ? authCode.equals(that.authCode) : that.authCode == null;
    }

    @Override
    public int hashCode() {
        int result = orderCode != null ? orderCode.hashCode() : 0;
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (commodityPrice != null ? commodityPrice.hashCode() : 0);
        result = 31 * result + (firstPayMoney != null ? firstPayMoney.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (monthMoney != null ? monthMoney.hashCode() : 0);
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (payTimeUnit != null ? payTimeUnit.hashCode() : 0);
        result = 31 * result + (sendMoneyEndTime != null ? sendMoneyEndTime.hashCode() : 0);
        result = 31 * result + (empNameCode != null ? empNameCode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (orderAuditState != null ? orderAuditState.hashCode() : 0);
        result = 31 * result + (imgAuditState != null ? imgAuditState.hashCode() : 0);
        result = 31 * result + (sendAuditState != null ? sendAuditState.hashCode() : 0);
        result = 31 * result + (authCode != null ? authCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderOutInfoResponse{" +
                "orderCode='" + orderCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", firstPayMoney=" + firstPayMoney +
                ", payTime='" + payTime + '\'' +
                ", monthMoney=" + monthMoney +
                ", orderState='" + orderState + '\'' +
                ", payTimeUnit=" + payTimeUnit +
                ", sendMoneyEndTime=" + sendMoneyEndTime +
                ", empNameCode='" + empNameCode + '\'' +
                ", state=" + state +
                ", orderAuditState=" + orderAuditState +
                ", imgAuditState=" + imgAuditState +
                ", sendAuditState=" + sendAuditState +
                ", authCode='" + authCode + '\'' +
                '}';
    }
}
