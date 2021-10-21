package com.philosophyprogrammers.modules.user;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

    private String imgProfile;

    public Image() {
    }

    public Image(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public Image setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
        return this;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imgProfile='" + imgProfile + '\'' +
                '}';
    }
}