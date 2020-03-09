package com.neoniou.blog.service;

import com.neoniou.blog.pojo.Post;

import java.util.List;

/**
 * @author neo.zzj
 */
public interface PostService {

    /**
     * 根据页数查询文章
     * @param page 当前page
     * @return List
     */
    List<Post> queryPosts(int page);

    /**
     * 查询总页数，每页5条记录
     * @return total count
     */
    Integer queryPostPage();

    /**
     * 根据 post_id 查询文章
     * @param postId primary key
     * @return Post
     */
    Post queryPostByPostId(Integer postId);

    /**
     * 模糊搜索文章
     * @param words 搜索信息
     * @return post(post_title)
     */
    List<Post> searchPostByWords(String words);

    /**
     * 根据 category_name 查找该分类下的文章的总页数
     * 一页5条，查询一共多少页
     * @param categoryName category_name
     * @return total pages
     */
    Integer queryCategoryPostPage(String categoryName);

    /**
     * 根据 category_name 查找该分类下的文章
     * @param categoryName category_name
     * @param page 当前page
     * @return Posts
     */
    List<Post> queryPostByCategoryName(String categoryName, Integer page);

    /**
     * 添加新文章
     * @param post Post
     */
    void addPost(Post post);
}
