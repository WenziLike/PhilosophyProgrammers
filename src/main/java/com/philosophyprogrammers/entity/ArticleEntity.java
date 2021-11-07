package com.philosophyprogrammers.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Simple JavaBean domain object that represents an Article.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String body;
    private String tag;

    private LocalDateTime created;
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity author;

    /**
     * ================ Constructor
     */
    public ArticleEntity() {
    }

    public ArticleEntity(String title,
                         String description,
                         String body,
                         String tag,
                         LocalDateTime created,
                         LocalDateTime modified,
                         UserEntity author) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.tag = tag;
        this.created = created;
        this.modified = modified;
        this.author = author;
    }

    /**
     * ================ Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", tag='" + tag + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", author=" + author +
                '}';
    }
}
