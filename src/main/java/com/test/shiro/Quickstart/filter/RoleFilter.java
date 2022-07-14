package com.test.shiro.Quickstart.filter;

import javafx.beans.property.StringProperty;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class RoleFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = getSubject(request, response);

        String[] roles = (String[]) mappedValue;

        if (roles == null || roles.length ==0){
            return true;
        }

        for (String role: roles){
           if (subject.hasRole(role)){
               return true;
           }
        }
        return false;
    }
}
