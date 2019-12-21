package com.neoniou.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.neoniou.blog.dao.PostDao;
import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author neo.zzj
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> queryPosts(int page) {
        //分页
        PageHelper.startPage(page, 5);
        return postDao.selectAllOrderByDate();
    }

    @Override
    public Integer queryPostPage() {
        Integer count = postDao.queryPostCount();
        return count / 5;
    }

    @Override
    public Post queryPostByPostId(Integer postId) {
        return postDao.selectByPrimaryKey(postId);
    }

    @Override
    public List<Post> searchPostByWords(String words) {
        return postDao.searchPostByWords(words);
    }

    @Override
    public List<Post> queryPostByCategoryName(String categoryName) {
        return postDao.queryPostByCategoryName(categoryName);
    }
}
