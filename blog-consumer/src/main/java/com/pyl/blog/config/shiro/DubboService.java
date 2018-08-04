package com.pyl.blog.config.shiro;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.service.IUserService;

/**
 * @Author: Administrator
 * @Date: 2018/8/4/004 18:21
 * @Description:
 */
public class DubboService {

    @Reference(version = "1.0.0")
    protected IUserService userService;
}
