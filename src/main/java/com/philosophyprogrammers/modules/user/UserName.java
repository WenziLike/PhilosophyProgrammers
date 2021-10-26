package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class UserName {

    private String name;
    private Boolean statusOnline;

    public UserName() {
    }

    public UserName(String name, Boolean statusOnline) {
        this.name = name;
        this.statusOnline = statusOnline;
    }

    public String getName() {
        return name;
    }

    public UserName setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getStatusOnline() {
        return statusOnline;
    }

    public UserName setStatusOnline(Boolean statusOnline) {
        this.statusOnline = statusOnline;
        return this;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "username='" + name + '\'' +
                ", statusOnline=" + statusOnline +
                '}';
    }
}
