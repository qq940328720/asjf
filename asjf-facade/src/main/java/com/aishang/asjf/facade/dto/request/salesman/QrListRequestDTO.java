package com.aishang.asjf.facade.dto.request.salesman;

import com.aishang.asjf.facade.dto.request.base.BaseRequestParameters;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by mx on 17-11-25.
 */
@ApiModel(value = "请求实体", description = "二维码列表请求实体")
public class QrListRequestDTO extends BaseRequestParameters {

    @ApiModelProperty(value = "员工编号")
    @NotNull
    @NotEmpty
    private String employeeCode;

    @ApiModelProperty(value = "商品名称")
    private String mallName;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrListRequestDTO that = (QrListRequestDTO) o;

        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        return mallName != null ? mallName.equals(that.mallName) : that.mallName == null;
    }

    @Override
    public int hashCode() {
        int result = employeeCode != null ? employeeCode.hashCode() : 0;
        result = 31 * result + (mallName != null ? mallName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrListRequestDTO{" +
                "employeeCode='" + employeeCode + '\'' +
                ", mallName='" + mallName + '\'' +
                '}';
    }
}
