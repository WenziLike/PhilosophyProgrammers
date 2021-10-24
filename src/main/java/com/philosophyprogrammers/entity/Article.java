package com.philosophyprogrammers.entity;

import com.philosophyprogrammers.modules.article.ArticleContents;
import com.philosophyprogrammers.modules.article.ArticleTitle;
import com.philosophyprogrammers.modules.user.UserName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ArticleContents contents;

    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = EAGER)
    private User author;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    public Article() {
    }

    public Article(ArticleContents contents, User author) {
        this.contents = contents;
        this.author = author;
    }
    //==========================================

    /**
     * todo как лучше получить в Html
     */
    public ArticleTitle getContentsTitle() {
        return contents.getTitle();
    }

    public String getContentsDescription() {
        return contents.getDescription();
    }

    public String getContentsBody() {
        return contents.getBody();
    }

    public Article setContentsTitle(ArticleTitle title) {
//        return contents.setTitle(title);
        this.contents.setTitle(title);
        return this;
    }

    public Article setContentsDescription(String description) {
        this.contents.setDescription(description);
        return this;
    }

    public Article setContentsBody(String body) {
        this.contents.setBody(body);
        return this;
    }
    //==========================================

    public Long getId() {
        return id;
    }

    public Article setId(Long id) {
        this.id = id;
        return this;
    }

    public ArticleContents getContents() {
        return contents;
    }

    public Article setContents(ArticleContents contents) {
        this.contents = contents;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Article setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Article setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Article setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", contents=" + contents +
                ", author=" + author +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
