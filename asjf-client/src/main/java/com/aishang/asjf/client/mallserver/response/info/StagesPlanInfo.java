package com.aishang.asjf.client.mallserver.response.info;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mx on 17-11-22.
 */
public class StagesPlanInfo implements Serializable {

    private String productName;
    private String productCode;
    private InterestType interestType;
    private String totalRate;
    private String isPrePay;//是否有提前还款包
    private String prePayValue;//提前还款包的值
    private List<SupportTimeInfos> supportTimeInfos;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (null == productName) {
            productName = "";
        }
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        if (null == productCode) {
            productCode = "";
        }
        this.productCode = productCode;
    }

    public InterestType getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestType interestType) {
        this.interestType = interestType;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        if (null == totalRate) {
            totalRate = "";
        }
        this.totalRate = totalRate;
    }

    public List<SupportTimeInfos> getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List<SupportTimeInfos> supportTimeInfos) {
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

        StagesPlanInfo that = (StagesPlanInfo) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (interestType != null ? !interestType.equals(that.interestType) : that.interestType != null) return false;
        if (totalRate != null ? !totalRate.equals(that.totalRate) : that.totalRate != null) return false;
        if (isPrePay != null ? !isPrePay.equals(that.isPrePay) : that.isPrePay != null) return false;
        if (prePayValue != null ? !prePayValue.equals(that.prePayValue) : that.prePayValue != null) return false;
        if (supportTimeInfos != null ? !supportTimeInfos.equals(that.supportTimeInfos) : that.supportTimeInfos != null)
            return false;
        if (isWarning != null ? !isWarning.equals(that.isWarning) : that.isWarning != null) return false;
        return isRecommend != null ? isRecommend.equals(that.isRecommend) : that.isRecommend == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (totalRate != null ? totalRate.hashCode() : 0);
        result = 31 * result + (isPrePay != null ? isPrePay.hashCode() : 0);
        result = 31 * result + (prePayValue != null ? prePayValue.hashCode() : 0);
        result = 31 * result + (supportTimeInfos != null ? supportTimeInfos.hashCode() : 0);
        result = 31 * result + (isWarning != null ? isWarning.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StagesPlanInfo{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", interestType=" + interestType +
                ", totalRate='" + totalRate + '\'' +
                ", isPrePay='" + isPrePay + '\'' +
                ", prePayValue='" + prePayValue + '\'' +
                ", supportTimeInfos=" + supportTimeInfos +
                ", isWarning=" + isWarning +
                ", isRecommend=" + isRecommend +
                '}';
    }
}
