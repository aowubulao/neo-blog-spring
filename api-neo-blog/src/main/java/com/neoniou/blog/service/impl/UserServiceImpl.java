package com.neoniou.blog.service.impl;

import com.neoniou.blog.common.ILocalCache;
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
        if (ILocalCache.isExist(ILocalCache.BLOG_INFO)) {
            return (User) ILocalCache.get(ILocalCache.BLOG_INFO);
        } else {
            User blogInfo = userDao.getBlogInfo();
            ILocalCache.add(ILocalCache.BLOG_INFO, blogInfo);
            return blogInfo;
        }
    }

    @Override
    public Boolean authUser(User user, String token) {
        if (userDao.authUser(user) == 1 && new TokenUtil().checkToken(token)) {
            new TokenUtil().setToken(token);
            return true;
        } else {
            return false;
        }
    }
}
