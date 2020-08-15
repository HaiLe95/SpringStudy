package com.aop.cut_and_advice.aspectj_cuts;

public class SampleAnnotationBean {

    @AdviceRequired
    public void foo(int x) {
        System.out.println("Invoked foo() with x: " + x);
    }
    public void bar() {
        System.out.println("bar");
    }
}
