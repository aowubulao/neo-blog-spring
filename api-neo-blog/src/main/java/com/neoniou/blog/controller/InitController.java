package com.neoniou.blog.controller;

import com.neoniou.blog.exception.ExceptionEnum;
import com.neoniou.blog.exception.NeoBlogException;
import com.neoniou.blog.service.InitService;
import com.neoniou.blog.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 初始化博客数据库Controller
 *
 * @author neo.zzj
 */
@RestController
@RequestMapping("/blog/database")
public class InitController {

    @Autowired
    private InitService initService;

    @GetMapping
    public ResponseEntity<Boolean> isNeedInit() {
        return ResponseEntity.ok().body(initService.isNeedInit());
    }

    @PostMapping
    public ResponseEntity<Void> initDatabase() {
        try {
            if (initService.isNeedInit()) {
                initService.initDatabase();
            }
        } catch (Exception e) {
            throw new NeoBlogException(ExceptionEnum.INIT_DATABASE_FAIL);
        }
        return ResponseEntity.ok().build();
    }
}
