package com.aishang.asjf.adapter.impl;


import com.aishang.asjf.facade.dto.info.EmployeeOrderListInfoDTO;
import com.aishang.asjf.facade.dto.request.base.BaseRequestParameters;
import com.aishang.asjf.facade.dto.request.employee.EmployeeBaseRequestDTO;
import com.aishang.asjf.facade.dto.response.employee.EmployeeBaseResponseDTO;
import com.aishang.asjf.facade.dto.response.employee.EmployeeOrderListResponseDTO;
import com.aishang.asjf.facade.service.IEmpService;
import com.aishang.asjf.facade.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neeke on 17-9-5.
 */
@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeBaseRequestDTO, EmployeeBaseResponseDTO, Integer> implements IEmpService {


    @Override
    public EmployeeOrderListResponseDTO getEmpOrderList(String employeeCode) throws Exception {
        EmployeeOrderListResponseDTO orderListResponseDTO = new EmployeeOrderListResponseDTO();
        EmployeeOrderListInfoDTO orderListInfoDTO = new EmployeeOrderListInfoDTO();
       /* orderListInfoDTO.setOrgName("小寨商圈");
        orderListInfoDTO.setStoreName("小寨李刚大卖场");
        orderListInfoDTO.setMallName("黑色 128G ipone7");
        orderListInfoDTO.setLoanMoney(BigDecimal.valueOf(5888.88));
        orderListInfoDTO.setUserName("买买提");
        orderListInfoDTO.setUserPhone("15099661014");
        orderListInfoDTO.setUserNationalid("610431199509241526");
        orderListInfoDTO.setState(OrderStatusEnum.LETTER_IN);
        String data="2016-12-05 09:29:23";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        Date newDate = sdf.parse(data);
        orderListInfoDTO.setInsertTime(newDate);*/
        List<EmployeeOrderListInfoDTO> list = new ArrayList<>();
        list.add(orderListInfoDTO);
        orderListResponseDTO.setEmployeeOrderListInfoDTOList(list);
        return orderListResponseDTO;
    }

    @Override
    public List<? extends EmployeeBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public EmployeeBaseResponseDTO selectById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public void deleteById(Integer... id) throws Exception {

    }

    @Override
    public void deleteById(List<Integer> idList) throws Exception {

    }

    @Override
    public EmployeeBaseResponseDTO create(EmployeeBaseRequestDTO employeeBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public EmployeeBaseResponseDTO update(EmployeeBaseRequestDTO employeeBaseRequestDTO) throws Exception {
        return null;
    }
}
