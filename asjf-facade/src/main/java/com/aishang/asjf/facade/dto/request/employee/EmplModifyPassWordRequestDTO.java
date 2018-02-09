package com.aishang.asjf.facade.dto.request.employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by mx on 17-12-25.
 */
@ApiModel(value = "业务员修改密码请求实体")
public class EmplModifyPassWordRequestDTO {

    @ApiModelProperty(value = "验证码")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^\\d{4}$")
    private String code;

    @ApiModelProperty(value = "第一次密码")
    @NotNull
    @NotEmpty
    private String password1;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "第二次密码")
    private String password2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplModifyPassWordRequestDTO that = (EmplModifyPassWordRequestDTO) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (password1 != null ? !password1.equals(that.password1) : that.password1 != null) return false;
        return password2 != null ? password2.equals(that.password2) : that.password2 == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (password1 != null ? password1.hashCode() : 0);
        result = 31 * result + (password2 != null ? password2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmplModifyPassWordRequestDTO{" +
                "code='" + code + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
