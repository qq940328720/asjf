package com.aishang.asjf.client.crmserver.request;

import java.util.List;

/**
 * Created by whb on 17-12-21.
 */
public class UpdRejectImgRequest {

    private List<ImgInfo> recieveData;

    private String stringCode;

    public List<ImgInfo> getRecieveData() {
        return recieveData;
    }

    public void setRecieveData(List<ImgInfo> recieveData) {
        this.recieveData = recieveData;
    }

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdRejectImgRequest that = (UpdRejectImgRequest) o;

        if (recieveData != null ? !recieveData.equals(that.recieveData) : that.recieveData != null) return false;
        return stringCode != null ? stringCode.equals(that.stringCode) : that.stringCode == null;
    }

    @Override
    public int hashCode() {
        int result = recieveData != null ? recieveData.hashCode() : 0;
        result = 31 * result + (stringCode != null ? stringCode.hashCode() : 0);
        return result;
    }
}
