package ioc.appcontext;

import getstartin.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/app-context-xml.xml");
        context.refresh();
        MessageProvider provider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }
}
