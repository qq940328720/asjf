package com.aishang.asjf.client.crmserver.request;


import com.aishang.asjf.client.crmserver.enums.IsFormalEnum;
import com.aishang.asjf.client.crmserver.enums.UserHighesteducationEnum;
import com.aishang.asjf.client.crmserver.enums.UserIncomeResourceEnum;

import java.math.BigDecimal;

/**
 * @Author whb
 * @Data 17-11-22 上午9:30
 */
public class ClientWorkDetailResquest {

    private UserIncomeResourceEnum userIncomeResource;

    private UserHighesteducationEnum userHighesteducation;

    private BigDecimal userIncome;//月收入

    private IsFormalEnum isFormal;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientWorkDetailResquest that = (ClientWorkDetailResquest) o;

        if (userIncomeResource != that.userIncomeResource) return false;
        if (userHighesteducation != that.userHighesteducation) return false;
        if (userIncome != null ? !userIncome.equals(that.userIncome) : that.userIncome != null) return false;
        return isFormal == that.isFormal;
    }

    @Override
    public int hashCode() {
        int result = userIncomeResource != null ? userIncomeResource.hashCode() : 0;
        result = 31 * result + (userHighesteducation != null ? userHighesteducation.hashCode() : 0);
        result = 31 * result + (userIncome != null ? userIncome.hashCode() : 0);
        result = 31 * result + (isFormal != null ? isFormal.hashCode() : 0);
        return result;
    }

    public IsFormalEnum getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(IsFormalEnum isFormal) {
        this.isFormal = isFormal;
    }

    public UserIncomeResourceEnum getUserIncomeResource() {
        return userIncomeResource;
    }

    public void setUserIncomeResource(UserIncomeResourceEnum userIncomeResource) {
        this.userIncomeResource = userIncomeResource;
    }

    public UserHighesteducationEnum getUserHighesteducation() {
        return userHighesteducation;
    }

    public void setUserHighesteducation(UserHighesteducationEnum userHighesteducation) {
        this.userHighesteducation = userHighesteducation;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }
}
