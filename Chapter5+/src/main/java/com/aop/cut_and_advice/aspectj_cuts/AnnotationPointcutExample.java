package com.aop.cut_and_advice.aspectj_cuts;

import com.aop.cut_and_advice.static_cuts.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutExample {
    public static void main(String[] args) {
        SampleAnnotationBean bean = new SampleAnnotationBean();

        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut
                .forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(bean);
        factory.addAdvisor(advisor);
        SampleAnnotationBean proxy = (SampleAnnotationBean) factory.getProxy();

        proxy.foo(100);
        proxy.bar();
    }
}
