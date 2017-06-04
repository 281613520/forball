package com.xw.visitor.service.serviceImpl;


import com.xw.visitor.dao.ArticleDao;
import com.xw.visitor.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ankh on 2017/6/4.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
}
