package com.aishang.asjf.client.crmserver.response;

import com.aishang.asjf.client.base.CilentBaseResponse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class UserProfileCompleteResponse extends CilentBaseResponse {

    private List<Data> userProfileComplete;



    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<Data> getUserProfileComplete() {
        return userProfileComplete;
    }

    public void setUserProfileComplete(List<Data> userProfileComplete) {
        this.userProfileComplete = userProfileComplete;
    }

    public static class Data implements Serializable{
        private String step;

        private int value;

        private boolean completed;

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfileCompleteResponse that = (UserProfileCompleteResponse) o;

        if (userProfileComplete != null ? !userProfileComplete.equals(that.userProfileComplete) : that.userProfileComplete != null)
            return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = userProfileComplete != null ? userProfileComplete.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "UserProfileCompleteResponse{" +
                "userProfileComplete=" + userProfileComplete +
                ", result=" + result +
                '}';
    }
}
