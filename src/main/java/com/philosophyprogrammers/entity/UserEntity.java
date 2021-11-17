package com.philosophyprogrammers.entity;

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
    private boolean active;
    private String token;
    private boolean accountVerified;
    private int failedLoginAttempts;
    private boolean loginDisabled;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<TokenEntity> tokens;

    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
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

    //=======================================
    public void addToken(TokenEntity token) {
        tokens.add(token);
    }
    //=======================================
}