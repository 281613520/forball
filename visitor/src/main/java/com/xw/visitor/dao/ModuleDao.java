package com.xw.visitor.dao;


import com.xw.visitor.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ankh on 2017/6/4.
 */
public interface ModuleDao extends JpaRepository<Module,String>{
    Module findByName(final String name);
}
