package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserCompetitionReponse implements Serializable {


    private BigDecimal dataCompletion;//区code

    @Override
    public String toString() {
        return "UserCompetitionReponse{" +
                "dataCompletion='" + dataCompletion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCompetitionReponse that = (UserCompetitionReponse) o;

        return dataCompletion != null ? dataCompletion.equals(that.dataCompletion) : that.dataCompletion == null;
    }

    @Override
    public int hashCode() {
        return dataCompletion != null ? dataCompletion.hashCode() : 0;
    }

    public BigDecimal getDataCompletion() {
        return dataCompletion;
    }

    public void setDataCompletion(BigDecimal dataCompletion) {
        this.dataCompletion = dataCompletion;
    }
}
