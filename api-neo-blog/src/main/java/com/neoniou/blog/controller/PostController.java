package com.neoniou.blog.controller;

import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.PostService;
import com.neoniou.blog.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author neo.zzj
 */
@RestController
@RequestMapping("/blog")
public class PostController {

    private final PostService postService;
    private TokenUtil tokenUtil;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
        tokenUtil = new TokenUtil();
    }

    /**
     * 文章。一页5条，查询一共多少页
     * @return total pages
     */
    @GetMapping("/posts/total")
    public ResponseEntity<Integer> queryPostPage() {
        return ResponseEntity.ok().body(postService.queryPostPage());
    }

    /**
     * 分页查询所有文章
     * @param page 当前页数
     * @return posts
     */
    @GetMapping("/posts/{page}")
    public ResponseEntity<List<Post>> queryPosts(@PathVariable("page") int page) {
        return ResponseEntity.ok().body(postService.queryPosts(page));
    }

    /**
     * 根据 post_id 查询文章
     * @param postId primary key
     * @return Post
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> queryPostByPostId(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok().body(postService.queryPostByPostId(postId));
    }

    /**
     * 模糊搜索文章
     * @param words 搜索信息
     * @return post(post_title)
     */
    @GetMapping("/posts/content/{words}")
    public ResponseEntity<List<Post>> searchPostByWords(@PathVariable("words") String words) {
        return ResponseEntity.ok().body(postService.searchPostByWords(words));
    }

    /**
     * 根据 category_name 查找该分类下的文章的总页数
     * 一页5条，查询一共多少页
     * @param categoryName category_name
     * @return total pages
     */
    @GetMapping("/posts/category/total/{categoryName}")
    public ResponseEntity<Integer> queryCategoryPostPage(@PathVariable("categoryName") String categoryName) {
        return ResponseEntity.ok().body(postService.queryCategoryPostPage(categoryName));
    }

    /**
     * 根据 category_name 查找该分类下的文章
     * @param categoryName category_name
     * @param page 当前page
     * @return Posts
     */
    @GetMapping("/posts/category/{categoryName}/{page}")
    public ResponseEntity<List<Post>> queryPostByCategoryName(@PathVariable("categoryName") String categoryName,
                                                              @PathVariable("page") Integer page) {
        return ResponseEntity.ok().body(postService.queryPostByCategoryName(categoryName, page));
    }

    /**
     * 添加新文章
     * @param post Post
     */
    @PostMapping("/post")
    public ResponseEntity<Void> addPost(Post post,
                                        @RequestParam("token") String token) {
        if (!tokenUtil.authToken(token)) {
            throw new NeoBlogException(ExceptionEnum.REQUEST_FORBIDDEN);
        }
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除文章
     * @param postId 文章 id
     * @param token token
     */
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId,
                                           @RequestParam("token") String token) {
        if (!tokenUtil.authToken(token)) {
            throw new NeoBlogException(ExceptionEnum.REQUEST_FORBIDDEN);
        }

        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
