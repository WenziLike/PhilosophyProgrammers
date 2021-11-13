package com.philosophyprogrammers.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Simple JavaBean domain object that represents an TokenEntity.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Entity
@Table(name = "secure_tokens")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String token;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp timeStamp;

    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Transient
    private boolean isExpired;

    /**
     * ==================== Constructor
     */

    public TokenEntity() {
    }

    public TokenEntity(String token,
                       Timestamp timeStamp,
                       LocalDateTime expireAt,
                       UserEntity user,
                       boolean isExpired) {
        this.token = token;
        this.timeStamp = timeStamp;
        this.expireAt = expireAt;
        this.user = user;
        this.isExpired = isExpired;
    }

    /**
     * ==================== Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    // this is generic implementation, you can always make it timezone specific
    public boolean isExpired() {
        return getExpireAt().isBefore(LocalDateTime.now());
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return "TokenEntity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", timeStamp=" + timeStamp +
                ", expireAt=" + expireAt +
                ", user=" + user +
                ", isExpired=" + isExpired +
                '}';
    }
}
