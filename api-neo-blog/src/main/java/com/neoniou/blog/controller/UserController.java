package com.neoniou.blog.controller;

import com.neoniou.blog.pojo.User;
import com.neoniou.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author neo.zzj
 */
@RestController
@RequestMapping("/blog")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取 blog 相关信息
     *
     * @return blog name, subName, description
     */
    @GetMapping("/info")
    public ResponseEntity<User> getBlogInfo() {
        return ResponseEntity.ok().body(userService.getBlogInfo());
    }

    /**
     * 认证用户，如果成功，将 token储存
     *
     * @param user User
     * @param token token
     * @return true or false
     */
    @PostMapping("/user/auth")
    public ResponseEntity<Boolean> authUser(User user,
                                            @RequestParam("token") String token) {
        return ResponseEntity.ok().body(userService.authUser(user, token));
    }
}
