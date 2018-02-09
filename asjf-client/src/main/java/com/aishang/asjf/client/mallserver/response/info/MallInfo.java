package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-21.
 */
public class MallInfo implements Serializable {

    private String commodityCode;//商品编码

    private String commodityName;//商品名称

    private BigDecimal commodityPriceStore;//商品价格-本店

    private BigDecimal loanAmountMin;

    private BigDecimal loanAmountMax;

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

    public BigDecimal getCommodityPriceStore() {
        return commodityPriceStore;
    }

    public void setCommodityPriceStore(BigDecimal commodityPriceStore) {
        if (null == commodityPriceStore) {
            commodityPriceStore = new BigDecimal(0);
        }
        this.commodityPriceStore = commodityPriceStore;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallInfo mallInfo = (MallInfo) o;

        if (commodityCode != null ? !commodityCode.equals(mallInfo.commodityCode) : mallInfo.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(mallInfo.commodityName) : mallInfo.commodityName != null)
            return false;
        if (commodityPriceStore != null ? !commodityPriceStore.equals(mallInfo.commodityPriceStore) : mallInfo.commodityPriceStore != null)
            return false;
        if (loanAmountMin != null ? !loanAmountMin.equals(mallInfo.loanAmountMin) : mallInfo.loanAmountMin != null)
            return false;
        return loanAmountMax != null ? loanAmountMax.equals(mallInfo.loanAmountMax) : mallInfo.loanAmountMax == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (commodityPriceStore != null ? commodityPriceStore.hashCode() : 0);
        result = 31 * result + (loanAmountMin != null ? loanAmountMin.hashCode() : 0);
        result = 31 * result + (loanAmountMax != null ? loanAmountMax.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MallInfo{" +
                "commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPriceStore=" + commodityPriceStore +
                ", loanAmountMin=" + loanAmountMin +
                ", loanAmountMax=" + loanAmountMax +
                '}';
    }
}
