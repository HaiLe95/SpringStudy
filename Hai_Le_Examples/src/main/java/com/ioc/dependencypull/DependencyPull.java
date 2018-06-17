package com.ioc.dependencypull;

import com.getstartin.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "com/ioc/app-context.xml"
                );
        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
