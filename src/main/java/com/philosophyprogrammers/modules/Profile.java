package com.philosophyprogrammers.modules;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

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

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName=" + userName +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return userName.equals(profile.userName) && image.equals(profile.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, image);
    }
}
