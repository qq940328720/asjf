package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-12-4.
 */
public class CustCommodityInfo implements Serializable {

    private String commodityCode;//商品编码

    private String level1Name;//级别1 对应字典表产品类目描述

    private String level2Name;//级别2 对应字典表产品类目描述

    private String level3Name;//级别3 对应字典表产品类目描述

    private Byte state;//商品状态 1, 在售 2,待上架 3,下架

    private String commodityName;//商品名称

    private String specDescribe;//规格描述 对应字典表规格描述的描述

    private Integer sold;//已售

    private Integer stock;//库存

    private String label;//搜索文字（标签）,多条由中文逗号隔开

    private String commodityCompany;//商品单位 对应字典表商品单位描述

    private BigDecimal commodityPriceStore;//商品价格-本店

    private BigDecimal commodityPriceMarket;//商品价格-市场 即 基本价格

    private BigDecimal commodityPriceCost;//商品价格-成本

    private String bizid;//业务idz

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSpecDescribe() {
        return specDescribe;
    }

    public void setSpecDescribe(String specDescribe) {
        this.specDescribe = specDescribe;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCommodityCompany() {
        return commodityCompany;
    }

    public void setCommodityCompany(String commodityCompany) {
        this.commodityCompany = commodityCompany;
    }

    public BigDecimal getCommodityPriceStore() {
        return commodityPriceStore;
    }

    public void setCommodityPriceStore(BigDecimal commodityPriceStore) {
        this.commodityPriceStore = commodityPriceStore;
    }

    public BigDecimal getCommodityPriceMarket() {
        return commodityPriceMarket;
    }

    public void setCommodityPriceMarket(BigDecimal commodityPriceMarket) {
        this.commodityPriceMarket = commodityPriceMarket;
    }

    public BigDecimal getCommodityPriceCost() {
        return commodityPriceCost;
    }

    public void setCommodityPriceCost(BigDecimal commodityPriceCost) {
        this.commodityPriceCost = commodityPriceCost;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustCommodityInfo that = (CustCommodityInfo) o;

        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (level1Name != null ? !level1Name.equals(that.level1Name) : that.level1Name != null) return false;
        if (level2Name != null ? !level2Name.equals(that.level2Name) : that.level2Name != null) return false;
        if (level3Name != null ? !level3Name.equals(that.level3Name) : that.level3Name != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (specDescribe != null ? !specDescribe.equals(that.specDescribe) : that.specDescribe != null) return false;
        if (sold != null ? !sold.equals(that.sold) : that.sold != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (commodityCompany != null ? !commodityCompany.equals(that.commodityCompany) : that.commodityCompany != null)
            return false;
        if (commodityPriceStore != null ? !commodityPriceStore.equals(that.commodityPriceStore) : that.commodityPriceStore != null)
            return false;
        if (commodityPriceMarket != null ? !commodityPriceMarket.equals(that.commodityPriceMarket) : that.commodityPriceMarket != null)
            return false;
        if (commodityPriceCost != null ? !commodityPriceCost.equals(that.commodityPriceCost) : that.commodityPriceCost != null)
            return false;
        return bizid != null ? bizid.equals(that.bizid) : that.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (level1Name != null ? level1Name.hashCode() : 0);
        result = 31 * result + (level2Name != null ? level2Name.hashCode() : 0);
        result = 31 * result + (level3Name != null ? level3Name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (specDescribe != null ? specDescribe.hashCode() : 0);
        result = 31 * result + (sold != null ? sold.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (commodityCompany != null ? commodityCompany.hashCode() : 0);
        result = 31 * result + (commodityPriceStore != null ? commodityPriceStore.hashCode() : 0);
        result = 31 * result + (commodityPriceMarket != null ? commodityPriceMarket.hashCode() : 0);
        result = 31 * result + (commodityPriceCost != null ? commodityPriceCost.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustCommodityInfo{" +
                "commodityCode='" + commodityCode + '\'' +
                ", level1Name='" + level1Name + '\'' +
                ", level2Name='" + level2Name + '\'' +
                ", level3Name='" + level3Name + '\'' +
                ", state=" + state +
                ", commodityName='" + commodityName + '\'' +
                ", specDescribe='" + specDescribe + '\'' +
                ", sold=" + sold +
                ", stock=" + stock +
                ", label='" + label + '\'' +
                ", commodityCompany='" + commodityCompany + '\'' +
                ", commodityPriceStore=" + commodityPriceStore +
                ", commodityPriceMarket=" + commodityPriceMarket +
                ", commodityPriceCost=" + commodityPriceCost +
                ", bizid='" + bizid + '\'' +
                '}';
    }
}
