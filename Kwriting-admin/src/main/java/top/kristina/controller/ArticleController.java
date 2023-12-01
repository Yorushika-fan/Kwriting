package top.kristina.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kristina.model.entry.Article;
import top.kristina.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
/**
 * 文章
 */
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/list")
    public List<Article>  list() {
        return articleService.list();
    }

    @PostMapping()
    public void add() {
//        articleService.add();
    }



}
