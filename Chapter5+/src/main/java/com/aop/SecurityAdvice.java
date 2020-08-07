package com.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager manager;

    public SecurityAdvice() {
        this.manager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        UserInfo user = manager.getLoggerOnUser();

        if(user.equals(null)) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method:"
                    + method.getName());
        } else if(user.getUserName().equals("chris")) {
            System.out.println("Welcome back Chris");
        } else {
            System.out.println("User " + user.getUserName() + " NOT GOOD ");
            throw new SecurityException("User " + user.getUserName() + "is not allowed access to method "
                    + method.getName());
        }

    }
}
