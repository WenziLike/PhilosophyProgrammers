package com.philosophyprogrammers.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private String token;
    private boolean accountVerified;
    private int failedLoginAttempts;
    private boolean loginDisabled;

    @OneToMany(mappedBy = "user")
    private Set<TokenEntity> tokens;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"
            ))
    private Set<GroupEntity> userGroups = new HashSet<>();

    public void addUserGroups(GroupEntity group) {
        userGroups.add(group);
        group.getUsers().add(this);
    }

    public void removeUserGroups(GroupEntity group) {
        userGroups.remove(group);
        group.getUsers().remove(this);
    }

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
                      boolean active,
                      String token,
                      boolean accountVerified,
                      int failedLoginAttempts,
                      boolean loginDisabled,
                      Set<TokenEntity> tokens,
                      Set<GroupEntity> userGroups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.image = image;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.active = active;
        this.token = token;
        this.accountVerified = accountVerified;
        this.failedLoginAttempts = failedLoginAttempts;
        this.loginDisabled = loginDisabled;
        this.tokens = tokens;
        this.userGroups = userGroups;
    }

    /**
     * ================ Getters and Setters
     */

    public Long getId() {
        return id;
    }

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAccountVerified() {
        return accountVerified;
    }

    public void setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public boolean isLoginDisabled() {
        return loginDisabled;
    }

    public void setLoginDisabled(boolean loginDisabled) {
        this.loginDisabled = loginDisabled;
    }

    public Set<TokenEntity> getTokens() {
        return tokens;
    }

    public void setTokens(Set<TokenEntity> tokens) {
        this.tokens = tokens;
    }

    public Set<GroupEntity> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<GroupEntity> userGroups) {
        this.userGroups = userGroups;
    }

    //=======================================
    public void addToken(TokenEntity token) {
        tokens.add(token);
    }
    //=======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
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
                ", token='" + token + '\'' +
                ", accountVerified=" + accountVerified +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", loginDisabled=" + loginDisabled +
                ", tokens=" + tokens +
                ", userGroups=" + userGroups +
                '}';
    }
}