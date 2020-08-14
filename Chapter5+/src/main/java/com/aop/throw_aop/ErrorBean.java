package com.aop.throw_aop;

public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("foo");
    }

    public void otherProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bar");
    }

}
