package com.neoniou.blog.controller;

import com.neoniou.blog.pojo.User;
import com.neoniou.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author neo.zzj
 */
@RestController
@RequestMapping("/blog/info")
public class InfoController {

    @Autowired
    private UserService userService;

    /**
     * 获取 blog 用户信息
     * @return User info
     */
    @GetMapping("/user")
    public ResponseEntity<User> getUserInfo() {
        return ResponseEntity.ok().body(userService.getUserInfo());
    }

    /**
     * 获取 blog 相关信息
     *
     * @return blog name, subName, description
     */
    @GetMapping
    public ResponseEntity<User> getBlogInfo() {
        return ResponseEntity.ok().body(userService.getBlogInfo());
    }

}
