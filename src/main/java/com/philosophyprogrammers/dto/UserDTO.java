package com.philosophyprogrammers.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserDTO implements Serializable {

    @NotEmpty(message = "No first name")
    private String firstName;

    @NotEmpty(message = "{registration.validation.lastname}")
    private String lastName;

    @NotEmpty(message = "{validation.username}")
    private String username;

    private String image;

    //    @Email(message = "NNOOO")
    @Email(message = "please provide a valid email id")
    private String email;

    @NotEmpty(message = "{registration.validation.password}")
    private String password;
    private String confirmPassword;
    private boolean active;


    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getImage() {
        return image;
    }

    public UserDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserDTO setActive(boolean active) {
        this.active = active;
        return this;
    }
}
