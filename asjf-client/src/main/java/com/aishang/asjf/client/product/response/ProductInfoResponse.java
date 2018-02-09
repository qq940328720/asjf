package com.aishang.asjf.client.product.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.product.enums.MoneyResourceResponse;


public class ProductInfoResponse extends CilentBaseResponse {

    private String bizid;
    private String productCode;
    private String productName;
    private String level1Code;
    private String level2Code;
    private String level3Code;
    private MoneyResourceResponse moneyResource;
    private Object state;
    private Object interestType;
    private Object isSupportAssend;
    private Object isEnabledLadder;
    private Object loanType;


    @Override
    public String toString() {
        return "ProductInfoResponse{" +
                "bizid='" + bizid + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", level1Code='" + level1Code + '\'' +
                ", level2Code='" + level2Code + '\'' +
                ", level3Code='" + level3Code + '\'' +
                ", moneyResource=" + moneyResource +
                ", state=" + state +
                ", interestType=" + interestType +
                ", isSupportAssend=" + isSupportAssend +
                ", isEnabledLadder=" + isEnabledLadder +
                ", loanType=" + loanType +
                '}';
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public MoneyResourceResponse getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(MoneyResourceResponse moneyResource) {
        this.moneyResource = moneyResource;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getInterestType() {
        return interestType;
    }

    public void setInterestType(Object interestType) {
        this.interestType = interestType;
    }

    public Object getIsSupportAssend() {
        return isSupportAssend;
    }

    public void setIsSupportAssend(Object isSupportAssend) {
        this.isSupportAssend = isSupportAssend;
    }

    public Object getIsEnabledLadder() {
        return isEnabledLadder;
    }

    public void setIsEnabledLadder(Object isEnabledLadder) {
        this.isEnabledLadder = isEnabledLadder;
    }

    public Object getLoanType() {
        return loanType;
    }

    public void setLoanType(Object loanType) {
        this.loanType = loanType;
    }
}
