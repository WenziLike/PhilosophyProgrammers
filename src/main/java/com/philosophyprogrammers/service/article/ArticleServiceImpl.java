package com.philosophyprogrammers.service.article;

import com.philosophyprogrammers.dto.ArticleDTO;
import com.philosophyprogrammers.entity.ArticleEntity;
import com.philosophyprogrammers.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void createArticlePost(ArticleDTO articleDTO) {

        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(articleDTO, articleEntity);
        articleRepository.save(articleEntity);
    }

    @Override
    public List<ArticleEntity> getAllArticlesPosts() {
        return articleRepository.findAll();
    }
}
