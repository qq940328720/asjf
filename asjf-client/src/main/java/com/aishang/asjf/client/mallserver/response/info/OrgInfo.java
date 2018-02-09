package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;

/**
 * Created by mx on 17-12-6.
 */
public class OrgInfo implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgInfo orgInfo = (OrgInfo) o;

        if (id != null ? !id.equals(orgInfo.id) : orgInfo.id != null) return false;
        return name != null ? name.equals(orgInfo.name) : orgInfo.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrgInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
