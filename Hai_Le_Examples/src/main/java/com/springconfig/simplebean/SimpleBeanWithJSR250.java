package com.springconfig.simplebean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithJSR250 {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() throws Exception {
        System.out.println("Initializing Bean");
        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            age = 20;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleBeanWithJSR250{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/springconfig/META-INF/simple-bean-jsr250.xml");
        context.refresh();

        SimpleBeanWithJSR250 bean1 = getBean("simpleBean1", context);
        SimpleBeanWithJSR250 bean2 = getBean("simpleBean2", context);
        SimpleBeanWithJSR250 bean3 = getBean("simpleBean3", context);
    }

    private static SimpleBeanWithJSR250 getBean(String beaName, ApplicationContext context) {
        try {
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) context.getBean(beaName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
}
