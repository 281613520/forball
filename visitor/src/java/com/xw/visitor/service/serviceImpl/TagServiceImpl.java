package com.xw.visitor.service.serviceImpl;


import com.xw.visitor.dao.TagDao;
import com.xw.visitor.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ankh on 2017/6/4.
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
}
