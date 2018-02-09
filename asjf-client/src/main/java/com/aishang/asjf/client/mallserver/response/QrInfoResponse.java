package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-25.
 */
public class QrInfoResponse implements Serializable {

    private String commodityCode;//商品编码
    private String commodityName;//商品名称
    private BigDecimal commodityPrice;//商品价格

    private String productName;//产品名称
    private String productCode;//产品code
    private Object interestType;
    private BigDecimal totalRate;
    private Object supportTimeInfos;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Object getInterestType() {
        return interestType;
    }

    public void setInterestType(Object interestType) {
        this.interestType = interestType;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        this.totalRate = totalRate;
    }

    public Object getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(Object supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrInfoResponse that = (QrInfoResponse) o;

        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (commodityPrice != null ? !commodityPrice.equals(that.commodityPrice) : that.commodityPrice != null)
            return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (interestType != null ? !interestType.equals(that.interestType) : that.interestType != null) return false;
        if (totalRate != null ? !totalRate.equals(that.totalRate) : that.totalRate != null) return false;
        return supportTimeInfos != null ? supportTimeInfos.equals(that.supportTimeInfos) : that.supportTimeInfos == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (commodityPrice != null ? commodityPrice.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (totalRate != null ? totalRate.hashCode() : 0);
        result = 31 * result + (supportTimeInfos != null ? supportTimeInfos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrInfoResponse{" +
                "commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", interestType=" + interestType +
                ", totalRate=" + totalRate +
                ", supportTimeInfos=" + supportTimeInfos +
                '}';
    }
}
