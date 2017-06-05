package com.xw.visitor.service.serviceImpl;


import com.xw.visitor.dao.ModuleDao;
import com.xw.visitor.entity.Module;
import com.xw.visitor.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ankh on 2017/6/4.
 */

public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleDao moduleDao;

    @Override
    public void save(Module module) {
        moduleDao.save(module);
    }

    @Override
    public Module saveAndFlush(Module module) {
        return moduleDao.saveAndFlush(module);
    }

    @Override
    public void delete(Module module) {
        module.setDelete(false);
        this.save(module);
    }

    @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }

    @Override
    public Module findById(String moduleId) {
        return moduleDao.findOne(moduleId);
    }

    @Override
    public Module findByName(String name) {
        return moduleDao.findByName(name);
    }
}
