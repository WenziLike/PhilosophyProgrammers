package com.philosophyprogrammers.modules;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class UserName {

    private String username;
    @Embedded
    private User user;

    @Embedded
    private StatusOnline statusOnline;

    public UserName() {
    }

    public UserName(String username, User user, StatusOnline statusOnline) {
        this.username = username;
        this.user = user;
        this.statusOnline = statusOnline;
    }

    public String getUsername() {
        return username;
    }

    public UserName setUsername(String username) {
        this.username = username;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserName setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(username, userName.username) && Objects.equals(statusOnline, userName.statusOnline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, statusOnline);
    }
}
