package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.Article;
import com.philosophyprogrammers.service.articles.ArticleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    private ArticleServiceImpl articleServiceImpl;

    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping
    public String articles(ModelMap modelMap) {
        List<Article> articles = articleServiceImpl.getAll();
        modelMap.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/newPost")
    public String showNewFormPost(Article article, ModelMap modelMap) {
        modelMap.addAttribute("article", article);
        return "newPost";
    }

    @PostMapping("/newPost")
    public String createdNewArticle(@ModelAttribute("article") Article article) {
        articleServiceImpl.createdNewArticle(article);
        return "redirect:/index";
    }

//    ================================================

    @GetMapping("/edit/article/{id}")
    public String showUpdateFormArticle(
            @PathVariable("id") long id,
            ModelMap modelMap) {
        Article article = articleServiceImpl.findById(id)
                .orElseThrow();

        modelMap.addAttribute("article", article);
        return "edit-article";
    }

    @PostMapping("/edit/article/{id}")
    public String updateArticle(
            @PathVariable(value = "id") long id,
            @ModelAttribute("article") Article article) {
        Article articleFromDb = articleServiceImpl.findById(id).orElseThrow();

        articleFromDb.setContentsTitle(article.getContentsTitle());
        articleFromDb.setContentsDescription(article.getContentsDescription());
        articleFromDb.setContentsBody(article.getContentsBody());
//        user.setLastName(user.getLastName());
//
        articleServiceImpl.createdNewArticle(article);

//        userServiceImpl.editUser(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/article/{id}")
    public String deleteArticle(@PathVariable("id") long id) {
        Article article = articleServiceImpl.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        articleServiceImpl.deleteArticle(article);
        return "redirect:/index";
    }
}
