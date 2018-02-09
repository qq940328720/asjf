package com.aishang.asjf.client.orderserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Created by whb on 18-01-18.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class AppPayPlanInfoResponse implements Serializable {

        private String payTime;//还款期数

        private Object state;//还款状态 1,成功 2,失败 3,处理中 0,待还款

        private BigDecimal curShPayMoney;  //本期应还

        private BigDecimal actualPayMoney;//实际还款金额

        private Long expectedRepayDate;//预计还款日期

        private Long realRepayTime;//实际还款时间

        private Integer overduefineDay;//违约天数

        private BigDecimal overduefineAmount;//逾期金额

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
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

    public BigDecimal getCurShPayMoney() {
        return curShPayMoney;
    }

    public void setCurShPayMoney(BigDecimal curShPayMoney) {
        this.curShPayMoney = curShPayMoney;
    }

    public BigDecimal getActualPayMoney() {
        return actualPayMoney;
    }

    public void setActualPayMoney(BigDecimal actualPayMoney) {
        this.actualPayMoney = actualPayMoney;
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
}
