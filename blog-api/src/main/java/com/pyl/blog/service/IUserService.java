package com.pyl.blog.service;

import com.pyl.blog.entity.User;

import java.util.List;

/**
 * @author peiyilin-ds
 * @date 2018/8/1 14:09
 **/
public interface IUserService {
    List<User> getAll(int pageIndex,int pageSize);

    User getUserByName(String username);
}
