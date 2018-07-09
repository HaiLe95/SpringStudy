package com.ioc.hierarchic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

    public static void main(String[] args) {

        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("classpath:com/ioc/META-INF/hierarchic/parent.xml");
        parentContext.refresh();

        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("classpath:com/ioc/META-INF/hierarchic/child.xml");
        childContext.setParent(parentContext);
        childContext.refresh();

        SimpleTarget target01 = (SimpleTarget) childContext.getBean("target01");
        SimpleTarget target02 = (SimpleTarget) childContext.getBean("target02");
        SimpleTarget target03 = (SimpleTarget) childContext.getBean("target03");

        System.out.println(target01.getVal());
        System.out.println(target02.getVal());
        System.out.println(target03.getVal());

    }

}
