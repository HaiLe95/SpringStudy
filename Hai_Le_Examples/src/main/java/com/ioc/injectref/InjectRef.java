package com.ioc.injectref;

import com.ioc.beanfactory.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:com/ioc/META-INF/spring/injref.xml");
        context.refresh();
        InjectRef ref = (InjectRef) context.getBean("injectRef");
        System.out.println(ref);
    }

    public String toString() {
        return  oracle.defineMeaningOfLife();
    }
}
