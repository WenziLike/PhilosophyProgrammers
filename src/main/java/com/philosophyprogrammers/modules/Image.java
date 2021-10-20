package com.philosophyprogrammers.modules;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Image {

    private String imgAddress;

    public Image() {
    }

    public Image(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    @Override
    public String toString() {
        return "Image{" +
                "address='" + imgAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(imgAddress, image.imgAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgAddress);
    }
}
