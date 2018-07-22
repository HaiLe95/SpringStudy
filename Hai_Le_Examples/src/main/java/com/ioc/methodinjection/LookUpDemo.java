package com.ioc.methodinjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookUpDemo {

    public static void displayInfo(DemoBean bean) {
        MyHelper myHelper1 = bean.getMyHelper();
        MyHelper myHelper2 = bean.getMyHelper();

        System.out.println("Helper Instances the Same? :");
        System.out.println(myHelper1 == myHelper2);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int i = 0; i < 100_000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSmthHelpful();
        }

        stopWatch.stop();

        System.out.println("100_000 gets took" + stopWatch.getTotalTimeMillis() + "ms");
    }


    public static void main(String [] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/methodinjection/app-context-xml.xml");
        context.refresh();

        DemoBean abstractBean = (DemoBean) context.getBean("abstractLookUpBean");
        DemoBean standartBean = (DemoBean) context.getBean("standartLookUpBean");

        displayInfo(abstractBean);
        displayInfo(standartBean);

    }

}
