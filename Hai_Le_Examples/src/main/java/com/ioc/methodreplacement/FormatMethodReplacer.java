package com.ioc.methodreplacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        if(ifFormatMessageMethod(method)) {
            String msg = (String) objects[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Error " + method.getName());
        }
    }

    private boolean ifFormatMessageMethod(Method method) {
        if(method.getParameterTypes().length != 1) {
            return false;
        } else if (!("formatMessage".equals(method.getName()))) {
            return false;
        } else if(method.getReturnType() != String.class) {
            return false;
        } else if(method.getParameterTypes() [0] != String.class) {
            return false;
        }
        return true;
    }
}
