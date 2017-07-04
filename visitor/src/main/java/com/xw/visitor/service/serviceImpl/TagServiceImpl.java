package com.xw.visitor.service.serviceImpl;


import com.xw.visitor.dao.TagDao;
import com.xw.visitor.entity.Tag;
import com.xw.visitor.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public void save(Tag tag) {
        tagDao.save(tag);
    }

    @Override
    public Tag saveAndFlush(Tag tag) {
        return tagDao.saveAndFlush(tag);
    }

    @Override
    public void delete(Tag tag) {
        tag.setDelete(true);
        this.save(tag);
    }

    @Override
    public List<Tag> findByModuleId(String moduleId) {
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Tag findByTagId(String tagId) {
        return tagDao.findOne(tagId);
    }

    @Override
    public Tag findByTagName(String tagName) {
        return tagDao.findByName(tagName);
    }
}
