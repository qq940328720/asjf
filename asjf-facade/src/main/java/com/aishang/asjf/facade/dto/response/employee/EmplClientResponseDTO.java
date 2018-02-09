package com.aishang.asjf.facade.dto.response.employee;

import com.aishang.asjf.client.base.CilentBaseResponse;
import com.aishang.asjf.client.employee.response.EmplResponseWrapper;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by mx on 17-12-25.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmplClientResponseDTO extends CilentBaseResponse {
    private EmplResponseWrapper data;

    public EmplResponseWrapper getData() {
        return data;
    }

    public void setData(EmplResponseWrapper data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplClientResponseDTO that = (EmplClientResponseDTO) o;

        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmplClientResponseDTO{" +
                "data=" + data +
                '}';
    }
}
