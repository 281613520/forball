package com.xw.user.service.serviceImpl;

import com.xw.user.dao.AdminDao;
import com.xw.user.entity.Admin;
import com.xw.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by AnKh on 2017/5/31.
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public Admin findById(String id) {
        return adminDao.findOne(id);
    }

    @Override
    public Admin findByUserName(String username) {
        return adminDao.findAdminByUsername(username);
    }
}
