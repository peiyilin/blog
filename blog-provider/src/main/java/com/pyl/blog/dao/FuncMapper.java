package com.pyl.blog.dao;

import com.pyl.blog.entity.Func;

public interface FuncMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Func record);

    int insertSelective(Func record);

    Func selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Func record);

    int updateByPrimaryKey(Func record);
}