package com.aishang.asjf.client.mallserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 2017-10-20 mx
 * 子系统接口调用结果包装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StagesPlanResponseWrapper implements Serializable {

    private boolean success;
    private boolean executed;
    private String message;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StagesPlanResponseWrapper that = (StagesPlanResponseWrapper) o;

        if (success != that.success) return false;
        if (executed != that.executed) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (executed ? 1 : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StagesPlanResponseWrapper{" +
                "success=" + success +
                ", executed=" + executed +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
