package com.aishang.asjf.client.crmserver.request;

public class OrderSignRequest {

    private String asPaperContractno;//爱尚纸质合同号

    private String asPaperContract;//爱尚纸质合

    private String loannumber;//合同编号

    private Integer moneyResource;//资方 1,爱尚   2,小雨点  3,西藏信托

    private String payMoneyState;//还款状态

    private String payMoneyRemark;//还款标记

    private String contract;//合同

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
    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
