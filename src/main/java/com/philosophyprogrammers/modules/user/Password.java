package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class Password {
    private String password;
    private String matchingPassword;

    public Password() {
    }

    public Password(String password, String matchingPassword) {
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getPassword() {
        return password;
    }

    public Password setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public Password setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }

    @Override
    public String toString() {
        return "Password{" +
                "password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                '}';
    }
}
