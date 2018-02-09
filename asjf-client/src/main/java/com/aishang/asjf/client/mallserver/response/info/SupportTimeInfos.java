package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;

/**
 * Created by mx on 17-11-22.
 */
public class SupportTimeInfos implements Serializable {
    private Integer payTime;
    private PaytimeUnit paytimeUnit;

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        if (null == payTime) {
            payTime = 0;
        }
        this.payTime = payTime;
    }

    public PaytimeUnit getPaytimeUnit() {
        return paytimeUnit;
    }

    public void setPaytimeUnit(PaytimeUnit paytimeUnit) {
        this.paytimeUnit = paytimeUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupportTimeInfos that = (SupportTimeInfos) o;

        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        return paytimeUnit != null ? paytimeUnit.equals(that.paytimeUnit) : that.paytimeUnit == null;
    }

    @Override
    public int hashCode() {
        int result = payTime != null ? payTime.hashCode() : 0;
        result = 31 * result + (paytimeUnit != null ? paytimeUnit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SupportTimeInfos{" +
                "payTime=" + payTime +
                ", paytimeUnit=" + paytimeUnit +
                '}';
    }
}
