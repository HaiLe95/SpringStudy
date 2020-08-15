package com.aop.cut_and_advice.name_cuts;

import com.aop.cut_and_advice.static_cuts.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutExample {

    public static void main(String[] args) {
        NameBean nameBean = new NameBean();

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("foo");
        pointcut.addMethodName("bar");

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(nameBean);
        factory.addAdvisor(advisor);
        NameBean proxy = (NameBean) factory.getProxy();

        proxy.foo();
        proxy.foo(999);
        proxy.bar();
        proxy.yup();
    }
}
