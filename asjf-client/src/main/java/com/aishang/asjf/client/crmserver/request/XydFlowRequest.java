package com.aishang.asjf.client.crmserver.request;

public class XydFlowRequest  {
    private String asTag;           //'小雨点前置模型状态'
    private Long asTagTime;         //'小雨点前置模型调用时间'
    private String xydLoannumber;   //'小雨点贷款号'
    private Long commitTime;        //'提交时间'
    private Long signTime;          //'签约成功时间'
    private Integer auditState;     //'小雨点审核状态 0:审核拒绝  1:审核通过'
    private Long auditTime;         //'小雨点审核通过时间'
    private Integer planState;      //'还款计划是否推送 0:未推送  1:已经推送'
    private Long planTime;          //'还款计划推送成功时间'
    private Integer isSnedMoney;    //'是否放款 0:未放款 1:已放款'
    private Long snedMoneyDate;     //'放款时间'

    public String getAsTag() {
        return asTag;
    }

    public void setAsTag(String asTag) {
        this.asTag = asTag;
    }

    public Long getAsTagTime() {
        return asTagTime;
    }

    public void setAsTagTime(Long asTagTime) {
        this.asTagTime = asTagTime;
    }

    public String getXydLoannumber() {
        return xydLoannumber;
    }

    public void setXydLoannumber(String xydLoannumber) {
        this.xydLoannumber = xydLoannumber;
    }

    public Long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Long commitTime) {
        this.commitTime = commitTime;
    }

    public Long getSignTime() {
        return signTime;
    }

    public void setSignTime(Long signTime) {
        this.signTime = signTime;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Long getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Long auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getPlanState() {
        return planState;
    }

    public void setPlanState(Integer planState) {
        this.planState = planState;
    }

    public Long getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Long planTime) {
        this.planTime = planTime;
    }

    public Integer getIsSnedMoney() {
        return isSnedMoney;
    }

    public void setIsSnedMoney(Integer isSnedMoney) {
        this.isSnedMoney = isSnedMoney;
    }

    public Long getSnedMoneyDate() {
        return snedMoneyDate;
    }

    public void setSnedMoneyDate(Long snedMoneyDate) {
        this.snedMoneyDate = snedMoneyDate;
    }
}
