package com.pyl.blog.service;

import com.pyl.blog.BlogProviderApplication;
import com.pyl.blog.api.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 18:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BlogProviderApplication.class})
public class TestServiceImplTest {

    @Autowired
    private ITestService testService;

    @Test
    public void sayHello() {
        String world = testService.sayHello("world");
        System.out.println(world);
    }
}