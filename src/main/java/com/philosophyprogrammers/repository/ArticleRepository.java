package com.philosophyprogrammers.repository;

import com.philosophyprogrammers.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article save(Article article);
}