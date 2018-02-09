package com.aishang.asjf.client.mallserver.response;

import java.io.Serializable;

/**
 * Created by mx on 17-12-11.
 */
public class MustImeiResponse implements Serializable {
    private String required;//0.否1，是

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MustImeiResponse that = (MustImeiResponse) o;

        return required != null ? required.equals(that.required) : that.required == null;
    }

    @Override
    public int hashCode() {
        return required != null ? required.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MustImeiResponse{" +
                "required='" + required + '\'' +
                '}';
    }
}
