package com.aop.cut_and_advice.interfaces;

import java.lang.reflect.Method;

public interface MethodMatcher {
    boolean matches(Method m, Class<?> target);
    boolean isRuntime();
    boolean mathces(Method m, Class<?> target, Object[] args);
}
