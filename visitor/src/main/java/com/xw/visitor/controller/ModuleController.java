package com.xw.visitor.controller;

import com.xw.visitor.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ankh on 2017/6/9.
 */
@RestController
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    //新增，删除，查找
}
