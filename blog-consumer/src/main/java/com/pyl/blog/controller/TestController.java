package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.entity.User;
import com.pyl.blog.service.ITestService;
import com.pyl.blog.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 17:55
 **/
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private ITestService testService;

    @Reference(version = "1.0.0")
    private IUserService userService;

    @RequestMapping("/test")
    public String test(String msg){
        return testService.sayHello(msg);
    }

    @RequestMapping("/users/{pageIndex}/{pageSize}")
    public List<User> getUser(@PathVariable int pageIndex,@PathVariable int pageSize){
       return userService.getAll(pageIndex,pageSize);
    }
}
