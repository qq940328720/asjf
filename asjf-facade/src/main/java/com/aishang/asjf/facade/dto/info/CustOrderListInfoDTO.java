package com.aishang.asjf.facade.dto.info;

import io.swagger.annotations.ApiModel;

/**
 * @Author whb
 * @Data 17-11-6 下午5:39
 * 客户端订单列表
 */
@ApiModel(description = "客户订单列表")
public class CustOrderListInfoDTO {
    /*@ApiModelProperty(value = "订单编码", required = false)
    private String orderCode;//订单编码

    @ApiModelProperty(value = "商品名称", required = false)
    private String mallName;

    @ApiModelProperty(value = "商品总价", required = false)
    private BigDecimal mallPrice;

    @ApiModelProperty(value = "首付金额", required = false)
    private BigDecimal firstPayMoney;//首付金额

    @ApiModelProperty(value = "分期月数", required = false)
    private Integer payTime;//期数

    @ApiModelProperty(value = "每月还款", required = false)
    private BigDecimal monthMoney;//月供

    @ApiModelProperty(value = "订单状态", required = false)
    private OrderStatusEnum state;//订单状态 1,资料填写中 2,已提交,待信审 3,信审中 4,信审通过,待提货 5,提货完成,待打款 6,还款中 7,已取消 8,已完成

    @ApiModelProperty(value = "放款时间", required = false)
    private Date sendMoneyTime;

    private String sendMoneyTimeStr;

    public String getSendMoneyTimeStr() {
        return sendMoneyTimeStr;
    }

    public void setSendMoneyTimeStr(String sendMoneyTimeStr) {
        this.sendMoneyTimeStr = sendMoneyTimeStr;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public BigDecimal getMallPrice() {
        return mallPrice;
    }

    public void setMallPrice(BigDecimal mallPrice) {
        this.mallPrice = mallPrice;
    }

    public BigDecimal getFirstPayMoney() {
        return firstPayMoney;
    }

    public void setFirstPayMoney(BigDecimal firstPayMoney) {
        this.firstPayMoney = firstPayMoney;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(BigDecimal monthMoney) {
        this.monthMoney = monthMoney;
    }

    public OrderStatusEnum getState() {
        return state;
    }

    public void setState(OrderStatusEnum state) {
        this.state = state;
    }

    public void setSendMoneyTime(Date sendMoneyTime) {
        if(sendMoneyTime!=null){
            this.sendMoneyTimeStr= Constant.SDF.format(sendMoneyTime);
        }
        this.sendMoneyTime = sendMoneyTime;
    }*/
}
