package com.philosophyprogrammers.modules;

import javax.persistence.*;

@Embeddable
public class UserSignUp {
    @Embedded
    private User user;
    @Embedded
    private UserName userName;
    @Embedded
    private Email email;
    private  String rawPassword;

    public UserSignUp() {
    }

    public UserSignUp(User user,
                      UserName userName,
                      Email email,
                      String rawPassword) {
        this.user = user;
        this.userName = userName;
        this.email = email;
        this.rawPassword = rawPassword;
    }

    public User getUser() {
        return user;
    }

    public UserName getUserName() {
        return userName;
    }

    public Email getEmail() {
        return email;
    }

    public String getRawPassword() {
        return rawPassword;
    }
}
