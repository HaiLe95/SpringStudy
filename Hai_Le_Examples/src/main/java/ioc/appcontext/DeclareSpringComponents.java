package ioc.appcontext;

import getstartin.MessagePrivoder;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/app-context-xml.xml");
        context.refresh();
        MessagePrivoder privoder = context.getBean("messageProvider", MessagePrivoder.class);
        System.out.println(privoder.getMessage());
    }
}
