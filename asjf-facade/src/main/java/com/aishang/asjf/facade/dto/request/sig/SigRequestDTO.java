package com.aishang.asjf.facade.dto.request.sig;

import com.aishang.asjf.common.utils.ConstantClassFunction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@ApiModel(value = "请求实体", description = "确认签约")
public class SigRequestDTO{

    @ApiModelProperty(value = "订单编号")
    @NotNull
    @NotEmpty
    private String orderCode;

    @ApiModelProperty(value = "验证码")
    @NotNull
    @NotEmpty
    @Pattern(regexp = ConstantClassFunction.VERIFICATION_CODE)
    private String verifiCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SigRequestDTO that = (SigRequestDTO) o;

        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        return verifiCode != null ? verifiCode.equals(that.verifiCode) : that.verifiCode == null;
    }

    @Override
    public int hashCode() {
        int result = orderCode != null ? orderCode.hashCode() : 0;
        result = 31 * result + (verifiCode != null ? verifiCode.hashCode() : 0);
        return result;
    }

    public String getVerifiCode() {
        return verifiCode;
    }

    public void setVerifiCode(String verifiCode) {
        this.verifiCode = verifiCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
