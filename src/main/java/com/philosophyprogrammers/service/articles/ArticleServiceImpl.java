package com.philosophyprogrammers.service.articles;

import com.philosophyprogrammers.entity.Article;
import com.philosophyprogrammers.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createdNewArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.deleteById(article.getId());
    }
}
