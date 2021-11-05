package com.philosophyprogrammers.service.article;


import com.philosophyprogrammers.dto.ArticleDTO;
import com.philosophyprogrammers.entity.ArticleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for {@link ArticleEntity}
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Service
public interface ArticleService {
    void createArticlePost(ArticleDTO articleDTO);

    List<ArticleEntity> getAllArticlesPosts();
}
