package com.aop;

public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal =
            new ThreadLocal<>();

    public void login(String name, String pass) {
        threadLocal.set(new UserInfo(name, pass));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggerOnUser() {
        return threadLocal.get();
    }

}
