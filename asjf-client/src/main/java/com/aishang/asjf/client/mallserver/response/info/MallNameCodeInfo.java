package com.aishang.asjf.client.mallserver.response.info;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mx on 17-11-22.
 */
public class MallNameCodeInfo implements Serializable {

    private String dataCode;
    private String dataName;
    List<MallNameCodeInfo> nodes;

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        if (null == dataCode) {
            dataCode = "";
        }
        this.dataCode = dataCode;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        if (null == dataName) {
            dataName = "";
        }
        this.dataName = dataName;
    }

    public List<MallNameCodeInfo> getNodes() {
        return nodes;
    }

    public void setNodes(List<MallNameCodeInfo> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallNameCodeInfo that = (MallNameCodeInfo) o;

        if (dataCode != null ? !dataCode.equals(that.dataCode) : that.dataCode != null) return false;
        if (dataName != null ? !dataName.equals(that.dataName) : that.dataName != null) return false;
        return nodes != null ? nodes.equals(that.nodes) : that.nodes == null;
    }

    @Override
    public int hashCode() {
        int result = dataCode != null ? dataCode.hashCode() : 0;
        result = 31 * result + (dataName != null ? dataName.hashCode() : 0);
        result = 31 * result + (nodes != null ? nodes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MallNameCodeInfo{" +
                "dataCode='" + dataCode + '\'' +
                ", dataName='" + dataName + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
