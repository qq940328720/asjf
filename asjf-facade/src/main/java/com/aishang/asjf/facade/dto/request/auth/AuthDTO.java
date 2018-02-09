package com.aishang.asjf.facade.dto.request.auth;

import com.aishang.asjf.facade.dto.request.base.BaseRequestDTO;

import java.util.Objects;

/**
 * Created by neeke on 17-9-13.
 */
public class AuthDTO extends BaseRequestDTO {

    private String account;
    private String password;

    @Override
    public String toString() {
        return "AuthDTO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthDTO authDTO = (AuthDTO) o;
        return Objects.equals(account, authDTO.account) &&
                Objects.equals(password, authDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthDTO() {

    }

    public AuthDTO(String account, String password) {

        this.account = account;
        this.password = password;
    }
}
