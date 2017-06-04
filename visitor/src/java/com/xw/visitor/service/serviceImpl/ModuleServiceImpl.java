package com.xw.visitor.service.serviceImpl;


import com.xw.visitor.dao.ModuleDao;
import com.xw.visitor.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ankh on 2017/6/4.
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleDao moduleDao;
}
