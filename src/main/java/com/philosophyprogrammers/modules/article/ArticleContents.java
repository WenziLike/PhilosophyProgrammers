package com.philosophyprogrammers.modules.article;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ArticleContents {
    @Embedded
    private ArticleTitle value;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String body;


    public ArticleContents() {
    }

    public ArticleContents(ArticleTitle value, String description, String body) {
        this.value = value;
        this.description = description;
        this.body = body;
    }

    public ArticleTitle getValue() {
        return value;
    }

    public ArticleContents setValue(ArticleTitle value) {
        this.value = value;
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
                "title=" + value +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
