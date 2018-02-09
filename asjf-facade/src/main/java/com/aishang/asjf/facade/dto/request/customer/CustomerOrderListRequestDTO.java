package com.aishang.asjf.facade.dto.request.customer;

import com.aishang.asjf.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by whb on 17-11-6.
 */
@ApiModel(description = "订单列表请求实体")
public class CustomerOrderListRequestDTO extends BaseRequestDTO {

    @ApiModelProperty(value = "客户姓名")
    private String userName;

    @ApiModelProperty(value = "客户手机号码")
    private String userPhone;

    @ApiModelProperty(value = "客户身份证号码")
    private String userNationalid;

    @ApiModelProperty(value = "业务员工号")
    private String empNameCode;

    @ApiModelProperty(value = "订单状态")
    private Byte state;//订单状态 1,资料填写中 2,已提交,待信审 3,信审中 4,信审通过,待提货 5,提货完成,待打款 6,还款中 7,已取消 8,已完成

    @ApiModelProperty(value = "订单编码")
    private String orderCode;

    @ApiModelProperty(value = "申请开始时间")
    private Date applyStartTime;

    @ApiModelProperty(value = "申请结束时间")
    private Date applyEndTime;

    @ApiModelProperty(value = "资金通道")
    private Byte moneyResource;

    @ApiModelProperty(value = "订单类型1")
    private String level1Code;

    @ApiModelProperty(value = "订单类型2")
    private String level2Code;

    @ApiModelProperty(value = "订单类型3")
    private String level3Code;

    @ApiModelProperty(value = "所属区域")
    private String orgCode;

    @ApiModelProperty(value = "所属门店")
    private String storeCode;


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

    public String getEmpNameCode() {
        return empNameCode;
    }

    public void setEmpNameCode(String empNameCode) {
        this.empNameCode = empNameCode;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Byte getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(Byte moneyResource) {
        this.moneyResource = moneyResource;
    }

    public String getLevel1Code() {
        return level1Code;
    }

    public void setLevel1Code(String level1Code) {
        this.level1Code = level1Code;
    }

    public String getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code;
    }

    public String getLevel3Code() {
        return level3Code;
    }

    public void setLevel3Code(String level3Code) {
        this.level3Code = level3Code;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
