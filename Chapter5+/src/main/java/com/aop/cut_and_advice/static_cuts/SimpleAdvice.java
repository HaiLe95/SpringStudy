package com.aop.cut_and_advice.static_cuts;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking " + methodInvocation.getMethod().getName());
        Object var = methodInvocation.proceed();
        System.out.println(">> Done");
        return var;
    }
}
