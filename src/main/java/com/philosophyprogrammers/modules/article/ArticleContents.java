package com.philosophyprogrammers.modules.article;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ArticleContents {
    @Embedded
    private ArticleTitle articleTitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String body;


    public ArticleContents() {
    }

    public ArticleContents(ArticleTitle articleTitle, String description, String body) {
        this.articleTitle = articleTitle;
        this.description = description;
        this.body = body;
    }

    public ArticleTitle getArticleTitle() {
        return articleTitle;
    }

    public ArticleContents setArticleTitle(ArticleTitle articleTitle) {
        this.articleTitle = articleTitle;
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

    @Override
    public String toString() {
        return "ArticleContents{" +
                "title=" + articleTitle +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
