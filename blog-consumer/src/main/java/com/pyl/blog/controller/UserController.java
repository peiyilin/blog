package com.pyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyl.blog.common.ResponseBean;
import com.pyl.blog.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peiyilin-ds
 * @date 2018/8/3 17:57
 **/
@Api(tags = {"用户接口"})
@RestController
public class UserController {


    @Reference(version = "1.0.0")
    private IUserService userService;


    @ApiOperation(value = "获取用户列表[admin]",notes = "根据url中的pageIndex和pageSize获取分页的用户列表")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "pageIndex",value = "页码",paramType = "path"),
                    @ApiImplicitParam(name = "pageSize",value = "每页的行数",defaultValue = "10",paramType = "path")})
    @RequestMapping(value = "/users/{pageIndex}/{pageSize}",method = RequestMethod.GET)
    @RequiresRoles("admin")
   /* @RequiresPermissions(value = {"view", "edit"})*/
    /**
     * 查询用户信息
     * @param pageIndex 页码
     * @param pageSize 每页的行数
     * @return
     */
    public ResponseBean getUser(@PathVariable int pageIndex, @PathVariable int pageSize){
        return new ResponseBean(200,"用户列表" ,userService.getAll(pageIndex,pageSize));
    }
}
