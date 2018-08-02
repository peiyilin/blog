package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.common.ResponseBean;
import com.pyl.blog.entity.User;
import com.pyl.blog.service.ITestService;
import com.pyl.blog.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author peiyilin-ds
 * @date 2018/7/27 17:55
 **/
@Api(tags = {"测试接口"})
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private ITestService testService;

    @Reference(version = "1.0.0")
    private IUserService userService;

    @ApiOperation(value = "测试",notes = "向参数say hello")
    @ApiImplicitParam(name = "msg",value = "任意")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseBean test(String msg){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            msg = "guest";
        }
        return new ResponseBean(200, testService.sayHello(msg), testService.sayHello(msg));
    }

    @ApiOperation(value = "获取用户列表",notes = "根据url中的pageIndex和pageSize获取分页的用户列表")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "pageIndex",value = "页码",paramType = "path"),
                @ApiImplicitParam(name = "pageSize",value = "每页的行数",defaultValue = "10",paramType = "path")})
    @RequestMapping(value = "/users/{pageIndex}/{pageSize}",method = RequestMethod.GET)
    @RequiresAuthentication
    public ResponseBean getUser(@PathVariable int pageIndex,@PathVariable int pageSize){
        return new ResponseBean(200,"用户列表" ,userService.getAll(pageIndex,pageSize));
    }
}
