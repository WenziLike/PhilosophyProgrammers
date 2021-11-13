package com.philosophyprogrammers.dto;

import com.philosophyprogrammers.entity.UserEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(min = 6, max = 42, message = "Title must contain min 6 to max 42")
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

    /**
     * ============ Constructor
     */

    public ArticleDTO() {
    }

    public ArticleDTO(
            String title,
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
     * ============ Getters and Setters
     */

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
