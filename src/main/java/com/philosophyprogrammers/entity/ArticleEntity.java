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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
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

    public ArticleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBody() {
        return body;
    }

    public ArticleEntity setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public ArticleEntity setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public ArticleEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public ArticleEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public ArticleEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
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
