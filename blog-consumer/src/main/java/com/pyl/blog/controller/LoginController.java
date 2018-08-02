package com.pyl.blog.controller;

import com.pyl.blog.common.ResponseBean;
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


    @ApiOperation(value = "用户登录",notes = "用户登录")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "name",value = "用户名",required = true),
                    @ApiImplicitParam(name = "password",value = "用户密码",required = true)})
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(String name,String password){
        //验证处理逻辑先不加
        String userName = "pyl";
        if (userName.equals(name)){
            return new ResponseBean(200,"login success",JwtUtil.sign(name,password));
        }
        return new ResponseBean(401,"Unauthorized",null);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
