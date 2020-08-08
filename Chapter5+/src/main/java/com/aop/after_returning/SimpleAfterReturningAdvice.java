package com.aop.after_returning;

import com.aop.MessageWriter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory factory = new ProxyFactory();

        factory.addAdvice(new SimpleAfterReturningAdvice());
        factory.setTarget(target);

        MessageWriter proxy = (MessageWriter) factory.getProxy();
        proxy.writeMessage();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("");
        System.out.println("After method: " + method.getName());
    }

}
