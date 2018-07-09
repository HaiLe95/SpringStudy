package com.ioc.collections;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties properties;
    private Set set;
    private List list;


    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/collections/app-context.xml");
        context.refresh();

        CollectionInjection instance = (CollectionInjection) context.getBean("injectionCollection");
        instance.displayInfo();
    }

    public void displayInfo() {
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

    public void setMap(Map<String, Object> map) { this.map = map; }
    public void setProperties(Properties properties) { this.properties = properties; }
    public void setSet(Set set) { this.set = set; }
    public void setList(List list) { this.list = list; }
}
