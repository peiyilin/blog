package com.pyl.blog.service;

import com.github.pagehelper.PageHelper;
import com.pyl.blog.dao.UserMapper;
import com.pyl.blog.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author peiyilin-ds
 * @date 2018/8/1 15:28
 **/
public class UserSeviceImplTest extends BaseTestService{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        PageHelper.startPage(1,2);
        List<User> users = userMapper.selectAll();
        users.forEach(user -> System.out.println("姓名："+user.getUserName()));
    }
}