package com.aop.cut_and_advice.name_cuts;

import com.aop.cut_and_advice.static_cuts.SimpleAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutAdvisor {
    public static void main(String[] args) {
        NameBean bean = new NameBean();

        NameMatchMethodPointcutAdvisor advisor =
                new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(bean);
        factory.addAdvisor(advisor);
        NameBean proxy = (NameBean) factory.getProxy();

        proxy.foo();
        proxy.foo(100);
        proxy.bar();
        proxy.yup();
    }
}
