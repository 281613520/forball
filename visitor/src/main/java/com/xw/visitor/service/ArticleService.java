package com.xw.visitor.service;

import com.xw.commons.page.PageHelper;
import com.xw.visitor.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */

public interface ArticleService {
    void save(Article article);

    void delete(Article article);

    Article saveAndFlush(Article article);

    Article findById(String id);

    List<Article> findAll();

    List<Article> findAllForAdmin();

    //Page<Object> findByModuleAndInPage(PageHelper pageHelper,String moduleId);

    Page<Object> findByTagAndInPage(PageHelper pageHelper,String tagId);

    Page<Object> findByTagAndInPageForAdmin(PageHelper pageHelper,String tagId);


}
