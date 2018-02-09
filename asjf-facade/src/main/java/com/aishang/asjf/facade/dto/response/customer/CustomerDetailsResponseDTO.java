package com.aishang.asjf.facade.dto.response.customer;

import java.util.Objects;

/**
 * Created by neeke on 17-9-9.
 */
public class CustomerDetailsResponseDTO extends CustomerBaseResponseDTO {

    private String custCode;
    private String mobilePhone;
    private String username;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Long createdAt;
    private Long updatedAt;

    @Override
    public String toString() {
        return "CustomerDetailsResponseDTO{" +
                "custCode='" + custCode + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", username='" + username + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetailsResponseDTO that = (CustomerDetailsResponseDTO) o;
        return Objects.equals(custCode, that.custCode) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(username, that.username) &&
                Objects.equals(accountNonExpired, that.accountNonExpired) &&
                Objects.equals(accountNonLocked, that.accountNonLocked) &&
                Objects.equals(credentialsNonExpired, that.credentialsNonExpired) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custCode, mobilePhone, username, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, createdAt, updatedAt);
    }

    public String getCustCode() {

        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CustomerDetailsResponseDTO(String custCode, String mobilePhone, String username, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled, Long createdAt, Long updatedAt) {

        this.custCode = custCode;
        this.mobilePhone = mobilePhone;
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CustomerDetailsResponseDTO() {

    }
}
