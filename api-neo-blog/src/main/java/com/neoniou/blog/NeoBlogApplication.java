package com.neoniou.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author neo.zzj
 */
@SpringBootApplication
@MapperScan("com.neoniou.blog.dao")
public class NeoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeoBlogApplication.class, args);
    }
}
