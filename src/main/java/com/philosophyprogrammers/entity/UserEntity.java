package com.philosophyprogrammers.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String image;
    @Column(unique = true)
    private String email;
    private String password;

    @Transient
    private String confirmPassword;
    private boolean active;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;

    /**
     * ================ Constructor
     */
    public UserEntity() {
    }

    public UserEntity(String firstName,
                      String lastName,
                      String username,
                      String image,
                      String email,
                      String password,
                      String confirmPassword,
                      boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.image = image;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.active = active;
    }

    /**
     * ================ Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getImage() {
        return image;
    }

    public UserEntity setImage(String image) {
        this.image = image;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserEntity setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserEntity setActive(boolean active) {
        this.active = active;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
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