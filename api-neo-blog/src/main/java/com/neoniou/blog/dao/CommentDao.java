package com.neoniou.blog.dao;

import com.neoniou.blog.pojo.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author neo.zzj
 */
@Repository
public interface CommentDao extends Mapper<Comment> {

    /**
     * 根据post_id查询评论
     * @param postId post_id
     * @return Comments
     */
    @Select("select * from nb_comment where post_id = #{postId}")
    List<Comment> queryCommentByPostId(Integer postId);
}
