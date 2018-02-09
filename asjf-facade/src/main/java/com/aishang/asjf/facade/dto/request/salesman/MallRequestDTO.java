package com.aishang.asjf.facade.dto.request.salesman;

import com.aishang.asjf.facade.dto.request.base.BaseRequestParameters;
import com.aishang.asjf.facade.dto.request.salesman.emun.SortEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mx on 17-11-21.
 */
@ApiModel(description = "商品分页请求实体")
public class MallRequestDTO extends BaseRequestParameters {

    @ApiModelProperty(value = "级别1", required = false)
    private String level1Name;//级别1 对应字典表产品类目描述
    @ApiModelProperty(value = "级别2", required = false)
    private String level2Name;//级别2 对应字典表产品类目描述
    @ApiModelProperty(value = "级别3", required = false)
    private String level3Name;//级别3 对应字典表产品类目描述
    @ApiModelProperty(value = "商品名称", required = false)
    private String commodityName;//商品名称
    @ApiModelProperty(value = "排序", required = false)
    private SortEnum sort;//排序
    @ApiModelProperty(value = "列名称", required = false, hidden = true)
    private String column;//列名称

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
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

    public SortEnum getSort() {
        return sort;
    }

    public void setSort(SortEnum sort) {
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

        MallRequestDTO that = (MallRequestDTO) o;

        if (level1Name != null ? !level1Name.equals(that.level1Name) : that.level1Name != null) return false;
        if (level2Name != null ? !level2Name.equals(that.level2Name) : that.level2Name != null) return false;
        if (level3Name != null ? !level3Name.equals(that.level3Name) : that.level3Name != null) return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (sort != that.sort) return false;
        return column != null ? column.equals(that.column) : that.column == null;
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
        return "MallRequestDTO{" +
                "level1Name='" + level1Name + '\'' +
                ", level2Name='" + level2Name + '\'' +
                ", level3Name='" + level3Name + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", sort=" + sort +
                ", column='" + column + '\'' +
                '}';
    }
}
