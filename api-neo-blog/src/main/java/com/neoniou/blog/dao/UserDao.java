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

    /**
     * 获取 blog 相关信息
     *
     * @return blog name, subName, description
     */
    @Select("select url, blog_name, blog_sub_name, blog_description from nb_user where user_id = 1")
    User getBlogInfo();

    /**
     * 认证用户
     *
     * @param user User
     * @return num
     */
    @Select("select count(user_id) from nb_user where username = #{username} and password= #{password}")
    int authUser(User user);
}
