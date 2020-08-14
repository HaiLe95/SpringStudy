package com.aop.cut_and_advice;

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
