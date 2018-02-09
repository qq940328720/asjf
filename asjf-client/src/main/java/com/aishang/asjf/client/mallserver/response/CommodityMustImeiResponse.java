package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.MustDeImeIcodeInfo;

/**
 * Created by mx on 17-12-11.
 */
public class CommodityMustImeiResponse extends CilentBaseResponse {

    private MustDeImeIcodeInfo isMustDeImeIcode;

    public MustDeImeIcodeInfo getIsMustDeImeIcode() {
        return isMustDeImeIcode;
    }

    public void setIsMustDeImeIcode(MustDeImeIcodeInfo isMustDeImeIcode) {
        this.isMustDeImeIcode = isMustDeImeIcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommodityMustImeiResponse that = (CommodityMustImeiResponse) o;

        return isMustDeImeIcode != null ? isMustDeImeIcode.equals(that.isMustDeImeIcode) : that.isMustDeImeIcode == null;
    }

    @Override
    public int hashCode() {
        return isMustDeImeIcode != null ? isMustDeImeIcode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CommodityMustImeiResponse{" +
                "isMustDeImeIcode=" + isMustDeImeIcode +
                '}';
    }
}
