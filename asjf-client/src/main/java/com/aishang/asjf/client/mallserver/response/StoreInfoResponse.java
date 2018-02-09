package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mx on 17-11-25.
 */
public class StoreInfoResponse implements Serializable {

    private String commodityCode;//商品编码
    private String commodityName;//商品名称
    private String storeCode;//门店code
    private String storeName;//门店名称
    private BigDecimal commodityPrice;//商品价格
    private String productName;//产品名称
    private String productCode;//产品名称
    private Object interestType;
    private BigDecimal totalRate;
    //    private Object supportTimeInfos;
    private List supportTimeInfos;
    private BigDecimal loanAmountMin;

    private BigDecimal loanAmountMax;
    private String isPrePay;

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

    public BigDecimal getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(BigDecimal loanAmountMin) {
        if (null == loanAmountMin) {
            loanAmountMin = new BigDecimal(0);
        }
        this.loanAmountMin = loanAmountMin;
    }

    public BigDecimal getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(BigDecimal loanAmountMax) {
        if (null == loanAmountMax) {
            loanAmountMax = new BigDecimal(0);
        }
        this.loanAmountMax = loanAmountMax;
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

    public List getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }

    public String getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(String isPrePay) {
        if(null == isPrePay){
            isPrePay = "0";
        }
        this.isPrePay = isPrePay;
    }
}
