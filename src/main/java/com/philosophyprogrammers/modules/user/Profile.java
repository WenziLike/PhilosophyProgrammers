package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {

    private String username;
    private String image;

    public Profile() {
    }

    public Profile(String username, String image) {
        this.username = username;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public Profile setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Profile setImage(String image) {
        this.image = image;
        return this;
    }
}
