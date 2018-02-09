package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.mallserver.response.info.QrCreateLogInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mx on 17-11-23.
 */
public class QrCodeResponse implements Serializable {

    private List<QrCreateLogInfo> qrCreateLogInfoDTOS;

    private boolean success;
    private boolean executed;
    private String message;
    private Object data;
    private Integer total;

    public List<QrCreateLogInfo> getQrCreateLogInfoDTOS() {
        return qrCreateLogInfoDTOS;
    }

    public void setQrCreateLogInfoDTOS(List<QrCreateLogInfo> qrCreateLogInfoDTOS) {
        this.qrCreateLogInfoDTOS = qrCreateLogInfoDTOS;
    }

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if (null == total) {
            total = 0;
        }
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrCodeResponse that = (QrCodeResponse) o;

        if (success != that.success) return false;
        if (executed != that.executed) return false;
        if (qrCreateLogInfoDTOS != null ? !qrCreateLogInfoDTOS.equals(that.qrCreateLogInfoDTOS) : that.qrCreateLogInfoDTOS != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = qrCreateLogInfoDTOS != null ? qrCreateLogInfoDTOS.hashCode() : 0;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (executed ? 1 : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrCodeResponse{" +
                "qrCreateLogInfoDTOS=" + qrCreateLogInfoDTOS +
                ", success=" + success +
                ", executed=" + executed +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
