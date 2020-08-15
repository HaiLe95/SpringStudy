package com.aop.cut_and_advice.aspectj_cuts;

import com.aop.cut_and_advice.static_cuts.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutExample {
    public static void main(String[] args) {
        AspectjexpBean bean = new AspectjexpBean();

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(*foo*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(bean);
        factory.addAdvisor(advisor);
        AspectjexpBean proxy = (AspectjexpBean) factory.getProxy();

        proxy.foo1();
        proxy.foo2();
        proxy.bar();
    }
}
