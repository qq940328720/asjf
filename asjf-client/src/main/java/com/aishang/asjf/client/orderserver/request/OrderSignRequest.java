package com.aishang.asjf.client.orderserver.request;

public class OrderSignRequest  {

    private String asPaperContractno;//爱尚纸质合同号

    private String asPaperContract;//爱尚纸质合

    private String loannumber;//合同编号

    private Integer moneyResource;//资方 1,爱尚   2,小雨点  3,西藏信托

    private String payMoneyState;//还款状态

    private String payMoneyRemark;//还款标记

    private Integer chargedResource;//代扣渠道  1,小雨点   2,西藏信托  3,爱尚

    private String contract;//合同

    private String errorCode;//签约错误码

    private String errorMemo;//签约错误描述


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderSignRequest that = (OrderSignRequest) o;

        if (asPaperContractno != null ? !asPaperContractno.equals(that.asPaperContractno) : that.asPaperContractno != null)
            return false;
        if (asPaperContract != null ? !asPaperContract.equals(that.asPaperContract) : that.asPaperContract != null)
            return false;
        if (loannumber != null ? !loannumber.equals(that.loannumber) : that.loannumber != null) return false;
        if (moneyResource != null ? !moneyResource.equals(that.moneyResource) : that.moneyResource != null)
            return false;
        if (payMoneyState != null ? !payMoneyState.equals(that.payMoneyState) : that.payMoneyState != null)
            return false;
        if (payMoneyRemark != null ? !payMoneyRemark.equals(that.payMoneyRemark) : that.payMoneyRemark != null)
            return false;
        if (chargedResource != null ? !chargedResource.equals(that.chargedResource) : that.chargedResource != null)
            return false;
        if (contract != null ? !contract.equals(that.contract) : that.contract != null) return false;
        if (errorCode != null ? !errorCode.equals(that.errorCode) : that.errorCode != null) return false;
        return errorMemo != null ? errorMemo.equals(that.errorMemo) : that.errorMemo == null;
    }

    @Override
    public int hashCode() {
        int result = asPaperContractno != null ? asPaperContractno.hashCode() : 0;
        result = 31 * result + (asPaperContract != null ? asPaperContract.hashCode() : 0);
        result = 31 * result + (loannumber != null ? loannumber.hashCode() : 0);
        result = 31 * result + (moneyResource != null ? moneyResource.hashCode() : 0);
        result = 31 * result + (payMoneyState != null ? payMoneyState.hashCode() : 0);
        result = 31 * result + (payMoneyRemark != null ? payMoneyRemark.hashCode() : 0);
        result = 31 * result + (chargedResource != null ? chargedResource.hashCode() : 0);
        result = 31 * result + (contract != null ? contract.hashCode() : 0);
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        result = 31 * result + (errorMemo != null ? errorMemo.hashCode() : 0);
        return result;
    }

    public String getAsPaperContractno() {
        return asPaperContractno;
    }

    public void setAsPaperContractno(String asPaperContractno) {
        this.asPaperContractno = asPaperContractno;
    }

    public String getAsPaperContract() {
        return asPaperContract;
    }

    public void setAsPaperContract(String asPaperContract) {
        this.asPaperContract = asPaperContract;
    }

    public String getLoannumber() {
        return loannumber;
    }

    public void setLoannumber(String loannumber) {
        this.loannumber = loannumber;
    }

    public Integer getMoneyResource() {
        return moneyResource;
    }

    public void setMoneyResource(Integer moneyResource) {
        this.moneyResource = moneyResource;
    }

    public String getPayMoneyState() {
        return payMoneyState;
    }

    public void setPayMoneyState(String payMoneyState) {
        this.payMoneyState = payMoneyState;
    }

    public String getPayMoneyRemark() {
        return payMoneyRemark;
    }

    public void setPayMoneyRemark(String payMoneyRemark) {
        this.payMoneyRemark = payMoneyRemark;
    }

    public Integer getChargedResource() {
        return chargedResource;
    }

    public void setChargedResource(Integer chargedResource) {
        this.chargedResource = chargedResource;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMemo() {
        return errorMemo;
    }

    public void setErrorMemo(String errorMemo) {
        this.errorMemo = errorMemo;
    }
}
