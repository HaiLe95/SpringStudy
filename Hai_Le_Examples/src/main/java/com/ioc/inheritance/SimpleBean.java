package com.ioc.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/inheritance/app-context.xml");
        context.refresh();

        SimpleBean parent = (SimpleBean) context.getBean("inheritParent");
        SimpleBean child = (SimpleBean) context.getBean("inheritChild");

        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }
}
