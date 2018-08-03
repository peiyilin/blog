package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.common.ResponseBean;
import com.pyl.blog.entity.User;
import com.pyl.blog.service.IUserService;
import common.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peiyilin-ds
 * @date 2018/8/2 15:53
 **/
@Api(tags = {"登录接口"})
@Controller
public class LoginController {

    @Reference(version = "1.0.0")
    private IUserService userService;

    @ApiOperation(value = "用户登录",notes = "用户登录")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "name",value = "用户名",required = true),
                    @ApiImplicitParam(name = "password",value = "用户密码",required = true)})
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(String name,String password){
        User user = userService.getUserByName(name);
        if (user != null){
            if (!user.getPassword().equals(password)){
                return new ResponseBean(500,"login error","用户名或密码错误");
            }
            return new ResponseBean(200,"login success",JwtUtil.sign(name,password));
        }
        return new ResponseBean(500,"login error","用户名或密码错误");
    }
}
