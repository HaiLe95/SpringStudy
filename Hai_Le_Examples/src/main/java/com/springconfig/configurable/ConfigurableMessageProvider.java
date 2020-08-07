package com.springconfig.configurable;

import com.getstartin.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default Message";

    public ConfigurableMessageProvider() {}

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
