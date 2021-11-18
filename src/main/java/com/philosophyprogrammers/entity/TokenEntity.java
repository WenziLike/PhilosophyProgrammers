package com.philosophyprogrammers.entity;

import lombok.Getter;
import lombok.Setter;
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

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Transient
    private boolean isExpired;

    // this is generic implementation, you can always make it timezone specific
    public boolean isExpired() {
        return getExpireAt().isBefore(LocalDateTime.now());
    }
}
