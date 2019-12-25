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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取 blog 用户信息
     * @return User info
     */
    @GetMapping
    public ResponseEntity<User> getUserInfo() {
        return ResponseEntity.ok().body(userService.getUserInfo());
    }
}
