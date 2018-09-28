package com.springconfig.simplebean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;

    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing BEAN");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            age = 23;
        }
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    private static SimpleBean getBean(String beanName, ApplicationContext context) {
        try {
            SimpleBean bean = (SimpleBean) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/springconfig/META-INF/app-context.xml");
        context.refresh();

        SimpleBean simpleBean1 = getBean("simpleBean1", context);
        SimpleBean simpleBean2 = getBean("simpleBean2", context);
        SimpleBean simpleBean3 = getBean("simpleBean3", context);
    }

}
