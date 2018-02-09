package com.aishang.asjf.facade.dto.request.customer;

import com.aishang.asjf.common.utils.ConstantClassFunction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by whb on 17-12-20.
 */
@ApiModel(description = "保存银行卡信息请求实体")
public class UserBankResquestDTO {

    @ApiModelProperty(value = "银行卡号")
    @NotNull(message = "属性不能为空")
    @NotEmpty(message = "不能为空")
    private String bankCardnumber;//银行卡号

    @ApiModelProperty(value = "银行卡照片")
    @NotNull(message = "银行卡属性不能为空")
    @NotEmpty(message = "银行卡不能为空")
    private String bankCardImgUrl;//银行卡照片

    @ApiModelProperty(value = "手机号码")
    @NotNull(message = "银行预留手机号属性不能为空")
    @NotEmpty(message = "银行预留手机号码不能为空")
    @Pattern(regexp = ConstantClassFunction.REG_MOBILEPHONE)
    private String bankPhone;//手机号码

    private String bizid;


    @Override
    public String toString() {
        return "UserBankResquestDTO{" +
                "bankCardnumber='" + bankCardnumber + '\'' +
                ", bankCardImgUrl='" + bankCardImgUrl + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", bizid='" + bizid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBankResquestDTO that = (UserBankResquestDTO) o;

        if (bankCardnumber != null ? !bankCardnumber.equals(that.bankCardnumber) : that.bankCardnumber != null)
            return false;
        if (bankCardImgUrl != null ? !bankCardImgUrl.equals(that.bankCardImgUrl) : that.bankCardImgUrl != null)
            return false;
        if (bankPhone != null ? !bankPhone.equals(that.bankPhone) : that.bankPhone != null) return false;
        return bizid != null ? bizid.equals(that.bizid) : that.bizid == null;
    }

    @Override
    public int hashCode() {
        int result = bankCardnumber != null ? bankCardnumber.hashCode() : 0;
        result = 31 * result + (bankCardImgUrl != null ? bankCardImgUrl.hashCode() : 0);
        result = 31 * result + (bankPhone != null ? bankPhone.hashCode() : 0);
        result = 31 * result + (bizid != null ? bizid.hashCode() : 0);
        return result;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getBankCardnumber() {
        return bankCardnumber;
    }

    public void setBankCardnumber(String bankCardnumber) {
        this.bankCardnumber = bankCardnumber;
    }

    public String getBankCardImgUrl() {
        return bankCardImgUrl;
    }

    public void setBankCardImgUrl(String bankCardImgUrl) {
        this.bankCardImgUrl = bankCardImgUrl;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

}
