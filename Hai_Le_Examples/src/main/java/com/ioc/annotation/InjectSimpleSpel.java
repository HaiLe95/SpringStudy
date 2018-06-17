package com.ioc.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpel {

    private String name;
    private int age;
    private float height;
    private boolean programmer;

    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/spring/inject-simplecfg.xml");
        context.refresh();
        InjectSimpleSpel simpleSpel = (InjectSimpleSpel) context.getBean("injectSimpleSpel");
        System.out.println(simpleSpel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "InjectSimpleSpel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                '}';
    }
}
