package com.philosophyprogrammers.entity;


import com.philosophyprogrammers.modules.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class PhilosophyProgrammersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;
    @Embedded
    private Profile profile;
    @Embedded
    private Password password;

    public PhilosophyProgrammersEntity() {
    }

    public PhilosophyProgrammersEntity(Long id, Email email, Profile profile, Password password) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public Password getPassword() {
        return password;
    }

    public UserName getName() {
        return profile.getUserName();
    }

//    public User getUser(){
//        return profile.getUserName().getUser();
//    }


    Image getImage() {
        return profile.getImage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhilosophyProgrammersEntity that = (PhilosophyProgrammersEntity) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
