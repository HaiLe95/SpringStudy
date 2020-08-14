package com.aop.around;

import org.springframework.aop.framework.ProxyFactory;

public class ProfileExample {
    public static void main(String[] args) {
        WorkerBean bean = getBean();
        bean.doSomeWork(10);

    }

    private static WorkerBean getBean() {
        WorkerBean target = new WorkerBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());

        return (WorkerBean) factory.getProxy();
    }

}
