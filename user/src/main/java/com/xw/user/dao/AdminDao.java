package com.xw.user.dao;

import com.xw.user.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnKh on 2017/5/31.
 */
@Repository
public interface AdminDao extends JpaRepository<Admin,String>{
    Admin findAdminByUsername(String username);
}
