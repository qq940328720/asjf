package com.aishang.asjf.facade.dto.request.customer;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SaveLinkerListRequestDTO {

    @NotNull
    private List<SaveLinkerRequestDTO> linkerList;

    public List<SaveLinkerRequestDTO> getLinkerList() {
        return linkerList;
    }

    public void setLinkerList(List<SaveLinkerRequestDTO> linkerList) {
        this.linkerList = linkerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaveLinkerListRequestDTO that = (SaveLinkerListRequestDTO) o;

        return linkerList != null ? linkerList.equals(that.linkerList) : that.linkerList == null;
    }

    @Override
    public int hashCode() {
        return linkerList != null ? linkerList.hashCode() : 0;
    }


}
