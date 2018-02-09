package com.aishang.asjf.client.orderserver.request.PushDataRequest;

public class PushDataRequestClient {
    private String order_no;                // 订单编号（唯一）

    private String product_no;              // 固定值:3C

    private UserInfoRequestClient userInfoRequestDTO;              // 客户信息

    private LoanInfoRequestClient loanInfoRequestDTO;              // 借款信息

    private BankInfoRequestClient bankInfoRequestDTO;              // 银行信息

    private ContactInfoRequestClient contactInfoRequestDTO;        // 联系人信息

    private GoodsInfoRequestClient goodsInfoRequestDTO;            // 商品信息

    private WorkInfoRequestClient workInfoRequestDTO;              // 单位信息

    @Override
    public String toString() {
        return "PushDataRequestClient{" +
                "order_no='" + order_no + '\'' +
                ", product_no='" + product_no + '\'' +
                ", userInfoRequestDTO=" + userInfoRequestDTO +
                ", loanInfoRequestDTO=" + loanInfoRequestDTO +
                ", bankInfoRequestDTO=" + bankInfoRequestDTO +
                ", contactInfoRequestDTO=" + contactInfoRequestDTO +
                ", goodsInfoRequestDTO=" + goodsInfoRequestDTO +
                ", workInfoRequestDTO=" + workInfoRequestDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PushDataRequestClient that = (PushDataRequestClient) o;

        if (order_no != null ? !order_no.equals(that.order_no) : that.order_no != null) return false;
        if (product_no != null ? !product_no.equals(that.product_no) : that.product_no != null) return false;
        if (userInfoRequestDTO != null ? !userInfoRequestDTO.equals(that.userInfoRequestDTO) : that.userInfoRequestDTO != null)
            return false;
        if (loanInfoRequestDTO != null ? !loanInfoRequestDTO.equals(that.loanInfoRequestDTO) : that.loanInfoRequestDTO != null)
            return false;
        if (bankInfoRequestDTO != null ? !bankInfoRequestDTO.equals(that.bankInfoRequestDTO) : that.bankInfoRequestDTO != null)
            return false;
        if (contactInfoRequestDTO != null ? !contactInfoRequestDTO.equals(that.contactInfoRequestDTO) : that.contactInfoRequestDTO != null)
            return false;
        if (goodsInfoRequestDTO != null ? !goodsInfoRequestDTO.equals(that.goodsInfoRequestDTO) : that.goodsInfoRequestDTO != null)
            return false;
        return workInfoRequestDTO != null ? workInfoRequestDTO.equals(that.workInfoRequestDTO) : that.workInfoRequestDTO == null;
    }

    @Override
    public int hashCode() {
        int result = order_no != null ? order_no.hashCode() : 0;
        result = 31 * result + (product_no != null ? product_no.hashCode() : 0);
        result = 31 * result + (userInfoRequestDTO != null ? userInfoRequestDTO.hashCode() : 0);
        result = 31 * result + (loanInfoRequestDTO != null ? loanInfoRequestDTO.hashCode() : 0);
        result = 31 * result + (bankInfoRequestDTO != null ? bankInfoRequestDTO.hashCode() : 0);
        result = 31 * result + (contactInfoRequestDTO != null ? contactInfoRequestDTO.hashCode() : 0);
        result = 31 * result + (goodsInfoRequestDTO != null ? goodsInfoRequestDTO.hashCode() : 0);
        result = 31 * result + (workInfoRequestDTO != null ? workInfoRequestDTO.hashCode() : 0);
        return result;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public UserInfoRequestClient getUserInfoRequestDTO() {
        return userInfoRequestDTO;
    }

    public void setUserInfoRequestDTO(UserInfoRequestClient userInfoRequestDTO) {
        this.userInfoRequestDTO = userInfoRequestDTO;
    }

    public LoanInfoRequestClient getLoanInfoRequestDTO() {
        return loanInfoRequestDTO;
    }

    public void setLoanInfoRequestDTO(LoanInfoRequestClient loanInfoRequestDTO) {
        this.loanInfoRequestDTO = loanInfoRequestDTO;
    }

    public BankInfoRequestClient getBankInfoRequestDTO() {
        return bankInfoRequestDTO;
    }

    public void setBankInfoRequestDTO(BankInfoRequestClient bankInfoRequestDTO) {
        this.bankInfoRequestDTO = bankInfoRequestDTO;
    }

    public ContactInfoRequestClient getContactInfoRequestDTO() {
        return contactInfoRequestDTO;
    }

    public void setContactInfoRequestDTO(ContactInfoRequestClient contactInfoRequestDTO) {
        this.contactInfoRequestDTO = contactInfoRequestDTO;
    }

    public GoodsInfoRequestClient getGoodsInfoRequestDTO() {
        return goodsInfoRequestDTO;
    }

    public void setGoodsInfoRequestDTO(GoodsInfoRequestClient goodsInfoRequestDTO) {
        this.goodsInfoRequestDTO = goodsInfoRequestDTO;
    }

    public WorkInfoRequestClient getWorkInfoRequestDTO() {
        return workInfoRequestDTO;
    }

    public void setWorkInfoRequestDTO(WorkInfoRequestClient workInfoRequestDTO) {
        this.workInfoRequestDTO = workInfoRequestDTO;
    }
}
