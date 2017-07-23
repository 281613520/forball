package com.xw.user.dao;

import com.xw.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AnKh on 2017/5/31.
 */
@Repository
public interface UserDao extends JpaRepository<User,String> {
    User findByUsername(String username);
}
