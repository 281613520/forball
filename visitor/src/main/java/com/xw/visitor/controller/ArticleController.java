package com.xw.visitor.controller;

import com.xw.commons.page.PageHelper;
import com.xw.commons.response.ReponseTemplate;
import com.xw.commons.response.StatusCode;
import com.xw.visitor.entity.Article;
import com.xw.visitor.entity.Tag;
import com.xw.visitor.service.ArticleService;
import com.xw.visitor.service.ModuleService;
import com.xw.visitor.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


/**
 * Created by Ankh on 2017/6/9.
 */
@RestController
@Slf4j
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    TagService tagService;

    //新增
    @PostMapping(value = "/admin/article/new")
    public Object saveArticle(Article article){
        //todo 校验
        articleService.save(article);
        return new ReponseTemplate(StatusCode.SUCCESS);
    }

    //删除
    @DeleteMapping(value = "/admin/article/delete")
    public Object deleteArticle(@PathParam("id") String id,@PathParam("status") String status){
        //todo check

        Article article = articleService.findById(id);
        if (article == null){

        }

        if ("true".equals(status)){
            Tag tag = tagService.findByTagId(article.getTagId());
            tag.setArticleNum(tag.getArticleNum() - 1);
            tagService.save(tag);
            article.setDelete(true);
        }

        articleService.delete(article);
        return new ReponseTemplate(StatusCode.SUCCESS);
    }

    //查找
    @GetMapping(value = "/article/find")
    public Object findArticle(@PathParam("id") String id){
        Article article = articleService.findById(id);

        return new ReponseTemplate(article);
    }

    //按照tag分页查找,for visitor
    @GetMapping(value = "/visitor/tag/{tagId}/article")
    public Object findArtilcesByTagInPage(@PathVariable("tagId") String tagId,
                                  @RequestParam(value = "page" , required = false ,defaultValue = "1")int page ,
                                  @RequestParam(value = "size", required = false , defaultValue = "20") int size){
        return new ReponseTemplate(articleService.findByTagAndInPage(new PageHelper(size,page),tagId).getContent());
    }

    //for admin
    @GetMapping(value = "/admin/tag/{tagId}/article")
    public Object findArticlesByTagInPageForAdmin(@PathVariable("tagId") String tagId,
                                  @RequestParam(value = "page" , required = false ,defaultValue = "1")int page ,
                                  @RequestParam(value = "size", required = false , defaultValue = "20") int size){
        return new ReponseTemplate(articleService.findByTagAndInPage(new PageHelper(size,page),tagId).getContent());
    }
}
