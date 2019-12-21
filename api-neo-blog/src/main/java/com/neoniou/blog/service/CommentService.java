package com.neoniou.blog.service;

import com.neoniou.blog.pojo.Comment;

import java.util.List;

/**
 * @author neo.zzj
 */
public interface CommentService {

    /**
     * 查询文章所有评论
     * @param postId post_id
     * @return Comments
     */
    List<Comment> queryCommentByPostId(Integer postId);
}
