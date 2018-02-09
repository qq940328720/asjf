package com.aishang.asjf.facade.dto.info;

import io.swagger.annotations.ApiModel;

/**
 * @Author whb
 * @Data 17-11-6 下午5:39
 * 业务员端订单列表
 */
@ApiModel(description = "业务员端订单实体信息")
public class EmployeeOrderListInfoDTO {
   /* @ApiModelProperty(value = "区域", required = false)
    private String orgName;//订单编码

    @ApiModelProperty(value = "门店名", required = false)
    private String storeName;//门店名

    @ApiModelProperty(value = "商品名称", required = false)
    private String mallName;

    @ApiModelProperty(value = "贷款金额", required = false)
    private BigDecimal loanMoney;//贷款金额

    @ApiModelProperty(value = "客户姓名", required = false)
    private String userName;//客户名称

    @ApiModelProperty(value = "手机号码", required = false)
    private String userPhone;//手机号码

    @ApiModelProperty(value = "身份证号码", required = false)
    private String userNationalid;//身份证号码

    @ApiModelProperty(value = "订单状态", required = false)
    private OrderStatusEnum state;//订单状态 1,资料填写中 2,已提交,待信审 3,信审中 4,信审通过,待提货 5,提货完成,待打款 6,还款中 7,已取消 8,已完成

    @ApiModelProperty(value = "创建时间", required = false)
    private Date insertTime;//创建时间

    private String insertTimeStr;

    @Override
    public String toString() {
        return "EmployeeOrderListInfoDTO{" +
                "orgName='" + orgName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", mallName='" + mallName + '\'' +
                ", loanMoney=" + loanMoney +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNationalid='" + userNationalid + '\'' +
                ", state=" + state +
                ", insertTime=" + insertTime +
                ", insertTimeStr='" + insertTimeStr + '\'' +
                '}';
    }

    public String getInsertTimeStr() {
        return insertTimeStr;
    }

    public void setInsertTimeStr(String insertTimeStr) {
        this.insertTimeStr = insertTimeStr;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNationalid() {
        return userNationalid;
    }

    public void setUserNationalid(String userNationalid) {
        this.userNationalid = userNationalid;
    }

    public OrderStatusEnum getState() {
        return state;
    }

    public void setState(OrderStatusEnum state) {
        this.state = state;
    }

    public void setInsertTime(Date insertTime) {
        if (insertTime != null) {
            this.insertTimeStr = Constant.SDF.format(insertTime);
        }
        this.insertTime = insertTime;
    }*/
}
