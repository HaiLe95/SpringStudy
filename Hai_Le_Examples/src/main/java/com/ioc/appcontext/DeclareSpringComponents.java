package com.ioc.appcontext;

import com.getstartin.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/app-context-p.xml");
        context.refresh();
        MessageProvider provider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }
}
