package com.pyl.blog.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * TODO dubbo test impl class
 *
 * @author peiyilin
 * @date 2018/7/27 17:14
 **/
@Service(version = "1.0.0")
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello(String msg) {
        return "Hello " + msg + "!";
    }
}
