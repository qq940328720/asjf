package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.math.BigDecimal;

/**
 * Created by mx on 17-11-23.
 */
public class PayMonthResponse extends CilentBaseResponse {

    private BigDecimal monthPay;

    public BigDecimal getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(BigDecimal monthPay) {
        if (null == monthPay) {
            monthPay = new BigDecimal(0);
        }
        this.monthPay = monthPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayMonthResponse that = (PayMonthResponse) o;

        return monthPay != null ? monthPay.equals(that.monthPay) : that.monthPay == null;
    }

    @Override
    public int hashCode() {
        return monthPay != null ? monthPay.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PayMonthResponse{" +
                "monthPay=" + monthPay +
                '}';
    }
}
