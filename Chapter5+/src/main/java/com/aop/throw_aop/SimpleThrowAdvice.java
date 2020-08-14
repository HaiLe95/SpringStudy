package com.aop.throw_aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowAdvice implements ThrowsAdvice {
    public static void main(String[] args) throws Exception {
        ErrorBean bean = new ErrorBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(bean);
        factory.addAdvice(new SimpleThrowAdvice());

        ErrorBean proxy = (ErrorBean) factory.getProxy();

        try {
            proxy.errorProneMethod();
        } catch (Exception ignore) {

        }

        try {
            proxy.otherProneMethod();
        } catch (Exception ignore) {

        }
    }

    public void afterThrowing(Exception e)  throws Throwable {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + e.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException e)
            throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + e.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
