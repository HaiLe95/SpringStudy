package com.ioc.autowire;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {

    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {}

    public Target(Foo foo) {
        System.out.println("Target(Foo) called!");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called!");
    }

    public void setFoo1(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo1 set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/autowire/app-context.xml");
        context.refresh();

        Target target = null;
        System.out.println("Using byName:\n");
        target = (Target) context.getBean("targetByName");

        System.out.println("\nUsing byType:\n");
        target = (Target) context.getBean("targetByType");

        System.out.println("\nUsing constructor\n");
        target = (Target) context.getBean("targetConstructor");
    }

}

