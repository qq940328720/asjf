package com.aishang.asjf.client.mallserver.response;


import com.aishang.asjf.client.base.CilentBaseResponse;

/**
 * Created by mx on 17-11-21.
 */
public class QrResponse extends CilentBaseResponse {

    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        if (null == qrCode) {
            qrCode = "";
        }
        this.qrCode = qrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrResponse that = (QrResponse) o;

        return qrCode != null ? qrCode.equals(that.qrCode) : that.qrCode == null;
    }

    @Override
    public int hashCode() {
        return qrCode != null ? qrCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "QrResponse{" +
                "qrCode='" + qrCode + '\'' +
                '}';
    }
}
