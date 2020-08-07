package com.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice{

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new SimpleBeforeAdvice());
        factory.setTarget(target);

        MessageWriter proxy = (MessageWriter) factory.getProxy();
        proxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
