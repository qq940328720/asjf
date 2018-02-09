package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-25.
 */
public class QrListResponse implements Serializable {

    private String commodityCode;//商品编码

    private String commodityName;//商品名称

    private String qrCode;//二维码code

    private BigDecimal productPrice;//商品价格

    private String storeName;//门店名称

    private String storeCode;//门店code

    private String insertTime;//创建时间


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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        if (null == qrCode) {
            qrCode = "";
        }
        this.qrCode = qrCode;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        if (null == productPrice) {
            productPrice = new BigDecimal(0);
        }
        this.productPrice = productPrice;
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

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        if (null == storeCode) {
            storeCode = "";
        }
        this.storeCode = storeCode;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        if (null == insertTime) {
            insertTime = "";
        }
        this.insertTime = insertTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrListResponse that = (QrListResponse) o;

        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        return insertTime != null ? insertTime.equals(that.insertTime) : that.insertTime == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (qrCode != null ? qrCode.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrListResponse{" +
                "commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", productPrice=" + productPrice +
                ", storeName='" + storeName + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", insertTime='" + insertTime + '\'' +
                '}';
    }
}
