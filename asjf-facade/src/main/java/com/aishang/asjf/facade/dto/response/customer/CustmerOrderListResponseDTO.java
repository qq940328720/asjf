package com.aishang.asjf.facade.dto.response.customer;


import com.aishang.asjf.facade.dto.info.CustOrderListInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 客户端订单列表
 * Created by whb on 17-11-6.
 */
public class CustmerOrderListResponseDTO {

   /* @ApiModelProperty(value = "总条数")
    private Integer total;*/

    @ApiModelProperty(value = "客户端订单列表")
    List<CustOrderListInfoDTO> orderListInfoList;

    public List<CustOrderListInfoDTO> getOrderListInfoList() {
        return orderListInfoList;
    }

    public void setOrderListInfoList(List<CustOrderListInfoDTO> orderListInfoList) {
        this.orderListInfoList = orderListInfoList;
    }
}
