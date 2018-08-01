package com.pyl.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO init application
 * @author peiyilin-ds
 * @date 2018/7/27 17:18
 **/
@SpringBootApplication
@MapperScan("com.pyl.blog.dao")
public class BlogProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class,args);
    }
}
