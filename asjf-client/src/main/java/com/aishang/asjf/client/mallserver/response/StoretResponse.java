package com.aishang.asjf.client.mallserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.mallserver.response.info.StoretInfo;

import java.util.List;

/**
 * Created by mx on 17-11-21.
 */
public class StoretResponse extends CilentBaseResponse {

    private List<StoretInfo> storesInfoDTO;

    public List<StoretInfo> getStoresInfoDTO() {
        return storesInfoDTO;
    }

    public void setStoresInfoDTO(List<StoretInfo> storesInfoDTO) {
        this.storesInfoDTO = storesInfoDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoretResponse that = (StoretResponse) o;

        return storesInfoDTO != null ? storesInfoDTO.equals(that.storesInfoDTO) : that.storesInfoDTO == null;
    }

    @Override
    public int hashCode() {
        return storesInfoDTO != null ? storesInfoDTO.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StoretResponse{" +
                "storesInfoDTO=" + storesInfoDTO +
                '}';
    }
}
