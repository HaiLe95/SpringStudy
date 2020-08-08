package com.aop.before;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {

    public static void main(String[] args) {

        SecurityManager manager = new SecurityManager();

        SecureBean bean = secureBean();

        manager.login("chris", "password");
        bean.writeSecureMessage();
        manager.logout();

        try {
            manager.login("invaliduser", "password");
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static SecureBean secureBean() {
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean proxy = (SecureBean) factory.getProxy();

        return proxy;
    }

}
