package com.xw.user.dao;

import com.xw.user.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AnKh on 2017/5/31.
 */
public interface AdminDao extends JpaRepository<Admin,String>{
    Admin findAdminByUsername(String username);
}
