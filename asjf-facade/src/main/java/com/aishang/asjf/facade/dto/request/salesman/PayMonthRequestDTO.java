package com.aishang.asjf.facade.dto.request.salesman;

import com.aishang.asjf.facade.dto.request.salesman.emun.InterestTypeEnum;
import com.aishang.asjf.facade.dto.request.salesman.emun.PaytimeUnitEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-23.
 */
@ApiModel(description = "月付请求实体")
public class PayMonthRequestDTO {

    @ApiModelProperty(value = "产品code")
    @NotNull
    private String productCode;

    @ApiModelProperty(value = "贷款金额")
    @NotNull
    private BigDecimal loanMoney;

    @ApiModelProperty(value = "支持期数")
    @NotNull
    private Integer payTime;

    @ApiModelProperty(value = "期数单位")
    @NotNull
    private PaytimeUnitEnum payTimeUnit;

    @ApiModelProperty(value = "计息方式")
    @NotNull
    private InterestTypeEnum interestType;

    @ApiModelProperty(value = "总利率")
    @NotNull
    private BigDecimal totalRate;

    @ApiModelProperty(value = "是否提前还款(0:否，1:是)")
    private Integer isPrePay;

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

    public PaytimeUnitEnum getPayTimeUnit() {
        return payTimeUnit;
    }

    public void setPayTimeUnit(PaytimeUnitEnum payTimeUnit) {
        this.payTimeUnit = payTimeUnit;
    }

    public InterestTypeEnum getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestTypeEnum interestType) {
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayMonthRequestDTO that = (PayMonthRequestDTO) o;

        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (loanMoney != null ? !loanMoney.equals(that.loanMoney) : that.loanMoney != null) return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (payTimeUnit != that.payTimeUnit) return false;
        if (interestType != that.interestType) return false;
        if (totalRate != null ? !totalRate.equals(that.totalRate) : that.totalRate != null) return false;
        return isPrePay != null ? isPrePay.equals(that.isPrePay) : that.isPrePay == null;
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
        return "PayMonthRequestDTO{" +
                "productCode=" + productCode +
                ", loanMoney=" + loanMoney +
                ", payTime=" + payTime +
                ", payTimeUnit=" + payTimeUnit +
                ", interestType=" + interestType +
                ", totalRate=" + totalRate +
                ", isPrePay=" + isPrePay +
                '}';
    }
}
