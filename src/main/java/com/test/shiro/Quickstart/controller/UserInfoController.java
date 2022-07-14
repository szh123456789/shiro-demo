package com.test.shiro.Quickstart.controller;

import com.test.shiro.Quickstart.dao.UserInfoDao;
import com.test.shiro.Quickstart.entity.UserInfo;
import com.test.shiro.Quickstart.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserInfoController {

    @Resource
    public UserInfoService userInfoService;

    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    @RequiresRoles("admin")
    public UserInfo findUserInfoByUserName(@RequestParam String username){
        return userInfoService.findByUserName(username);
    }

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    @RequiresRoles("admin1")
    public String addUserInfo(){
        return "addUserInfo success!";
    }

    @RequestMapping("/userDelete")
    @RequiresPermissions("userInfo:delete")

    public String deleteUserInfo() {
        return "deleteUserInfo success!";
    }
}
