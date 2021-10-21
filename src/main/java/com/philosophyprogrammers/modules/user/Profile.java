package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Profile {

    @Embedded
    private UserName userName;

    @Embedded
    private Image image;

    public Profile() {
    }

    public Profile(UserName userName, Image image) {
        this.userName = userName;
        this.image = image;
    }


    public UserName getUserName() {
        return userName;
    }

    public Profile setUserName(UserName userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName=" + userName +
                ", image=" + image +
                '}';
    }
}
