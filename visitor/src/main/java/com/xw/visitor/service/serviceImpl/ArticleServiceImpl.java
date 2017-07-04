package com.xw.visitor.service.serviceImpl;


import com.xw.commons.page.PageHelper;
import com.xw.visitor.dao.ArticleDao;
import com.xw.visitor.entity.Article;
import com.xw.visitor.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public void delete(Article article) {
        articleDao.delete(article);
    }

    @Override
    public Article saveAndFlush(Article article) {
        return articleDao.saveAndFlush(article);
    }

    @Override
    public Article findById(String id) {
        return articleDao.findOne(id);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findByDelete(false);
    }

    @Override
    public List<Article> findAllForAdmin() {
        return articleDao.findAll();
    }

    @Override
    public Page<Object> findByModuleAndInPage(PageHelper pageHelper, String moduleId) {
        //return articleDao.findByTagIdAndInPage(pageHelper,);
        return null;
    }

    @Override
    public Page<Object> findByTagAndInPage(PageHelper pageHelper, String tagId) {
        return articleDao.findByTagIdAndInPage(pageHelper,tagId,false);
    }
}
