package com.aishang.asjf.client.apiserver.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ResponseWrapper<T> implements Serializable {
    private String code;
    private T data;
    private String supplier;
    private boolean ok;
    private BigDecimal cost = new BigDecimal(0);

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", supplier='" + supplier + '\'' +
                ", ok=" + ok +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapper<?> that = (ResponseWrapper<?>) o;
        return ok == that.ok &&
                Objects.equals(code, that.code) &&
                Objects.equals(data, that.data) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data, supplier, ok, cost);
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
