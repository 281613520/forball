package com.xw.user.service;

import com.xw.user.entity.Admin;

/**
 * Created by AnKh on 2017/5/31.
 */
public interface AdminService {
    void save(Admin admin);

    Admin findById(String id);

    Admin findByUserName(String username);
}
