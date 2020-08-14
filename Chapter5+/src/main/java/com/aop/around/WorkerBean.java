package com.aop.around;

public class WorkerBean {

    public void doSomeWork(int value) {
        for(int i = 0; i < value; i++) {
            work();
        }
    }

    private void work() {
        System.out.println("some work");
    }

}
