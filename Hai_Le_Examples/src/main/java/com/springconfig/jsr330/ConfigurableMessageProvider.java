package com.springconfig.jsr330;

import com.getstartin.MessageProvider;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default";

    private ConfigurableMessageProvider() {}

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
