package com.pyl.blog.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.pyl.blog.dao.UserMapper;
import com.pyl.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author peiyilin-ds
 * @date 2018/8/1 14:38
 **/
@Service(version = "1.0.0")
public class UserSeviceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public List<User> getAll(int pageIndex,int pageSize) {
        if (pageSize < 0 || pageSize==0){
            pageSize = 10;
        }
        PageHelper.startPage(pageIndex, pageSize);
        return userMapper.selectAll();
    }
}
