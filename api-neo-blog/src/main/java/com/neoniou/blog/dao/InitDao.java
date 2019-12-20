package com.neoniou.blog.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 初始化博客数据库dao接口
 * Init blog database dao interface
 *
 * @author neo.zzj
 */
@Repository
public interface InitDao {

    /**
     * 查询该表是否存在
     * @return 返回值 > 0，则存在
     */
    @Select("select count(table_name) from information_schema.tables where table_name = 'nb_user'")
    int queryInitTableName();

    /**
     * Drop table nb_user
     */
    @Update("DROP TABLE IF EXISTS nb_user")
    void dropTableUser();

    /**
     * 创建nb_user表
     */
    @Update("CREATE TABLE `nb_user` (\n" +
            "  `user_id` int(1) NOT NULL AUTO_INCREMENT COMMENT '用户id自增（原则上只有一个用户）',\n" +
            "  `username` varchar(16) NOT NULL COMMENT '用户名',\n" +
            "  `user_email` varchar(32) NOT NULL COMMENT '邮箱',\n" +
            "  `password` varchar(32) NOT NULL COMMENT '密码',\n" +
            "  `url` varchar(32) NOT NULL COMMENT '网址',\n" +
            "  `blog_name` varchar(32) NOT NULL COMMENT '博客名字',\n" +
            "  `blog_sub_name` varchar(32) DEFAULT NULL COMMENT '博客副标题',\n" +
            "  `blog_description` varchar(16) DEFAULT NULL COMMENT '博客描述',\n" +
            "  PRIMARY KEY (`user_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8")
    void createTableUser();

    /**
     * Drop table nb_post
     */
    @Update("DROP TABLE IF EXISTS nb_post")
    void dropTablePost();

    /**
     * 创建nb_post表
     */
    @Update("CREATE TABLE `nb_post` (\n" +
            "  `post_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '文章id自增',\n" +
            "  `post_author` int(10) NOT NULL COMMENT '文章作者id',\n" +
            "  `post_date` varchar(12) NOT NULL COMMENT '文章日期',\n" +
            "  `post_title` varchar(32) NOT NULL COMMENT '文章标题',\n" +
            "  `post_content` text COMMENT '文章内容',\n" +
            "  `post_excerpt` text COMMENT '文章摘要',\n" +
            "  `post_status` int(2) NOT NULL COMMENT '文章状态码，0：草稿，1：已发布',\n" +
            "  `comment_status` int(2) NOT NULL COMMENT '评论状态码，0：无法评论，1：可以评论',\n" +
            "  PRIMARY KEY (`post_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8")
    void createTablePost();

    /**
     * Drop table nb_comment
     */
    @Update("DROP TABLE IF EXISTS nb_comment")
    void dropTableComment();

    /**
     * 创建nb_comment表
     */
    @Update("CREATE TABLE `nb_comment` (\n" +
            "  `comment_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '评论id自增',\n" +
            "  `post_id` int(255) NOT NULL COMMENT '对应文章id',\n" +
            "  `comment_content` text COMMENT '评论内容',\n" +
            "  `comment_email` varchar(32) NOT NULL COMMENT '评论邮箱',\n" +
            "  `comment_ip` varchar(32) NOT NULL COMMENT '评论者ip',\n" +
            "  `comment_date` varchar(16) NOT NULL COMMENT '评论日期',\n" +
            "  `comment_status` int(2) NOT NULL COMMENT '状态，0：待审核，1：已评论',\n" +
            "  PRIMARY KEY (`comment_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8")
    void createTableComment();
}
