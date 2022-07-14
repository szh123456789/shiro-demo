package com.shiro.test.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
public class JdbcRealmTest {



    @Test
    public void jdbcRealmTest(){

        JdbcRealm jdbcRealm = new JdbcRealm();

        //构建securitymanager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(simpleAccountRealm);

        //主动提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123");
        subject.login(token);

        log.info("isAuthenticated:" + subject.isAuthenticated());

        subject.checkRoles("admin");

        subject.checkPermission("user:add");

    }
}
