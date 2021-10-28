package com.philosophyprogrammers.entity;

import com.philosophyprogrammers.modules.user.Profile;

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
    private String email;
    private String password;
    private String matchingPassword;
    private boolean active;

    @Embedded
    private Profile profile;

    /**
     * ================ Constructor
     */
    public User() {
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                String matchingPassword,
                boolean active,
                Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.active = active;
        this.profile = profile;
    }

    public User(Long id,
                String firstName,
                String lastName,
                String email,
                String password,
                String matchingPassword,
                boolean active,
                Profile profile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.active = active;
        this.profile = profile;
    }

    /**
     * ================ Getters and Setters
     */
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

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public User setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Profile getProfile() {
        return profile;
    }

    public User setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    //==========================================

    //==========================================
//    public String userProfile() {
//        return firstName + lastName + profile.getUsername() +
//                profile.getImage() + email;
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", active=" + active +
                ", profile=" + profile +
                '}';
    }
}