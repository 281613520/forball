package com.xw.visitor.service;

import com.xw.visitor.entity.Module;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */

public interface ModuleService {
    void save(Module module);
    Module saveAndFlush(Module module);
    void delete(Module module);

    List<Module> findAll();

    Module findById(String moduleId);

    Module findByName(String name);
}
