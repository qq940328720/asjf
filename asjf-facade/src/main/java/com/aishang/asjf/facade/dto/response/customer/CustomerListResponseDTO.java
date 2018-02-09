package com.aishang.asjf.facade.dto.response.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by neeke on 17-9-5.
 */
@JsonIgnoreProperties(value = {"password"})
public class CustomerListResponseDTO extends CustomerBaseResponseDTO {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated
     */
    @JsonIgnore
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.code
     *
     * @mbg.generated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account_non_expired
     *
     * @mbg.generated
     */
    private Boolean accountNonExpired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account_non_locked
     *
     * @mbg.generated
     */
    private Boolean accountNonLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.credentials_non_expired
     *
     * @mbg.generated
     */
    private Boolean credentialsNonExpired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.enabled
     *
     * @mbg.generated
     */
    private Boolean enabled;

    @Override
    public String toString() {
        return "UserListResponseDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CustomerListResponseDTO that = (CustomerListResponseDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (accountNonExpired != null ? !accountNonExpired.equals(that.accountNonExpired) : that.accountNonExpired != null)
            return false;
        if (accountNonLocked != null ? !accountNonLocked.equals(that.accountNonLocked) : that.accountNonLocked != null)
            return false;
        if (credentialsNonExpired != null ? !credentialsNonExpired.equals(that.credentialsNonExpired) : that.credentialsNonExpired != null)
            return false;
        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (accountNonExpired != null ? accountNonExpired.hashCode() : 0);
        result = 31 * result + (accountNonLocked != null ? accountNonLocked.hashCode() : 0);
        result = 31 * result + (credentialsNonExpired != null ? credentialsNonExpired.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }


    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
