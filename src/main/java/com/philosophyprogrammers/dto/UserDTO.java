package com.philosophyprogrammers.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

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
