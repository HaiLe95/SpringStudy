package com.aop.after_returning;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {

    private static KeyGenerator getGenerator() {
        KeyGenerator target = new KeyGenerator();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());

        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator generator = getGenerator();

        for (int i = 0; i < 10; i ++) {
            try {
                long key = generator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException e) {
                System.out.println("WEAK KEY");
            }
        }
    }

}
