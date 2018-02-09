package com.aishang.asjf.client.apiserver.response.info;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by mx on 17-12-9.
 */
public class BankListInfoResponse implements Serializable {
    private String[] dataValue;

    public String[] getDataValue() {
        return dataValue;
    }

    public void setDataValue(String[] dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankListInfoResponse that = (BankListInfoResponse) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dataValue, that.dataValue);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dataValue);
    }

    @Override
    public String toString() {
        return "BankListInfoResponse{" +
                "dataValue=" + Arrays.toString(dataValue) +
                '}';
    }
}
