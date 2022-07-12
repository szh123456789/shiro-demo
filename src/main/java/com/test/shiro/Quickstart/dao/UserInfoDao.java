package com.test.shiro.Quickstart.dao;

import com.test.shiro.Quickstart.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

    public UserInfo findByUsername(String userName);
}
