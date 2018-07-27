package com.pyl.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * TODO init application
 * @author peiyilin
 * @date 2018/7/27 17:18
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BlogProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class,args);
    }
}
