package com.aishang.asjf.client.mallserver.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-12-4.
 */
public class CustPreOrderRequest implements Serializable {

    private String userCode;//客户编号
    private BigDecimal firstPayMoney;//首付金额
    private Integer payTime;//期数
    private double lng;//经度
    private double lat;//纬度
    private Integer isQuickPayPackage;//是否有提前还款包
    private Integer clientResource;//终端来源

    private String commodityCode;//商品编码
    private String commodityName;//商品名称
    private BigDecimal commodityPrice;//商品价格
    private String empNameCode;//业务员CODE
    private String ipSrc;//源IP
    private BigDecimal loanMoney;//贷款金额（后台计算）

    //
    private String level1Code;//级别1 对应字典表产品类目描述
    private String level2Code;//级别2 对应字典表产品类目描述
    private String level3Code;//级别3 对应字典表产品类目描述

    //
    private String productCode;//产品编码
    private String productName;//产品名
    private Integer interestType;//计息方式 1.等额本息 2.等额本金 3.等本等息
    private Integer payTimeUnit;//期数单位
    private BigDecimal payRate;//利率
    //
    private String merchantCode;//商户编码
    private String merchantName;//商户名
    //
    private String storeCode;//门店编码
    private String storeName;//门店名
    //
    private String orgCode;//门店编码
    private String orgName;//门店名

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Integer getIsQuickPayPackage() {
        return isQuickPayPackage;
    }

    public void setIsQuickPayPackage(Integer isQuickPayPackage) {
        this.isQuickPayPackage = isQuickPayPackage;
    }

    public Integer getClientResource() {
        return clientResource;
    }

    public void setClientResource(Integer clientResource) {
        this.clientResource = clientResource;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getEmpNameCode() {
        return empNameCode;
    }

    public void setEmpNameCode(String empNameCode) {
        this.empNameCode = empNameCode;
    }

    public String getIpSrc() {
        return ipSrc;
    }

    public void setIpSrc(String ipSrc) {
        this.ipSrc = ipSrc;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
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

    public Integer getInterestType() {
        return interestType;
    }

    public void setInterestType(Integer interestType) {
        this.interestType = interestType;
    }

    public Integer getPayTimeUnit() {
        return payTimeUnit;
    }

    public void setPayTimeUnit(Integer payTimeUnit) {
        this.payTimeUnit = payTimeUnit;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustPreOrderRequest that = (CustPreOrderRequest) o;

        if (Double.compare(that.lng, lng) != 0) return false;
        if (Double.compare(that.lat, lat) != 0) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (firstPayMoney != null ? !firstPayMoney.equals(that.firstPayMoney) : that.firstPayMoney != null)
            return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (isQuickPayPackage != null ? !isQuickPayPackage.equals(that.isQuickPayPackage) : that.isQuickPayPackage != null)
            return false;
        if (clientResource != null ? !clientResource.equals(that.clientResource) : that.clientResource != null)
            return false;
        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (commodityPrice != null ? !commodityPrice.equals(that.commodityPrice) : that.commodityPrice != null)
            return false;
        if (empNameCode != null ? !empNameCode.equals(that.empNameCode) : that.empNameCode != null) return false;
        if (ipSrc != null ? !ipSrc.equals(that.ipSrc) : that.ipSrc != null) return false;
        if (loanMoney != null ? !loanMoney.equals(that.loanMoney) : that.loanMoney != null) return false;
        if (level1Code != null ? !level1Code.equals(that.level1Code) : that.level1Code != null) return false;
        if (level2Code != null ? !level2Code.equals(that.level2Code) : that.level2Code != null) return false;
        if (level3Code != null ? !level3Code.equals(that.level3Code) : that.level3Code != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (interestType != null ? !interestType.equals(that.interestType) : that.interestType != null) return false;
        if (payTimeUnit != null ? !payTimeUnit.equals(that.payTimeUnit) : that.payTimeUnit != null) return false;
        if (payRate != null ? !payRate.equals(that.payRate) : that.payRate != null) return false;
        if (merchantCode != null ? !merchantCode.equals(that.merchantCode) : that.merchantCode != null) return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        return orgName != null ? orgName.equals(that.orgName) : that.orgName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (firstPayMoney != null ? firstPayMoney.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isQuickPayPackage != null ? isQuickPayPackage.hashCode() : 0);
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        result = 31 * result + (commodityCode != null ? commodityCode.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (commodityPrice != null ? commodityPrice.hashCode() : 0);
        result = 31 * result + (empNameCode != null ? empNameCode.hashCode() : 0);
        result = 31 * result + (ipSrc != null ? ipSrc.hashCode() : 0);
        result = 31 * result + (loanMoney != null ? loanMoney.hashCode() : 0);
        result = 31 * result + (level1Code != null ? level1Code.hashCode() : 0);
        result = 31 * result + (level2Code != null ? level2Code.hashCode() : 0);
        result = 31 * result + (level3Code != null ? level3Code.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (payTimeUnit != null ? payTimeUnit.hashCode() : 0);
        result = 31 * result + (payRate != null ? payRate.hashCode() : 0);
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustPreOrderRequest{" +
                "userCode='" + userCode + '\'' +
                ", firstPayMoney=" + firstPayMoney +
                ", payTime=" + payTime +
                ", lng=" + lng +
                ", lat=" + lat +
                ", isQuickPayPackage=" + isQuickPayPackage +
                ", clientResource=" + clientResource +
                ", commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", empNameCode='" + empNameCode + '\'' +
                ", ipSrc='" + ipSrc + '\'' +
                ", loanMoney=" + loanMoney +
                ", level1Code='" + level1Code + '\'' +
                ", level2Code='" + level2Code + '\'' +
                ", level3Code='" + level3Code + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", interestType=" + interestType +
                ", payTimeUnit=" + payTimeUnit +
                ", payRate=" + payRate +
                ", merchantCode='" + merchantCode + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
