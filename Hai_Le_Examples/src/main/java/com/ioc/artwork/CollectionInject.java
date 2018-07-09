package com.ioc.artwork;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInject {
    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties properties;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;


    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/artwork/app-context-annotation.xml");
        context.refresh();

        CollectionInject instance = (CollectionInject) context.getBean("injectCollection");
        instance.displayInfo();
    }

    public void displayInfo() {
        System.out.println("\n");
        System.out.println("Map contents: \n");
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\nProperties contents: \n");
        for(Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\nSet contents:\n");
        for(Object obj : set) {
            System.out.println("Value: " + obj);
        }
        System.out.println("\nList contents:\n");
        for(Object obj : list) {
            System.out.println("Value: " + obj);
        }
    }

}
