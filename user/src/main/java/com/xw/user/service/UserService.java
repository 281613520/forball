package com.xw.user.service;

import com.xw.user.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by AnKh on 2017/5/31.
 */
@Service
public interface UserService {
    void save(User user);

    User findById(String id);

    User findByUserName(String username);
}
