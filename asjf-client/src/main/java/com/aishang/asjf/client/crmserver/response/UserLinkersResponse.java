package com.aishang.asjf.client.crmserver.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class UserLinkersResponse implements Serializable {

    private List<UserLinkerOutResponse> contacts;

    private boolean locked;

    private String relation;


    @Override
    public String toString() {
        return "UserLinkersResponse{" +
                "contacts=" + contacts +
                ", locked=" + locked +
                ", relation='" + relation + '\'' +
                '}';
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public List<UserLinkerOutResponse> getContacts() {
        return contacts;
    }

    public void setContacts(List<UserLinkerOutResponse> contacts) {
        this.contacts = contacts;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
