package com.aishang.asjf.facade.dto.request.customer;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ReceiveWecashAsynRequestDTO {

   @NotEmpty
   @NotNull
   @ApiModelProperty(value = "订单号")
   private String orderCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiveWecashAsynRequestDTO that = (ReceiveWecashAsynRequestDTO) o;

        return orderCode != null ? orderCode.equals(that.orderCode) : that.orderCode == null;
    }

    @Override
    public int hashCode() {
        return orderCode != null ? orderCode.hashCode() : 0;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
