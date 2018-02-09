package com.aishang.asjf.adapter.impl;


import com.aishang.asjf.client.crmserver.CrmServerClient;
import com.aishang.asjf.common.UniqueCodeGenerator;
import com.aishang.asjf.common.enums.UserType;
import com.aishang.asjf.common.redis.ASJFCacheConfig;
import com.aishang.asjf.dal.mapper.CustomerMapper;
import com.aishang.asjf.dal.model.Customer;
import com.aishang.asjf.dal.model.CustomerExample;
import com.aishang.asjf.facade.dto.info.CustOrderListInfoDTO;
import com.aishang.asjf.facade.dto.request.base.BaseRequestParameters;
import com.aishang.asjf.facade.dto.request.customer.CustomerBaseRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.CustomerPasswordModifyRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.CustomerRegRequestDTO;
import com.aishang.asjf.facade.dto.request.customer.CustomerSearchParametersBase;
import com.aishang.asjf.facade.dto.response.customer.CustmerOrderListResponseDTO;
import com.aishang.asjf.facade.dto.response.customer.CustomerBaseResponseDTO;
import com.aishang.asjf.facade.dto.response.customer.CustomerDetailsResponseDTO;
import com.aishang.asjf.facade.dto.response.customer.CustomerListResponseDTO;
import com.aishang.asjf.facade.service.ICustService;
import com.aishang.asjf.facade.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by neeke on 17-9-5.
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustServiceImpl extends BaseServiceImpl<CustomerBaseRequestDTO, CustomerBaseResponseDTO, Integer> implements ICustService {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CrmServerClient crmServerClient;

    @Override
    public List<? extends CustomerBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {

        if (null == baseRequestParameters) {
            return null;
        }
        CustomerExample customerExample = new CustomerExample();
        CustomerSearchParametersBase userSearchParameters = (CustomerSearchParametersBase) baseRequestParameters;
        customerExample.setOffset(userSearchParameters.getOffset());
        customerExample.setLimit(userSearchParameters.getLimit());
//        userExample.createCriteria().andAccountNonLockedIsNull();

        List<Customer> customers = customerMapper.selectByExample(customerExample);
        List<CustomerListResponseDTO> customerListResponseDTOs = new ArrayList<>();
        CustomerListResponseDTO customerListResponseDTO = null;
        for (Customer customer : customers) {
            customerListResponseDTO = new CustomerListResponseDTO();
            customerListResponseDTO.setId(customer.getId());
            customerListResponseDTO.setUsername(customer.getUsername());
            customerListResponseDTO.setAccountNonExpired(customer.getAccountNonExpired());
            customerListResponseDTO.setAccountNonLocked(customer.getAccountNonLocked());
            customerListResponseDTO.setCredentialsNonExpired(customer.getCredentialsNonExpired());
            customerListResponseDTO.setEnabled(customer.getEnabled());
            customerListResponseDTO.setCode(customer.getCustCode());
            customerListResponseDTOs.add(customerListResponseDTO);
        }
        return customerListResponseDTOs;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        return customerMapper.countByExample(customerExample);
    }


    @Override
    public void deleteById(List<Integer> idList) throws Exception {

    }


    @Override
    public CustomerBaseResponseDTO selectById(Integer id) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria()
                .andIdEqualTo(id);
        Customer customer = customerMapper.selectByExample(customerExample).get(0);
//        return new UserDetailsResponseDTO(customer.getId(), customer.getUserName(), customer.getUserPassword(), customer.getUserAccount());
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Integer id) throws Exception {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Integer... id) throws Exception {

    }

    @Override
    @Transactional(readOnly = false)
    public CustomerBaseResponseDTO create(CustomerBaseRequestDTO customerBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public CustomerBaseResponseDTO update(CustomerBaseRequestDTO customerBaseRequestDTO) throws Exception {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andMobilePhoneEqualTo(s);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if (null == customers || customers.size() == 0) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        Customer customer = customers.get(0);

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority(UserType.CUSTOMER.name()));
                return authorityList;
            }

            @Override
            public String getPassword() {
                return customer.getPassword();
            }

            @Override
            public String getUsername() {
                return customer.getCustCode();
            }

            @Override
            public boolean isAccountNonExpired() {
                return customer.getAccountNonExpired();
            }

            @Override
            public boolean isAccountNonLocked() {
                return customer.getAccountNonLocked();
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return customer.getCredentialsNonExpired();
            }

            @Override
            public boolean isEnabled() {
                return customer.getEnabled();
            }
        };
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void reg(CustomerRegRequestDTO customerRegRequestDTO) throws Exception {
        Customer customer = new Customer();
        long cTime = System.currentTimeMillis();
        String code = UniqueCodeGenerator.generateCustCode();
        customer.setAccountNonExpired(true);
        customer.setAccountNonLocked(true);
        customer.setCreatedAt(cTime);
        customer.setCredentialsNonExpired(true);
        customer.setCustCode(code);
        customer.setUsername(code);
        customer.setEnabled(true);
        customer.setMobilePhone(customerRegRequestDTO.getPhone());
        customer.setPassword(passwordEncoder.encode(customerRegRequestDTO.getPassword2()));
        customer.setUpdatedAt(cTime);
        customerMapper.insert(customer);
        if (!crmServerClient.reg(customerRegRequestDTO.getPhone(), code)) {
            throw new Exception("注册失败");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void modifyPassword(CustomerPasswordModifyRequestDTO customerPasswordModifyRequestDTO) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andMobilePhoneEqualTo(customerPasswordModifyRequestDTO.getPhone());
        Customer customer = new Customer();
        customer.setPassword(passwordEncoder.encode(customerPasswordModifyRequestDTO.getPassword1()));
        customerMapper.updateByExampleSelective(customer, customerExample);
    }

    /**
     * 获取客户端订单列表
     *
     * @param userCode
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = false)
    public CustmerOrderListResponseDTO getCustOrderList(String userCode) throws Exception {
        CustmerOrderListResponseDTO custmerOrderListResponseDTO = new CustmerOrderListResponseDTO();
        CustOrderListInfoDTO orderListInfoDTO = new CustOrderListInfoDTO();
        List<CustOrderListInfoDTO> list = new ArrayList<>();
        /*orderListInfoDTO.setOrderCode("114780");
        orderListInfoDTO.setFirstPayMoney(BigDecimal.valueOf(1000.00));
        orderListInfoDTO.setMonthMoney(BigDecimal.valueOf(355.55));
        orderListInfoDTO.setPayTime(12);
        orderListInfoDTO.setState(OrderStatusEnum.LETTER_BY);
        orderListInfoDTO.setMallName("黑色 128G ipone7");
        orderListInfoDTO.setMallPrice(BigDecimal.valueOf(6000.55));
        String data = "2016-12-05 09:29:23";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        Date newDate = sdf.parse(data);
        orderListInfoDTO.setSendMoneyTime(newDate);
        list.add(orderListInfoDTO);
        CustOrderListInfoDTO orderListInfoDT = new CustOrderListInfoDTO();
        orderListInfoDT.setOrderCode("114781");
        orderListInfoDT.setFirstPayMoney(BigDecimal.valueOf(1000.00));
        orderListInfoDT.setMonthMoney(BigDecimal.valueOf(355.55));
        orderListInfoDT.setPayTime(6);
        orderListInfoDT.setState(OrderStatusEnum.LETTER_BY);
        orderListInfoDT.setMallName("黑色 128G 荣耀10");
        orderListInfoDT.setMallPrice(BigDecimal.valueOf(6000.55));
        String dat = "2016-12-25 09:19:23";
        Date newDat = sdf.parse(dat);
        orderListInfoDT.setSendMoneyTime(newDat);*/
        /*list.add(orderListInfoDT);
        custmerOrderListResponseDTO.setOrderListInfoList(list);*/
        return custmerOrderListResponseDTO;
    }

    @Override
