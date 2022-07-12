package com.test.shiro.Quickstart.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping({"/", "/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        log.info("HomeController.login()");
        //登陆失败从request中获取shiro处理的异常信息
        //shiroLoginFailure：就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        log.info("exception:{}",exception);
        String msg = "";

        if (exception != null){
            if (UnknownAccountException.class.getName().equals(exception)){
                log.error("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            }else if (IncorrectCredentialsException.class.getName().equals(exception)){
                log.error("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            }else if ("kaptchaValidateFailed".equals(exception)){
                log.error("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            }else {
                msg = "else >>" + exception;
                log.error("else -- >{}", exception);
            }
        }

        map.put("msg", msg);
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        log.error("暂无权限");
        return "403";
    }
}
