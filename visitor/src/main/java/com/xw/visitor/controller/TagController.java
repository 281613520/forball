package com.xw.visitor.controller;

import com.xw.commons.exception.ParamErrorException;
import com.xw.commons.response.ReponseTemplate;
import com.xw.commons.response.StatusCode;
import com.xw.visitor.entity.Tag;
import com.xw.visitor.service.ModuleService;
import com.xw.visitor.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Ankh on 2017/6/9.
 */
@Slf4j
@RestController
public class TagController {

    @Autowired
    TagService tagService;
    @Autowired
    ModuleService moduleService;

    @PostMapping(value = "/admin/tag/new")
    public Object addTag(Tag tag){
        if (!isTagValid(tag)){
            log.error("tag = {}",tag);
            throw new ParamErrorException("tag param is error");
        }

        tagService.save(tag);
        return new ReponseTemplate(StatusCode.SUCCESS);
    }

    @DeleteMapping(value = "/tag/{id}")
    public Object deleteTagById(@PathParam("id") String id,@PathParam("status") String status){
        log.debug("id = {} , status = {}",id,status);

        Tag tag = tagService.findByTagId(id);

        if(0 != tag.getArticleNum()){

        }else {
           tag.setDelete(true);
        }

        tagService.save(tag);


        return null;
    }

    @GetMapping(value = "/tag/all")
    public Object findAllTags(){
        List<Tag> tagList = tagService.findAll();

        tagList.parallelStream().forEach(tag ->
        {tag.setModule(moduleService.findById(tag.getModuleId()));});

        return new ReponseTemplate<List<Tag>>(tagList);
    }

    private boolean isTagValid(final Tag tag) {
        if(tag == null){
            return false;
        }
        if(!StringUtils.hasText(tag.getName())){
            return false;
        }

        if(!StringUtils.hasText(tag.getModuleId())) {
            return false;
        }
        return moduleService.findById(tag.getModuleId()) != null;
    }
}
