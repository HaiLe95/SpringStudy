package com.ioc.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {
        //Реализация BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //Подключение чтения бинов к фабрике, а так же путь к xml-файлу
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("com/ioc/xml-bean-factory-cfg.xml"));

        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }
}
