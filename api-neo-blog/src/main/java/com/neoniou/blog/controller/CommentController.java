package com.neoniou.blog.controller;

import com.neoniou.blog.pojo.Comment;
import com.neoniou.blog.service.CommentService;
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
@RequestMapping("/blog/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("{postId}")
    public ResponseEntity<List<Comment>> queryCommentByPostId(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok().body(commentService.queryCommentByPostId(postId));
    }
}
