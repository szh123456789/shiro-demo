package com.test.shiro.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationTest {

//    private static final SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    public static void testAuthentication(){
//        simpleAccountRealm.addAccount("wmyskxz", "123456");
//        simpleAccountRealm.addAccount("wmyskxz", "123456", "admin", "user");

        MyRealm myRealm = new MyRealm();
        //构建securitymanager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(simpleAccountRealm);
        defaultSecurityManager.setRealm(myRealm);

        //主动提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("wmyskxz", "123456");
        subject.login(token);

        log.info("isAuthenticated:" + subject.isAuthenticated());

        subject.checkRoles("admin", "user");

        subject.checkPermission("user:add");
        subject.logout();

        log.info("isAuthenticated:" + subject.isAuthenticated());
    }

    public static void main(String[] args) {
        testAuthentication();
    }
}
