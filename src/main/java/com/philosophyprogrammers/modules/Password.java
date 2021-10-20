package com.philosophyprogrammers.modules;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Password {
    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }
}
