package com.aishang.asjf.dal.model;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.mobile_phone
     *
     * @mbg.generated
     */
    private String mobilePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cust_code
     *
     * @mbg.generated
     */
    private String custCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.account_non_expired
     *
     * @mbg.generated
     */
    private Boolean accountNonExpired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.account_non_locked
     *
     * @mbg.generated
     */
    private Boolean accountNonLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.credentials_non_expired
     *
     * @mbg.generated
     */
    private Boolean credentialsNonExpired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.enabled
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.created_at
     *
     * @mbg.generated
     */
    private Long createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.updated_at
     *
     * @mbg.generated
     */
    private Long updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated
     */
    public Customer(Integer id, String mobilePhone, String custCode, String username, String password, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled, Long createdAt, Long updatedAt) {
        this.id = id;
        this.mobilePhone = mobilePhone;
        this.custCode = custCode;
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated
     */
    public Customer() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.id
     *
     * @return the value of customer.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.id
     *
     * @param id the value for customer.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.mobile_phone
     *
     * @return the value of customer.mobile_phone
     * @mbg.generated
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.mobile_phone
     *
     * @param mobilePhone the value for customer.mobile_phone
     * @mbg.generated
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cust_code
     *
     * @return the value of customer.cust_code
     * @mbg.generated
     */
    public String getCustCode() {
        return custCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cust_code
     *
     * @param custCode the value for customer.cust_code
     * @mbg.generated
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode == null ? null : custCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.username
     *
     * @return the value of customer.username
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.username
     *
     * @param username the value for customer.username
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.password
     *
     * @return the value of customer.password
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.password
     *
     * @param password the value for customer.password
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.account_non_expired
     *
     * @return the value of customer.account_non_expired
     * @mbg.generated
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.account_non_expired
     *
     * @param accountNonExpired the value for customer.account_non_expired
     * @mbg.generated
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.account_non_locked
     *
     * @return the value of customer.account_non_locked
     * @mbg.generated
     */
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.account_non_locked
     *
     * @param accountNonLocked the value for customer.account_non_locked
     * @mbg.generated
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.credentials_non_expired
     *
     * @return the value of customer.credentials_non_expired
     * @mbg.generated
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.credentials_non_expired
     *
     * @param credentialsNonExpired the value for customer.credentials_non_expired
     * @mbg.generated
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.enabled
     *
     * @return the value of customer.enabled
     * @mbg.generated
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.enabled
     *
     * @param enabled the value for customer.enabled
     * @mbg.generated
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.created_at
     *
     * @return the value of customer.created_at
     * @mbg.generated
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.created_at
     *
     * @param createdAt the value for customer.created_at
     * @mbg.generated
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.updated_at
     *
     * @return the value of customer.updated_at
     * @mbg.generated
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.updated_at
     *
     * @param updatedAt the value for customer.updated_at
     * @mbg.generated
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}