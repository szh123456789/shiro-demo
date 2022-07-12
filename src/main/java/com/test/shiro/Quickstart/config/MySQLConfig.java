package com.test.shiro.Quickstart.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLConfig extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
