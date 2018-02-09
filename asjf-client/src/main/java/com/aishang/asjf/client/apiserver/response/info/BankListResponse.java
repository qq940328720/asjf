package com.aishang.asjf.client.apiserver.response.info;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by mx on 17-12-9.
 */
public class BankListResponse implements Serializable {
    private String[] dataName;

    public String[] getDataName() {
        return dataName;
    }

    public void setDataName(String[] dataName) {
        this.dataName = dataName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankListResponse that = (BankListResponse) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dataName, that.dataName);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dataName);
    }

    @Override
    public String toString() {
        return "BankListResponse{" +
                "dataName=" + Arrays.toString(dataName) +
                '}';
    }
}
