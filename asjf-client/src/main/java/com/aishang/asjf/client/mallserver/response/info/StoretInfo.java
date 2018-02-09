package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;

/**
 * Created by mx on 17-11-21.
 */
public class StoretInfo implements Serializable {

    private String storeCode;
    private String storeFullName;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        if (null == storeCode) {
            storeCode = "";
        }
        this.storeCode = storeCode;
    }

    public String getStoreFullName() {
        return storeFullName;
    }

    public void setStoreFullName(String storeFullName) {
        if (null == storeFullName) {
            storeFullName = "";
        }
        this.storeFullName = storeFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoretInfo that = (StoretInfo) o;

        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        return storeFullName != null ? storeFullName.equals(that.storeFullName) : that.storeFullName == null;
    }

    @Override
    public int hashCode() {
        int result = storeCode != null ? storeCode.hashCode() : 0;
        result = 31 * result + (storeFullName != null ? storeFullName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoretInfo{" +
                "storeCode='" + storeCode + '\'' +
                ", storeFullName='" + storeFullName + '\'' +
                '}';
    }
}
