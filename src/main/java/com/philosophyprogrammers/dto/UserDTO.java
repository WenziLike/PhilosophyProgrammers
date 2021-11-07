package com.philosophyprogrammers.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * For configurable messages and internationalization.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

public class UserDTO implements Serializable {

    @NotEmpty(message = "First Name can not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name can not be empty")
    private String lastName;
    @NotEmpty(message = "Username can not be empty")
    private String username;
    private String image;

    @Email(message = "Please provide a valid email id")
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;
    @NotEmpty(message = "Password can not be empty")
    private String confirmPassword;
    private boolean active;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", active=" + active +
                '}';
    }
}
