package com.ioc.methodreplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/methodreplacement/app-context.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    public static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int i = 0; i < 1000000; i++) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();

        System.out.println("1000000 invocation took:" + stopWatch.getTotalTimeMillis() + "ms");
    }

}
