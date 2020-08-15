package com.aop.cglib;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
    }

    private static void runCglibTests(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setProxyTargetClass(true);
        factory.setTarget(target);
        factory.addAdvisor(advisor);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLIB (STANDARD) Tests");
        test(proxy);
    }

    private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setFrozen(true);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLIB (FROZEN) Test");
        test(proxy);
    }

    private static void runJdkTest(Advisor advisor, SimpleBean target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setInterfaces(new Class[] {SimpleBean.class});

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;

        //advised
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500.000; x++) {
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after-before) + "ms");

        //unadvised
        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500.000; x++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after-before) + "ms");

        //equals
        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500.000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after-before) + "ms");

        //hashcode
        System.out.println("Testing hashcode() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500.000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after-before) + "ms");

        Advised advised = (Advised) bean;
        // Advised.getProxyTargetClass
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500.000; x++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after-before) + "ms");
        System.out.println(">>>\n");
    }
}
