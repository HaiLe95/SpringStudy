package com.aop.cut_and_advice.dynamic_cuts;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for " + method.getName());
        int x = ((Integer)objects[0]).intValue();
        return (x != 100);
    }

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return (aClass == SampleBean.class);
            }
        };
    }
}
