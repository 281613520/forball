package com.xw.visitor.controller;

import com.xw.commons.response.ReponseTemplate;
import com.xw.commons.response.StatusCode;
import com.xw.visitor.entity.Tag;
import com.xw.visitor.service.ModuleService;
import com.xw.visitor.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ankh on 2017/6/9.
 */
@Slf4j
@RestController(value = "/tag")
public class TagController {
    @Autowired
    TagService tagService;
    @Autowired
    ModuleService moduleService;

    @PostMapping(value = "/new")
    public Object addTag(Tag tag){
        if (!isTagValid(tag)){

        }

        tagService.save(tag);
        return new ReponseTemplate(StatusCode.SUCCESS);
    }

    private boolean isTagValid(final Tag tag) {
        if(tag == null){
            return false;
        }
        if(!StringUtils.hasText(tag.)) {
            return false;
        }
        if(!StringUtils.hasText(tag.getModuleId())) {
            return false;
        }
        return moduleService.findById(tag.getModuleId()) != null;
    }
}
