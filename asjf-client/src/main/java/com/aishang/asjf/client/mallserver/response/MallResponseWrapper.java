package com.aishang.asjf.client.mallserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 2017-10-20 mx
 * 子系统接口调用结果包装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MallResponseWrapper implements Serializable {

    private boolean success;
    private Object data;
    private String message;
    private Integer total;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallResponseWrapper that = (MallResponseWrapper) o;

        if (success != that.success) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MallResponseWrapper{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", total=" + total +
                '}';
    }
}
