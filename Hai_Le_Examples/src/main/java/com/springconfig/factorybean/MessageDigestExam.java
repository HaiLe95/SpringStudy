package com.springconfig.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExam {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/springconfig/META-INF/digest.xml");
        context.refresh();

        MessageDisgester md = (MessageDisgester) context.getBean("digester");
        md.digest("Hello World!");
    }

}
