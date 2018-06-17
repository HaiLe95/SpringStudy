package com.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
public class InjectionSimpleConfig {
    private String name = "Hai Le";
    private int age = 23;
    private float height = 1.78f;
    private boolean programmer = true;
}
