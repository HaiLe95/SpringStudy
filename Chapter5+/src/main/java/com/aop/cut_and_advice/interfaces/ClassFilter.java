package com.aop.cut_and_advice.interfaces;

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
