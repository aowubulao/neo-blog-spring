package com.neoniou.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.neoniou.blog.dao.PostDao;
import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (count < 5) {
            return 1;
        }
        int end = count % 5;
        return (count / 5) + end;
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
    public List<Post> queryPostByCategoryName(String categoryName, Integer page) {
        //分页
        PageHelper.startPage(page, 5);
        return postDao.queryPostByCategoryName(categoryName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPost(Post post) {
        try {
            postDao.insert(post);
        } catch (Exception e) {
            throw new NeoBlogException(ExceptionEnum.ADD_POST_FAIL);
        }

    }

    @Override
    public Integer queryCategoryPostPage(String categoryName) {
        Integer count = postDao.queryCategoryPostCount(categoryName);
        if (count < 5) {
            return 1;
        }
        int end = count % 5;
        return (count / 5) + end;
    }
}
