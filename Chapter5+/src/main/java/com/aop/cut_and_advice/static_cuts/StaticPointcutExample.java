package com.aop.cut_and_advice.static_cuts;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutExample {

    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        BeanOne proxyOne;
        BeanTwo proxyTwo;

        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(beanOne);
        proxyOne = (BeanOne) factory.getProxy();

        factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(beanTwo);
        proxyTwo = (BeanTwo) factory.getProxy();

        proxyOne.foo();
        proxyTwo.foo();

        proxyOne.bar();
        proxyTwo.bar();
    }
}
