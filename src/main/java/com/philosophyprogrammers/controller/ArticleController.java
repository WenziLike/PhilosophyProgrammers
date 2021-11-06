package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.dto.ArticleDTO;
import com.philosophyprogrammers.entity.ArticleEntity;
import com.philosophyprogrammers.service.article.ArticleServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Article Controller class for {@link ArticleEntity}
 * show articles posts and created new article post
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Controller
public class ArticleController {

    private ArticleServiceImpl articleServiceImpl;
    private static final String REDIRECT_INDEX = "redirect:/";

    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping("/write")
    public String showWriteForm(ModelMap modelMap) {
        modelMap.addAttribute("articleDTO", new ArticleDTO());
        return "accountApp/writeForm";
    }


    @PostMapping("/write")
    public String createPost(@Valid ArticleDTO articleDTO,
                             BindingResult bindingResult,
                             ModelMap modelMap) {

//        if (articleDTO.getTitle() != null
//                && articleDTO.getDescription() != null
//                && articleDTO.getBody() != null) {
//            bindingResult.rejectValue("errors", "errors", "All fields must be filled");
//            modelMap.addAttribute("articleDTO", articleDTO);
//            return "accountApp/writeForm";
//        }

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("articleDTO", articleDTO);
            return "accountApp/writeForm";
        }


        //todo you can create a method........
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);  //2019-03-28 14:47:33 PM
        LocalDateTime localTimeObj = LocalDateTime.parse(dateTimeString, formatter);
        //====================================================

        articleDTO.setCreated(localTimeObj);
        articleServiceImpl.createArticlePost(articleDTO);
        return REDIRECT_INDEX;
    }

    @GetMapping("/")
    public String allArticlesPost(ModelMap modelMap) {
        modelMap.addAttribute("articles",
                articleServiceImpl.getAllArticlesPosts());
        return "index";
    }

}
