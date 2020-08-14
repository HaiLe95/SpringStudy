package com.aop.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());

        Object value = methodInvocation.proceed();

        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return value;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: " + m.getName());

        System.out.println("On object of type: " + target.getClass().getName());
        System.out.println("With arguments: ");
        for(int i = 0; i < args.length; i++) {
            System.out.println("    > " + args[i]);
        }
        System.out.println("\n");
        System.out.println("Took: " + ms + " ms");
    }
}
