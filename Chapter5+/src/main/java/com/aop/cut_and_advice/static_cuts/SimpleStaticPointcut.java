package com.aop.cut_and_advice.static_cuts;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return (aClass == BeanOne.class);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("foo".equals(method.getName()));
    }
}
