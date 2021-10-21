package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class Email {
    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Email setEmail(String email) {
        this.email = email;
        return this;
    }
}
