package com.ioc.methodinjection;

public abstract class AbstractLookUpDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    @Override
    public void toDoSomeOperations() {
        getMyHelper().doSmthHelpful();
    }
}
