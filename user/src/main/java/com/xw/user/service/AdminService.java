package com.xw.user.service;

import com.xw.user.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by AnKh on 2017/5/31.
 */
@Service
public interface AdminService {
    void save(Admin admin);

    Admin findById(String id);

    Admin findByUserName(String username);
}
