package com.neoniou.blog.controller;

import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author neo.zzj
 */
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

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
}
