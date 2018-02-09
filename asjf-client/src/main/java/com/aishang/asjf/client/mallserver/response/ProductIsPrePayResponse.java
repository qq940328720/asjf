package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by mx on 18-1-2.
 */
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class ProductIsPrePayResponse extends CilentBaseResponse {

    private Integer isPrePay;
    private Integer prePayValue;

    public Integer getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(Integer isPrePay) {
        this.isPrePay = isPrePay;
    }

    public Integer getPrePayValue() {
        return prePayValue;
    }

    public void setPrePayValue(Integer prePayValue) {
        this.prePayValue = prePayValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductIsPrePayResponse that = (ProductIsPrePayResponse) o;

        if (isPrePay != null ? !isPrePay.equals(that.isPrePay) : that.isPrePay != null) return false;
        return prePayValue != null ? prePayValue.equals(that.prePayValue) : that.prePayValue == null;
    }

    @Override
    public int hashCode() {
        int result = isPrePay != null ? isPrePay.hashCode() : 0;
        result = 31 * result + (prePayValue != null ? prePayValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductIsPrePayResponse{" +
                "isPrePay=" + isPrePay +
                ", prePayValue=" + prePayValue +
                '}';
    }
}
