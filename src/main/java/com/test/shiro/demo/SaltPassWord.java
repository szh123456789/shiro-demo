package com.test.shiro.demo;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class SaltPassWord {

    public static void main(String[] args) {

        String password = "123456";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int time = 2;
        String alogrithmName = "md5";

        String encodePassword = new SimpleHash(alogrithmName, password, salt, time).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,time,encodePassword);
    }
}
