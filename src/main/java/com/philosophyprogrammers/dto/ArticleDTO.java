package com.philosophyprogrammers.dto;

import com.philosophyprogrammers.entity.UserEntity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * For configurable messages and internationalization.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

public class ArticleDTO implements Serializable {

    @NotEmpty(message = "Title can not be empty!!!")
    private String title;
    @NotEmpty(message = "Description can not be empty!!!")
    private String description;
    @NotEmpty(message = "Text box can not be empty!!!")
    private String body;
    @NotEmpty(message = "Specify tag, can not be empty!!!")
    private String tag;
    private LocalDateTime created;
    private LocalDateTime modified;
    private UserEntity author;

    public String getTitle() {
        return title;
    }

    public ArticleDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBody() {
        return body;
    }

    public ArticleDTO setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public ArticleDTO setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public ArticleDTO setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public ArticleDTO setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public ArticleDTO setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", tag='" + tag + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", author=" + author +
                '}';
    }
}
