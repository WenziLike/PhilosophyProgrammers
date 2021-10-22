package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.Article;
import com.philosophyprogrammers.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleControllers {

    private  ArticleService articleService;


    public ArticleControllers(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public String home(ModelMap modelMap) {
        List<Article> articles = articleService.getAllArticles();
        modelMap.addAttribute("articles", articles);
        return "home";
    }
}
