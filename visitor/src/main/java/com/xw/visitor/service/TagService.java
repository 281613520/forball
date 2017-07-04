package com.xw.visitor.service;

import com.xw.visitor.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */
public interface TagService {
    void save(Tag tag);
    Tag saveAndFlush(Tag tag);//todo 这个方法的作用？
    void delete(Tag tag);

    List<Tag> findByModuleId(String moduleId);
    List<Tag> findAll();

    Tag findByTagId(String tagId);
    Tag findByTagName(String tagName);

}
