package com.philosophyprogrammers.service.articles;

import com.philosophyprogrammers.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {
    Article createdNewArticle(Article article);

    List<Article> getAll();

    Optional<Article> findById(long id);

    void deleteArticle(Article article);
}
