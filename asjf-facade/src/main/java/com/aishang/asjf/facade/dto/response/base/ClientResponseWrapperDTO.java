package com.aishang.asjf.facade.dto.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2017-10-20 whb
 * 子系统接口调用结果包装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponseWrapperDTO {

    private boolean success;
    private Object data;
    private String message;

    @Override
    public String toString() {
        return "ClientResponseWrapper{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientResponseWrapperDTO that = (ClientResponseWrapperDTO) o;

        if (success != that.success) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

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
}
