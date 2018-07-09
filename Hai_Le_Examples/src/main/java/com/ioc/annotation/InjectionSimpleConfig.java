package com.ioc.annotation;

import org.springframework.stereotype.Component;

@Component("injectionSimpleConfig")
public class InjectionSimpleConfig {
    private String name = "John Smith";
    private int age = 33;
    private float height = 1.78f;
    private boolean programmer = true;
}
