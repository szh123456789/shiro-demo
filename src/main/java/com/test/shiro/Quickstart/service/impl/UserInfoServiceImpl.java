package com.test.shiro.Quickstart.service.impl;

import com.test.shiro.Quickstart.dao.UserInfoDao;
import com.test.shiro.Quickstart.entity.UserInfo;
import com.test.shiro.Quickstart.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    public UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUserName(String userName) {
        return userInfoDao.findByUsername(userName);
    }
}
