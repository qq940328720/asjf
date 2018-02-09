package com.aishang.asjf.facade.service;

import com.aishang.asjf.facade.dto.request.employee.EmployeeBaseRequestDTO;
import com.aishang.asjf.facade.dto.response.employee.EmployeeBaseResponseDTO;
import com.aishang.asjf.facade.dto.response.employee.EmployeeOrderListResponseDTO;
import com.aishang.asjf.facade.service.base.IBaseService;

/**
 * Created by whb on 17-11-17.
 * 业务员端业务接口
 */
public interface IEmpService extends IBaseService<EmployeeBaseRequestDTO, EmployeeBaseResponseDTO, Integer> {

    /**
     * 获取业务员端订单列表
     *
     * @param employeeCode
     * @throws Exception
     */
    EmployeeOrderListResponseDTO getEmpOrderList(String employeeCode) throws Exception;

}
