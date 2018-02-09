package com.aishang.asjf.client.crmserver.request;


public class SigUrlRequest {

    private String orderNo;

    private String productNo;

    private String redirectUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SigUrlRequest that = (SigUrlRequest) o;

        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (productNo != null ? !productNo.equals(that.productNo) : that.productNo != null) return false;
        return redirectUrl != null ? redirectUrl.equals(that.redirectUrl) : that.redirectUrl == null;
    }

    @Override
    public int hashCode() {
        int result = orderNo != null ? orderNo.hashCode() : 0;
        result = 31 * result + (productNo != null ? productNo.hashCode() : 0);
        result = 31 * result + (redirectUrl != null ? redirectUrl.hashCode() : 0);
        return result;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
