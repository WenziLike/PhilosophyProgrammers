package com.philosophyprogrammers.modules.article;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ArticleContents {
    @Embedded
    private ArticleTitle title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String body;


    public ArticleContents() {
    }

    public ArticleContents(ArticleTitle title, String description, String body) {
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public ArticleTitle getTitle() {
        return title;
    }

    public ArticleContents setTitle(ArticleTitle title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleContents setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBody() {
        return body;
    }

    public ArticleContents setBody(String body) {
        this.body = body;
        return this;
    }
}
