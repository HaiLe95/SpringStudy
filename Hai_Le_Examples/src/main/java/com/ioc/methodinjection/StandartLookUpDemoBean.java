package com.ioc.methodinjection;

public class StandartLookUpDemoBean implements DemoBean {

    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper){
        this.myHelper = myHelper;
    }

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    @Override
    public void toDoSomeOperations() {
        myHelper.doSmthHelpful();
    }
}
