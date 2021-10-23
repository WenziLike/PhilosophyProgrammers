package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class UserName {

    private String username;
    private Boolean statusOnline;

    public UserName() {
    }

    public UserName(String username, Boolean statusOnline) {
        this.username = username;
        this.statusOnline = statusOnline;
    }

    public String getUsername() {
        return username;
    }

    public UserName setUsername(String username) {
        this.username = username;
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
                "username='" + username + '\'' +
                ", statusOnline=" + statusOnline +
                '}';
    }
}
