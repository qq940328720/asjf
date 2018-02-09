package com.aishang.asjf.client.mallserver.request;

import com.aishang.asjf.client.base.ClientBaseRequestParameters;

/**
 * Created by mx on 17-11-21.
 */

public class MallRequest extends ClientBaseRequestParameters {

    private String level1Name;//级别1 对应字典表产品类目描述

    private String level2Name;//级别2 对应字典表产品类目描述

    private String level3Name;//级别3 对应字典表产品类目描述

    private String commodityName;//商品名称

    private String sort;//排序

    private String column;//列名称

    public String getLevel1Name() {
        if(null == level1Name){
            return "";
        }
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        if(null == level2Name){
            return "";
        }
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        if(null == level3Name){
            return "";
        }
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MallRequest request = (MallRequest) o;

        if (level1Name != null ? !level1Name.equals(request.level1Name) : request.level1Name != null) return false;
        if (level2Name != null ? !level2Name.equals(request.level2Name) : request.level2Name != null) return false;
        if (level3Name != null ? !level3Name.equals(request.level3Name) : request.level3Name != null) return false;
        if (commodityName != null ? !commodityName.equals(request.commodityName) : request.commodityName != null)
            return false;
        if (sort != null ? !sort.equals(request.sort) : request.sort != null) return false;
        return column != null ? column.equals(request.column) : request.column == null;
    }

    @Override
    public int hashCode() {
        int result = level1Name != null ? level1Name.hashCode() : 0;
        result = 31 * result + (level2Name != null ? level2Name.hashCode() : 0);
        result = 31 * result + (level3Name != null ? level3Name.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (column != null ? column.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MallRequest{" +
                "level1Name='" + level1Name + '\'' +
                ", level2Name='" + level2Name + '\'' +
                ", level3Name='" + level3Name + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", sort='" + sort + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}
