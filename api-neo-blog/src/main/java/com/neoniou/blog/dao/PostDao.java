package com.neoniou.blog.dao;

import com.neoniou.blog.pojo.Post;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author neo.zzj
 */
@Repository
public interface PostDao extends Mapper<Post> {

    /**
     * 查询 Post 总记录数
     * @return count
     */
    @Select("select count(post_id) from nb_post")
    Integer queryPostCount();

    /**
     * 根据文章发布时间升序查询
     * @return posts
     */
    @Select("select * from nb_post order by post_date asc")
    List<Post> selectAllOrderByDate();

    /**
     * 模糊搜索文章
     * @param words 搜索信息
     * @return post(post_title)
     */
    @Select("select post_title from nb_post where post_title like concat('%', #{words} '%') " +
            " or post_content like concat('%', #{words} '%')" +
            " or post_excerpt like concat('%', #{words} '%')")
    List<Post> searchPostByWords(String words);
}
