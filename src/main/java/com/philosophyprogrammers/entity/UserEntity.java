package com.philosophyprogrammers.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Getter
@Setter
@EqualsAndHashCode
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
    private String confirmPassword;
    private boolean accountVerified;
    private boolean active;
    private String token;
    private int failedLoginAttempts;
    private boolean loginDisabled;

    @OneToMany(mappedBy = "user")
    private Set<TokenEntity> tokens;

    //=======================================
    public void addToken(TokenEntity token) {
        tokens.add(token);
    }
    //=======================================
}