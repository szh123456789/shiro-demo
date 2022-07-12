package com.test.shiro.Quickstart.service;

import com.test.shiro.Quickstart.entity.UserInfo;

public interface UserInfoService {
    public UserInfo findByUserName(String userName);
}
