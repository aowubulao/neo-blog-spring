package com.neoniou.blog.service.impl;

import com.neoniou.blog.dao.CommentDao;
import com.neoniou.blog.pojo.Comment;
import com.neoniou.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neo.zzj
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> queryCommentByPostId(Integer postId) {
        return commentDao.queryCommentByPostId(postId);
    }
}
