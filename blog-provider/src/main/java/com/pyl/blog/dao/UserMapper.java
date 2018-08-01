package com.pyl.blog.dao;

import com.pyl.blog.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
