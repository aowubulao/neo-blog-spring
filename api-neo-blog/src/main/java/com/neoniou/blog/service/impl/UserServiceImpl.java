package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.UserDao;
import com.neoniou.blog.pojo.User;
import com.neoniou.blog.service.UserService;
import com.neoniou.blog.util.TokenUtil;
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

    @Override
    public User getBlogInfo() {
        return userDao.getBlogInfo();
    }

    @Override
    public Boolean authUser(User user, String token) {
        if (userDao.authUser(user) == 1 && token != null) {
            new TokenUtil().setToken(token);
            return true;
        } else {
            return false;
        }
    }
}
