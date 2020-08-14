package com.aop.cut_and_advice.interfaces;

public interface Pointcut {
    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}
