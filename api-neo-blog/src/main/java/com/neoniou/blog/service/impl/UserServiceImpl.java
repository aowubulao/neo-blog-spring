package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.UserDao;
import com.neoniou.blog.pojo.User;
import com.neoniou.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author neo.zzj
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfo() {
        return userDao.getUserInfo();
    }
}
