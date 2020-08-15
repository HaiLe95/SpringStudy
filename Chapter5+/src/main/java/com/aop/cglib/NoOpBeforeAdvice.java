package com.aop.cglib;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //
    }
}
