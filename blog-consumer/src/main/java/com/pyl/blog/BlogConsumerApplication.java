package com.pyl.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO init application
 * @author peiyilin
 * @date 2018/7/27 17:18
 **/
@SpringBootApplication
@EnableSwagger2
public class BlogConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogConsumerApplication.class,args);
    }
}
