package com.aop.cut_and_advice.dynamic_cuts;

public class SampleBean {

    public void foo(int x) {
        System.out.println("Invokerd foo() woth argument: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }

}
