package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;

/**
 * Created by mx on 17-11-24.
 */
public class ProductInfoResponse implements Serializable {

    private Integer payTime;

    private PaytimeUnitEnum paytimeUnit;

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        if (null == payTime) {
            payTime = 0;
        }
        this.payTime = payTime;
    }

    public PaytimeUnitEnum getPaytimeUnit() {
        return paytimeUnit;
    }

    public void setPaytimeUnit(PaytimeUnitEnum paytimeUnit) {
        this.paytimeUnit = paytimeUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfoResponse that = (ProductInfoResponse) o;

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
        return "ProductInfoResponse{" +
                "payTime=" + payTime +
                ", paytimeUnit=" + paytimeUnit +
                '}';
    }
}
