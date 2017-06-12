package com.xw.visitor.controller;

import com.xw.commons.response.ReponseTemplate;
import com.xw.commons.response.StatusCode;
import com.xw.visitor.entity.Module;
import com.xw.visitor.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ankh on 2017/6/9.
 */
@Slf4j
@RestController(value = "/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    //新增，删除，查找

    @GetMapping(value = "/all")
    public Object findAllModules(){
        return new ReponseTemplate(moduleService.findAll());
    }

    @PostMapping(value = "/new")
    public Object addModule(final Module module){
        log.debug("module = {}.",module);

        if (!isModuleValid(module)){
            log.error("module = {}.",module);
            throw new RuntimeException();//Exception("ttt");//TODO
        }
        moduleService.save(module);

        return new ReponseTemplate(StatusCode.SUCCESS);
    }

    private boolean isModuleValid(final Module module) {
        if(!StringUtils.hasText(module.getName())){
            return false;
        }
        return true;
    }

}
