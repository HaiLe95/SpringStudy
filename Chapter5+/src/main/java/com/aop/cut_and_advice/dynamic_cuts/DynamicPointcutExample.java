package com.aop.cut_and_advice.dynamic_cuts;

import com.aop.cut_and_advice.static_cuts.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExample {

    public static void main(String[] args) {
        SampleBean sBean = new SampleBean();

        Advisor advisor = new DefaultPointcutAdvisor(
                new SimpleDynamicPointcut(), new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(sBean);
        factory.addAdvisor(advisor);
        SampleBean proxy = (SampleBean) factory.getProxy();

        proxy.foo(1);
        proxy.foo(10);
        proxy.foo(100);
        proxy.foo(1000);

        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
