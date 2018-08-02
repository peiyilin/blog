package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.entity.User;
import com.pyl.blog.service.ITestService;
import com.pyl.blog.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 17:55
 **/
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private ITestService testService;

    @Reference(version = "1.0.0")
    private IUserService userService;

    @ApiOperation(value = "测试",notes = "向参数say hello")
    @ApiImplicitParam(name = "msg",value = "任意",dataTypeClass = String.class)
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(String msg){
        return testService.sayHello(msg);
    }

    @ApiOperation(value = "获取用户列表",notes = "根据url中的pageIndex和pageSize获取分页的用户列表")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "pageIndex",value = "页码",dataTypeClass = Integer.class,paramType = "path"),
                @ApiImplicitParam(name = "pageSize",value = "每页的行数",defaultValue = "10",dataTypeClass = Integer.class,paramType = "path")})
    @RequestMapping(value = "/users/{pageIndex}/{pageSize}",method = RequestMethod.GET)
    public List<User> getUser(@PathVariable int pageIndex,@PathVariable int pageSize){
       return userService.getAll(pageIndex,pageSize);
    }
}
