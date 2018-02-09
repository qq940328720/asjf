package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;

/**
 * Created by mx on 17-12-7.
 */
public class AllEnumResponse implements Serializable {
    private String key;
    private String name;

    @Override
    public String toString() {
        return "AllEnumResponse{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllEnumResponse that = (AllEnumResponse) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
