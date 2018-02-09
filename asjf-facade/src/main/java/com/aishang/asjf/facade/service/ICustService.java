package com.aishang.asjf.facade.service;


import com.aishang.asjf.facade.dto.request.customer.CustomerBaseRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.CustomerPasswordModifyRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.CustomerRegRequestDTO;
import com.aishang.asjf.facade.dto.response.customer.CustmerOrderListResponseDTO;
import com.aishang.asjf.facade.dto.response.customer.CustomerBaseResponseDTO;
import com.aishang.asjf.facade.dto.response.customer.CustomerDetailsResponseDTO;
import com.aishang.asjf.facade.service.base.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by neeke on 17-9-5.
 * 客户业务接口
 */
public interface ICustService extends IBaseService<CustomerBaseRequestDTO, CustomerBaseResponseDTO, Integer>, UserDetailsService {

    /**
     * 注册
     *
     * @param customerRegRequestDTO 注册参数
     * @throws Exception
     */
    void reg(CustomerRegRequestDTO customerRegRequestDTO) throws Exception;

    /**
     * 根据手机号查询客户信息
     *
     * @param phone 手机号码
     * @return
     * @throws Exception
     */
    CustomerDetailsResponseDTO findByPhone(String phone) throws Exception;

    /**
     * 根据客户编号查询客户信息
     * @param custCode 客户编号
     * @return
     * @throws Exception
     */
    CustomerDetailsResponseDTO findByCustCode(String custCode) throws Exception;

    /**
     * 修改密码
     *
     * @param customerPasswordModifyRequestDTO 密码参数
     * @throws Exception
     */
    void modifyPassword(CustomerPasswordModifyRequestDTO customerPasswordModifyRequestDTO) throws Exception;

    /**
     * 根据客户号获取客户端订单列表
     *
     * @param userCode
     * @throws Exception
     */
    CustmerOrderListResponseDTO getCustOrderList(String userCode) throws Exception;
}