//    @Cacheable(value = ASJFCacheConfig.CACHE_CUSTOMERS, key = "#phone")
    public CustomerDetailsResponseDTO findByPhone(String phone) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andMobilePhoneEqualTo(phone);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        CustomerDetailsResponseDTO customerDetailsResponseDTO = null;
        if (null != customers && customers.size() > 0) {
            Customer customer = customers.get(0);
            customerDetailsResponseDTO = new CustomerDetailsResponseDTO(customer.getCustCode(),
                    customer.getMobilePhone(), customer.getUsername(), customer.getAccountNonExpired(),
                    customer.getAccountNonLocked(), customer.getCredentialsNonExpired(), customer.getEnabled(),
                    customer.getCreatedAt(), customer.getUpdatedAt());
        }
        return customerDetailsResponseDTO;
    }

    @Override
    public CustomerDetailsResponseDTO findByCustCode(String custCode) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustCodeEqualTo(custCode);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        CustomerDetailsResponseDTO customerDetailsResponseDTO = null;
        if (null != customers && customers.size() > 0) {
            Customer customer = customers.get(0);
            customerDetailsResponseDTO = new CustomerDetailsResponseDTO(customer.getCustCode(),
                    customer.getMobilePhone(), customer.getUsername(), customer.getAccountNonExpired(),
                    customer.getAccountNonLocked(), customer.getCredentialsNonExpired(), customer.getEnabled(),
                    customer.getCreatedAt(), customer.getUpdatedAt());
        }
        return customerDetailsResponseDTO;
    }
}
