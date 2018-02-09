package com.aishang.asjf.client.orderserver.request.PushDataRequest;

import java.math.BigDecimal;

//推送数据--借款信息请求对象
public class LoanInfoRequestClient {

    private String installments;       // 期数

    private BigDecimal downPayment;        // 首付

    private BigDecimal loanAmount;         // 贷款金额

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanInfoRequestClient that = (LoanInfoRequestClient) o;

        if (installments != null ? !installments.equals(that.installments) : that.installments != null) return false;
        if (downPayment != null ? !downPayment.equals(that.downPayment) : that.downPayment != null) return false;
        return loanAmount != null ? loanAmount.equals(that.loanAmount) : that.loanAmount == null;
    }

    @Override
    public int hashCode() {
        int result = installments != null ? installments.hashCode() : 0;
        result = 31 * result + (downPayment != null ? downPayment.hashCode() : 0);
        result = 31 * result + (loanAmount != null ? loanAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoanInfoRequestDTO{" +
                "installments='" + installments + '\'' +
                ", downPayment=" + downPayment +
                ", loanAmount=" + loanAmount +
                '}';
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }
}
