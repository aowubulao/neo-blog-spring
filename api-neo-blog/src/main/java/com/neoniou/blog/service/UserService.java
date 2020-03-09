package com.neoniou.blog.service;

import com.neoniou.blog.pojo.User;

/**
 * @author neo.zzj
 */
public interface UserService {

    /**
     * 获取 blog 用户信息
     * @return User info
     */
    User getUserInfo();

    /**
     * 获取 blog 相关信息
     *
     * @return blog name, subName, description
     */
    User getBlogInfo();
}
