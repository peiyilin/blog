package com.pyl.blog.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 18:42
 **/
public class TestServiceImplTest extends BaseTestService{

    @Autowired
    private ITestService testService;

    @Test
    public void sayHello() {
        String world = testService.sayHello("world");
        System.out.println(world);
    }
}
