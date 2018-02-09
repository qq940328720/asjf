package com.aishang.asjf.client.mallserver.request;

import java.io.Serializable;

/**
 * Created by mx on 17-11-21.
 */
public class QrRequest implements Serializable {

    private String commodityCode;//商品id

    private String employeeCode;//业务员编号

    private String productCode;//产品编号

    private Number productPrice;//商品价格

    private String storeCode;//门店code

    private Integer isWarning;//是否预警 0,否 1,是 ,

    private Integer isRecommend;//是否推荐 0,否 1,是 ,

    public Integer getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Integer isWarning) {
        this.isWarning = isWarning;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
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

    public Number getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Number productPrice) {
        this.productPrice = productPrice;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrRequest qrRequest = (QrRequest) o;

        if (commodityCode != null ? !commodityCode.equals(qrRequest.commodityCode) : qrRequest.commodityCode != null)
            return false;
        if (employeeCode != null ? !employeeCode.equals(qrRequest.employeeCode) : qrRequest.employeeCode != null)
            return false;
        if (productCode != null ? !productCode.equals(qrRequest.productCode) : qrRequest.productCode != null)
            return false;
        if (productPrice != null ? !productPrice.equals(qrRequest.productPrice) : qrRequest.productPrice != null)
            return false;
        if (storeCode != null ? !storeCode.equals(qrRequest.storeCode) : qrRequest.storeCode != null) return false;
        if (isWarning != null ? !isWarning.equals(qrRequest.isWarning) : qrRequest.isWarning != null) return false;
        return isRecommend != null ? isRecommend.equals(qrRequest.isRecommend) : qrRequest.isRecommend == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (employeeCode != null ? employeeCode.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (isWarning != null ? isWarning.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrRequest{" +
                "commodityCode='" + commodityCode + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", storeCode='" + storeCode + '\'' +
                ", isWarning=" + isWarning +
                ", isRecommend=" + isRecommend +
                '}';
    }
}
