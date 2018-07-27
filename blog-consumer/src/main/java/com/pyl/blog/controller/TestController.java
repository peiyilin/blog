package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.api.ITestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 17:55
 **/
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private ITestService testService;

    @RequestMapping("/test")
    public String test(String msg){
        return testService.sayHello(msg);
    }
}
