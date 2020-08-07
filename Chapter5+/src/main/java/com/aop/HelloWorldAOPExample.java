package com.aop;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new MessageDecorator());
        factory.setTarget(target);

        MessageWriter proxy = (MessageWriter) factory.getProxy();

        target.writeMessage();
        System.out.println("-");
        proxy.writeMessage();
    }

}
