package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.InterestTypeEnum;
import com.aishang.asjf.client.mallserver.response.info.ProductInfoResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mx on 17-11-24.
 */
public class ProductResponse extends CilentBaseResponse {

    private String productName;

    private InterestTypeEnum interestType;

    private BigDecimal totalRate;

    private List<ProductInfoResponse> supportTimeInfos;

    private String isPrePay;

    private String prePayValue;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (null == productName) {
            productName = "";
        }
        this.productName = productName;
    }

    public InterestTypeEnum getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestTypeEnum interestType) {
        this.interestType = interestType;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        if (null == totalRate) {
            totalRate = new BigDecimal(0);
        }
        this.totalRate = totalRate;
    }

    public List<ProductInfoResponse> getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List<ProductInfoResponse> supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }

    public String getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(String isPrePay) {
        this.isPrePay = isPrePay;
    }

    public String getPrePayValue() {
        return prePayValue;
    }

    public void setPrePayValue(String prePayValue) {
        this.prePayValue = prePayValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductResponse that = (ProductResponse) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (interestType != null ? !interestType.equals(that.interestType) : that.interestType != null) return false;
        if (totalRate != null ? !totalRate.equals(that.totalRate) : that.totalRate != null) return false;
        if (supportTimeInfos != null ? !supportTimeInfos.equals(that.supportTimeInfos) : that.supportTimeInfos != null)
            return false;
        if (isPrePay != null ? !isPrePay.equals(that.isPrePay) : that.isPrePay != null) return false;
        return prePayValue != null ? prePayValue.equals(that.prePayValue) : that.prePayValue == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (totalRate != null ? totalRate.hashCode() : 0);
        result = 31 * result + (supportTimeInfos != null ? supportTimeInfos.hashCode() : 0);
        result = 31 * result + (isPrePay != null ? isPrePay.hashCode() : 0);
        result = 31 * result + (prePayValue != null ? prePayValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "productName='" + productName + '\'' +
                ", interestType=" + interestType +
                ", totalRate=" + totalRate +
                ", supportTimeInfos=" + supportTimeInfos +
                ", isPrePay=" + isPrePay +
                ", prePayValue=" + prePayValue +
                '}';
    }
}
