package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.mallserver.response.info.MerchantInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mx on 17-11-25.
 */
public class MerchantResponse implements Serializable {

    private List<MerchantInfo> outerDTOS;

    public List<MerchantInfo> getOuterDTOS() {
        return outerDTOS;
    }

    public void setOuterDTOS(List<MerchantInfo> outerDTOS) {
        this.outerDTOS = outerDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantResponse that = (MerchantResponse) o;

        return outerDTOS != null ? outerDTOS.equals(that.outerDTOS) : that.outerDTOS == null;
    }

    @Override
    public int hashCode() {
        return outerDTOS != null ? outerDTOS.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MerchantResponse{" +
                "outerDTOS=" + outerDTOS +
                '}';
    }
}
