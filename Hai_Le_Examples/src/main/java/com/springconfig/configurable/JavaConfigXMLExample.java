package com.springconfig.configurable;

import com.getstartin.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "classpath:com/springconfig/META-INF/mes-prov.xml");
//        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
//        renderer.render();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();

    }

}
