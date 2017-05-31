package com.xw.user.service.serviceImpl;

import com.xw.user.dao.UserDao;
import com.xw.user.entity.User;
import com.xw.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by AnKh on 2017/5/31.
 */
public class UserSerivceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findOne(id);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUsername(username);
    }
}
