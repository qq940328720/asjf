package com.aishang.asjf.facade.dto.request.customer;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustSigRequestDTO {

    @ApiModelProperty(value = "订单号")
    @NotNull
    @NotEmpty
    private String orderCode;

    @ApiModelProperty(value = "验证码")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^\\d{4}$")
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustSigRequestDTO that = (CustSigRequestDTO) o;

        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int result = orderCode != null ? orderCode.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
