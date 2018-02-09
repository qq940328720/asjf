package com.aishang.asjf.facade.dto.request.salesman;

import com.aishang.asjf.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by mx on 17-11-21.
 */
@ApiModel(value = "请求实体", description = "生成二维码")
public class QrRequestDTO extends BaseRequestDTO {

    @ApiModelProperty(value = "商品id")
    @NotNull
    @NotEmpty
    private String commodityCode;//商品id

    @ApiModelProperty(value = "业务员编号")
    @NotNull
    @NotEmpty
    private String employeeCode;//业务员编号

    @ApiModelProperty(value = "产品编号")
    @NotNull
    @NotEmpty
    private String productCode;//产品编号

    @ApiModelProperty(value = "商品价格")
    @NotNull
    private BigDecimal productPrice;//商品价格

    @ApiModelProperty(value = "门店code")
    @NotNull
    @NotEmpty
    private String storeCode;//门店code

    @ApiModelProperty(value = "是否预警 0,否 1,是")
    private String isWarning;//是否预警 0,否 1,是 ,

    @ApiModelProperty(value = "是否推荐 0,否 1,是")
    private String isRecommend;//是否推荐 0,否 1,是 ,

    public String getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(String isWarning) {
        this.isWarning = isWarning;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrRequestDTO that = (QrRequestDTO) o;

        if (commodityCode != null ? !commodityCode.equals(that.commodityCode) : that.commodityCode != null)
            return false;
        if (employeeCode != null ? !employeeCode.equals(that.employeeCode) : that.employeeCode != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (isWarning != null ? !isWarning.equals(that.isWarning) : that.isWarning != null) return false;
        return isRecommend != null ? isRecommend.equals(that.isRecommend) : that.isRecommend == null;
    }

    @Override
    public int hashCode() {
        int result = commodityCode != null ? commodityCode.hashCode() : 0;
        result = 31 * result + (employeeCode != null ? employeeCode.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (isWarning != null ? isWarning.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QrRequestDTO{" +
                "commodityCode='" + commodityCode + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", storeCode='" + storeCode + '\'' +
                ", isWarning='" + isWarning + '\'' +
                ", isRecommend='" + isRecommend + '\'' +
                '}';
    }
}
