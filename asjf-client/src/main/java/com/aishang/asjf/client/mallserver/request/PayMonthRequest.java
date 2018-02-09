package com.aishang.asjf.client.mallserver.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-23.
 */
public class PayMonthRequest implements Serializable {

    private String productCode;//产品code

    private BigDecimal loanMoney;//贷款金额

    private Integer payTime;//支持期数

    private String payTimeUnit;//期数单位

    private String interestType;//计息方式

    private BigDecimal totalRate;//总利率

    private Integer isPrePay;//是否提前提前还款

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public String getPayTimeUnit() {
        return payTimeUnit;
    }

    public void setPayTimeUnit(String payTimeUnit) {
        this.payTimeUnit = payTimeUnit;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        this.totalRate = totalRate;
    }

    public Integer getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(Integer isPrePay) {
        this.isPrePay = isPrePay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayMonthRequest request = (PayMonthRequest) o;

        if (productCode != null ? !productCode.equals(request.productCode) : request.productCode != null) return false;
        if (loanMoney != null ? !loanMoney.equals(request.loanMoney) : request.loanMoney != null) return false;
        if (payTime != null ? !payTime.equals(request.payTime) : request.payTime != null) return false;
        if (payTimeUnit != null ? !payTimeUnit.equals(request.payTimeUnit) : request.payTimeUnit != null) return false;
        if (interestType != null ? !interestType.equals(request.interestType) : request.interestType != null)
            return false;
        if (totalRate != null ? !totalRate.equals(request.totalRate) : request.totalRate != null) return false;
        return isPrePay != null ? isPrePay.equals(request.isPrePay) : request.isPrePay == null;
    }

    @Override
    public int hashCode() {
        int result = productCode != null ? productCode.hashCode() : 0;
        result = 31 * result + (loanMoney != null ? loanMoney.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (payTimeUnit != null ? payTimeUnit.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (totalRate != null ? totalRate.hashCode() : 0);
        result = 31 * result + (isPrePay != null ? isPrePay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PayMonthRequest{" +
                "productCode='" + productCode + '\'' +
                ", loanMoney=" + loanMoney +
                ", payTime=" + payTime +
                ", payTimeUnit='" + payTimeUnit + '\'' +
                ", interestType='" + interestType + '\'' +
                ", totalRate=" + totalRate +
                ", isPrePay=" + isPrePay +
                '}';
    }
}
