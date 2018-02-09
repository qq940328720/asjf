package com.aishang.asjf.facade.dto.request.customer;

import com.aishang.asjf.facade.dto.request.base.BaseRequestParameters;
import com.aishang.asjf.facade.dto.request.salesman.emun.ClientResourceEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Created by mx on 17-12-4.
 */
@ApiModel(description = "客户下单请求实体")
public class CustPreOrderRequestDTO {

    @ApiModelProperty(value = "二维码编号")
    @NotNull
    @NotEmpty
    private String qrCode;//二维码编号

    @ApiModelProperty(value = "客户编号")
    @NotNull
    @NotEmpty
    private String userCode;//客户编号

    @ApiModelProperty(value = "首付金额")
    @Min(value = 0)
//    @Max(0)
//    @Length(8)
    private BigDecimal firstPayMoney;//首付金额
//    private BigDecimal loanMoney;//贷款金额（后台计算）

    @ApiModelProperty(value = "期数")
    private Integer payTime;//期数

    @ApiModelProperty(value = "是否有提前还款包(0:没有，1:有)")
    private Integer isQuickPayPackage;//是否有提前还款包

    @ApiModelProperty(value = "经度")
    private double lng;//经度

    @ApiModelProperty(value = "纬度")
    private double lat;//纬度

    @ApiModelProperty(value = "终端来源")
    private ClientResourceEnum clientResource;//终端来源

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public BigDecimal getFirstPayMoney() {
        return firstPayMoney;
    }

    public void setFirstPayMoney(BigDecimal firstPayMoney) {
        this.firstPayMoney = firstPayMoney;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getIsQuickPayPackage() {
        return isQuickPayPackage;
    }

    public void setIsQuickPayPackage(Integer isQuickPayPackage) {
        this.isQuickPayPackage = isQuickPayPackage;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public ClientResourceEnum getClientResource() {
        return clientResource;
    }

    public void setClientResource(ClientResourceEnum clientResource) {
        this.clientResource = clientResource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustPreOrderRequestDTO that = (CustPreOrderRequestDTO) o;

        if (Double.compare(that.lng, lng) != 0) return false;
        if (Double.compare(that.lat, lat) != 0) return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (firstPayMoney != null ? !firstPayMoney.equals(that.firstPayMoney) : that.firstPayMoney != null)
            return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (isQuickPayPackage != null ? !isQuickPayPackage.equals(that.isQuickPayPackage) : that.isQuickPayPackage != null)
            return false;
        return clientResource == that.clientResource;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = qrCode != null ? qrCode.hashCode() : 0;
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (firstPayMoney != null ? firstPayMoney.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (isQuickPayPackage != null ? isQuickPayPackage.hashCode() : 0);
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (clientResource != null ? clientResource.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustPreOrderRequestDTO{" +
                "qrCode='" + qrCode + '\'' +
                ", userCode='" + userCode + '\'' +
                ", firstPayMoney=" + firstPayMoney +
                ", payTime=" + payTime +
                ", isQuickPayPackage=" + isQuickPayPackage +
                ", lng=" + lng +
                ", lat=" + lat +
                ", clientResource=" + clientResource +
                '}';
    }
}
