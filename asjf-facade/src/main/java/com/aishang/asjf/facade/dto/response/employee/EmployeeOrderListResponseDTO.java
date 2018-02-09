package com.aishang.asjf.facade.dto.response.employee;


import com.aishang.asjf.facade.dto.info.EmployeeOrderListInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 业务员端订单列表
 * Created by whb on 17-11-16.
 */
public class EmployeeOrderListResponseDTO extends EmployeeBaseResponseDTO {

    @ApiModelProperty(value = "总条数")
    private Integer total;

    @ApiModelProperty(value = "业务员端订单列表")
    List<EmployeeOrderListInfoDTO> employeeOrderListInfoDTOList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<EmployeeOrderListInfoDTO> getEmployeeOrderListInfoDTOList() {
        return employeeOrderListInfoDTOList;
    }

    public void setEmployeeOrderListInfoDTOList(List<EmployeeOrderListInfoDTO> employeeOrderListInfoDTOList) {
        this.employeeOrderListInfoDTOList = employeeOrderListInfoDTOList;
    }

    @Override
    public String toString() {
        return "EmployeeOrderListResponseDTO{" +
                "total=" + total +
                ", employeeOrderListInfoDTOList=" + employeeOrderListInfoDTOList +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeOrderListResponseDTO that = (EmployeeOrderListResponseDTO) o;

        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        return employeeOrderListInfoDTOList != null ? employeeOrderListInfoDTOList.equals(that.employeeOrderListInfoDTOList) : that.employeeOrderListInfoDTOList == null;
    }

    @Override
    public int hashCode() {
        int result = total != null ? total.hashCode() : 0;
        result = 31 * result + (employeeOrderListInfoDTOList != null ? employeeOrderListInfoDTOList.hashCode() : 0);
        return result;
    }
}
