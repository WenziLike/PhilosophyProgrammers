package com.philosophyprogrammers.modules.article;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleTitle {

    private String title;
    private String slug;

    public ArticleTitle() {
    }

    public ArticleTitle(String title, String slug) {
        this.title = title;
        this.slug = slug;
    }

    private static String slugFromTitle(String title) {
        return title.toLowerCase()
                .replaceAll("\\$,'\"|\\s|\\.|\\?", "-")
                .replaceAll("-{2,}", "-")
                .replaceAll("(^-)|(-$)", "");
    }

    public String getTitle() {
        return title;
    }

    public ArticleTitle setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public ArticleTitle setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    @Override
    public String toString() {
        return "ArticleTitle{" +
                "title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
