package com.ioc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {

    @Value("#{injectionSimpleConfig.name}")
    private String name;
    @Value("#{injectionSimpleConfig.age}")
    private int age;
    @Value("#{injectionSimpleConfig.height}")
    private float height;
    @Value("#{injectionSimpleConfig.programmer}")
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
