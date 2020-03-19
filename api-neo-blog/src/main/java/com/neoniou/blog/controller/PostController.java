package com.neoniou.blog.controller;

import com.neoniou.blog.pojo.Post;
import com.neoniou.blog.service.PostService;
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
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }
}
