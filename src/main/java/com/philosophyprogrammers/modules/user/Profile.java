package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Profile {

    @Embedded
    private UserName userName;
    private String image;

    public Profile() {
    }

    public Profile(UserName userName, String image) {
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

    public String getImage() {
        return image;
    }

    public Profile setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName=" + userName +
                ", image='" + image + '\'' +
                '}';
    }
}
