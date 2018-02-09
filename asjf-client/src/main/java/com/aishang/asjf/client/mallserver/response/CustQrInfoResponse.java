package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.mallserver.response.info.InterestTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mx on 17-11-25.
 */
public class CustQrInfoResponse implements Serializable {

//    private String merchantCode;//商户编码
//    private String merchantName;//商户名
//    private String storeCode;//门店编码   1
//    private String storeName;//门店名1
//    private String productCode;//产品编码1
//    private String productName;//产品名1
//    private String commodityCode;//商品编码1
//    private String commodityName;//商品名称1
//    private BigDecimal commodityPrice;//商品价格1
//    private InterestTypeEnum interestType;//计息方式 1.等额本息 2.等额本金 3.等本等息1
//    private Integer payTimeUnit;//期数单位
//    private Integer payTime;//期数
//    private BigDecimal totalRate;//利率(payRate)
//    private String level1Code;//级别1 对应字典表产品类目描述
//    private String level2Code;//级别2 对应字典表产品类目描述
//    private String level3Code;//级别3 对应字典表产品类目描述
//    private String empNameCode;//业务员CODE




    private String commodityCode;//商品编码1
    private String commodityName;//商品名称1
    private String storeCode;//门店code1
    private String storeName;//门店名称1
    private BigDecimal commodityPrice;//商品价格1
    private String productName;//产品名称1
    private String productCode;//产品code1
    private Object interestType;//计息方式 1.等额本息 2.等额本金 3.等本等息
    private BigDecimal totalRate;//利率1
    private List supportTimeInfos;//{期数，期数单位}
    private BigDecimal loanAmountMin;
    private BigDecimal loanAmountMax;
    private String empNameCode;//业务员CODE
    private String isPrePay;//是否有提前还款包  0,否  1,是

    //
//    private String merchantCode;//商户编码
//    private String merchantName;//商户名
//    private String level1Code;//级别1 对应字典表产品类目描述
//    private String level2Code;//级别2 对应字典表产品类目描述
//    private String level3Code;//级别3 对应字典表产品类目描述


    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        if (null == commodityCode) {
            commodityCode = "";
        }
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        if (null == commodityName) {
            commodityName = "";
        }
        this.commodityName = commodityName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        if (null == storeCode) {
            storeCode = "";
        }
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        if (null == storeName) {
            storeName = "";
        }
        this.storeName = storeName;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        if (null == commodityPrice) {
            commodityPrice = new BigDecimal(0.00);
        }
        this.commodityPrice = commodityPrice;
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
        if (null == totalRate) {
            totalRate = new BigDecimal(0.00);
        }
        this.totalRate = totalRate;
    }

    public List getSupportTimeInfos() {
        return supportTimeInfos;
    }

    public void setSupportTimeInfos(List supportTimeInfos) {
        this.supportTimeInfos = supportTimeInfos;
    }

    public BigDecimal getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(BigDecimal loanAmountMin) {
        if (null == loanAmountMin) {
            loanAmountMin = new BigDecimal(0.00);
        }
        this.loanAmountMin = loanAmountMin;
    }

    public BigDecimal getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(BigDecimal loanAmountMax) {
        if (null == loanAmountMax) {
            loanAmountMax = new BigDecimal(0.00);
        }
        this.loanAmountMax = loanAmountMax;
    }

    public String getEmpNameCode() {
        return empNameCode;
    }

    public void setEmpNameCode(String empNameCode) {
        if (null == empNameCode) {
            empNameCode = "";
        }
        this.empNameCode = empNameCode;
    }

    public String getIsPrePay() {
        return isPrePay;
    }

    public void setIsPrePay(String isPrePay) {
        this.isPrePay = isPrePay;
    }

}
