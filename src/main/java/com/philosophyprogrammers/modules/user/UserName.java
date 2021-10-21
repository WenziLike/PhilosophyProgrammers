package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class UserName {

    private String username;

    @Embedded
    private StatusOnline statusOnline;

    public UserName() {
    }

    public UserName(String username, StatusOnline statusOnline) {
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

    public StatusOnline getStatusOnline() {
        return statusOnline;
    }

    public UserName setStatusOnline(StatusOnline statusOnline) {
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
