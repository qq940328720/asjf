package com.aishang.asjf.client.orderserver.response;

import com.aishang.asjf.client.crmserver.response.EnumByteValue;
import com.aishang.asjf.client.orderserver.enums.PayTimeType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by whb on 18-01-18.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserPayBackPlansInfoResponse implements Serializable {


    private PayTimeType payTime;//还款期数

    private Object payState;//还款状态 1,成功 2,失败 3,处理中 0,待还款

    private BigDecimal shouldTotalAmount;  //本期应还

    private BigDecimal realTotalAmount;//实际还款金额

    private Long expectedRepayDate;//预计还款日期

    private Long realRepayTime;//实际还款时间

    private Integer overduefineDay;//违约天数

    private BigDecimal overduefineAmount;//逾期金额

    @Override
    public String toString() {
        return "UserPayBackPlansInfoResponse{" +
                "payTime=" + payTime +
                ", payState=" + payState +
                ", shouldTotalAmount=" + shouldTotalAmount +
                ", realTotalAmount=" + realTotalAmount +
                ", expectedRepayDate=" + expectedRepayDate +
                ", realRepayTime=" + realRepayTime +
                ", overduefineDay=" + overduefineDay +
                ", overduefineAmount=" + overduefineAmount +
                '}';
    }

    public PayTimeType getPayTime() {
        return payTime;
    }

    public void setPayTime(PayTimeType payTime) {
        this.payTime = payTime;
    }

    public Object getPayState() {
        return payState;
    }

    public void setPayState(Object payState) {
        this.payState = payState;
    }

    public BigDecimal getShouldTotalAmount() {
        return shouldTotalAmount;
    }

    public void setShouldTotalAmount(BigDecimal shouldTotalAmount) {
        this.shouldTotalAmount = shouldTotalAmount;
    }

    public BigDecimal getRealTotalAmount() {
        return realTotalAmount;
    }

    public void setRealTotalAmount(BigDecimal realTotalAmount) {
        this.realTotalAmount = realTotalAmount;
    }

    public Long getExpectedRepayDate() {
        return expectedRepayDate;
    }

    public void setExpectedRepayDate(Long expectedRepayDate) {
        this.expectedRepayDate = expectedRepayDate;
    }

    public Long getRealRepayTime() {
        return realRepayTime;
    }

    public void setRealRepayTime(Long realRepayTime) {
        this.realRepayTime = realRepayTime;
    }

    public Integer getOverduefineDay() {
        return overduefineDay;
    }

    public void setOverduefineDay(Integer overduefineDay) {
        this.overduefineDay = overduefineDay;
    }

    public BigDecimal getOverduefineAmount() {
        return overduefineAmount;
    }

    public void setOverduefineAmount(BigDecimal overduefineAmount) {
        this.overduefineAmount = overduefineAmount;
    }

}
