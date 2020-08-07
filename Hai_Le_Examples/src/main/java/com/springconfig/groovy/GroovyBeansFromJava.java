package com.springconfig.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {

    public static void main(String[] args) {

        ApplicationContext context = new GenericGroovyApplicationContext("classpath:com/springconfig/META-INF/beans.groovy");
        Contact contact = context.getBean("contact", Contact.class);
        System.out.println(contact);

    }

}
