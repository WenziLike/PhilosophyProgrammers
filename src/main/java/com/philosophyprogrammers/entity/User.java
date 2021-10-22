package com.philosophyprogrammers.entity;

import com.philosophyprogrammers.modules.user.Email;
import com.philosophyprogrammers.modules.user.Password;
import com.philosophyprogrammers.modules.user.Profile;
import com.philosophyprogrammers.modules.user.UserName;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name = "user_account")
public class User {


    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Embedded
    private Email email;
    @Embedded
    private Password password;


    @Embedded
    private Profile profile;

    public User() {
    }

    public User(String firstName, String lastName, Email email, Password password, Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    /**
     * todo как лучше получить в Html
     */
    public UserName getUserName() {
        return profile.getUserName();
    }

    //==========================================


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public User setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Password getPassword() {
        return password;
    }

    public User setPassword(Password password) {
        this.password = password;
        return this;
    }

    public Profile getProfile() {
        return profile;
    }

    public User setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", profile=" + profile +
                '}';
    }
}