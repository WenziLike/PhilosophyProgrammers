package com.philosophyprogrammers.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "principle_groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;
    private String name;


    /**
     * ==================== Constructor
     */
    public GroupEntity() {
    }

    public GroupEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * ==================== Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity userGroup = (GroupEntity) o;
        return Objects.equals(id, userGroup.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToMany(mappedBy = "userGroups",fetch = EAGER)
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public void getId(Long id) {
        this.id = id;
    }
}
