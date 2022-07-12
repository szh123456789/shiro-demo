package com.test.shiro.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickStart {

    public void test(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);

            try {
                currentUser.login(token);
            }catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        log.info("user [" + currentUser.getPrincipal() +"] logged in successfully.");

        if (currentUser.hasRole("schwartz")){
            log.info("May the Schwartz be with you!");
        }else {
            log.info("Hello, mere mortal.");
        }

        if (currentUser.isPermitted("lightsaber:wield")){
            log.info("You may use a lightsaber ring.  Use it wisely.");
        }else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        if ( currentUser.isPermitted( "winnebago:drive:eagle5" ) ) {
            log.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        currentUser.logout();
    }
}
