package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-23.
 */
public class QrCreateLogInfo implements Serializable {

    private String qrCode;

    private String commodityCode;//商品id

    private String commodityName;//商品名称

    private BigDecimal productPrice;//商品价格

    private String storeCode;//门店id

    private String employeeCode;//业务员编码

    private String productCode;//产品编码

    private String insertTime;//创建时间

    private BigDecimal loanAmountMin;

    private BigDecimal loanAmountMax;

    private String isWarning;//是否预警 0,否 1,是 ,

    private String isRecommend;//是否推荐 0,否 1,是 ,

    public String getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(String isWarning) {
        if(null == isWarning){
            isWarning = "0";
        }
        this.isWarning = isWarning;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        if(null == isRecommend){
            isRecommend = "0";
        }
        this.isRecommend = isRecommend;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public BigDecimal getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(BigDecimal loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public BigDecimal getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(BigDecimal loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrCreateLogInfo that = (QrCreateLogInfo) o;

        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (loanAmountMin != null ? !loanAmountMin.equals(that.loanAmountMin) : that.loanAmountMin != null)
            return false;
        if (loanAmountMax != null ? !loanAmountMax.equals(that.loanAmountMax) : that.loanAmountMax != null)
            return false;
        if (isWarning != null ? !isWarning.equals(that.isWarning) : that.isWarning != null) return false;
        return isRecommend != null ? isRecommend.equals(that.isRecommend) : that.isRecommend == null;
    }

    @Override
    public int hashCode() {
        int result = qrCode != null ? qrCode.hashCode() : 0;
        result = 31 * result + (commodityCode != null ? commodityCode.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (employeeCode != null ? employeeCode.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (loanAmountMin != null ? loanAmountMin.hashCode() : 0);
        result = 31 * result + (loanAmountMax != null ? loanAmountMax.hashCode() : 0);
        result = 31 * result + (isWarning != null ? isWarning.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrCreateLogInfo{" +
                "qrCode='" + qrCode + '\'' +
                ", commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", productPrice=" + productPrice +
                ", storeCode='" + storeCode + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", insertTime='" + insertTime + '\'' +
                ", loanAmountMin=" + loanAmountMin +
                ", loanAmountMax=" + loanAmountMax +
                ", isWarning='" + isWarning + '\'' +
                ", isRecommend='" + isRecommend + '\'' +
                '}';
    }
}
