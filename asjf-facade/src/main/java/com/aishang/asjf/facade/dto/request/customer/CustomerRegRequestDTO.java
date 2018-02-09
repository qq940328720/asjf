package com.aishang.asjf.facade.dto.request.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@ApiModel(value = "请求参数", description = "注册账号")
public class CustomerRegRequestDTO extends CustomerBaseRequestDTO {

    @ApiModelProperty(value = "手机号码")
    @NotNull
    @NotEmpty
    private String phone;

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

    @Override
    public String toString() {
        return "CustomerRegRequestDTO{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRegRequestDTO that = (CustomerRegRequestDTO) o;
        return Objects.equals(phone, that.phone) &&
                Objects.equals(code, that.code) &&
                Objects.equals(password1, that.password1) &&
                Objects.equals(password2, that.password2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, code, password1, password2);
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

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerRegRequestDTO() {

    }

    public CustomerRegRequestDTO(String phone, String code) {

        this.phone = phone;
        this.code = code;
    }
}
