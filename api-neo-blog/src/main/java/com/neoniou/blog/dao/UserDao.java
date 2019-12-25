package com.neoniou.blog.dao;

import com.neoniou.blog.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author neo.zzj
 */
@Repository
public interface UserDao extends Mapper<User> {

    /**
     * 获取 blog 用户信息
     * @return User info
     */
    @Select("select username, user_email, url, blog_name, blog_sub_name, blog_description from nb_user where user_id = 1")
    User getUserInfo();
}
