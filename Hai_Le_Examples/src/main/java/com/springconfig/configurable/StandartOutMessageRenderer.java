package com.springconfig.configurable;

import com.getstartin.MessageProvider;
import com.getstartin.MessageRenderer;

public class StandartOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            System.out.println("kek");
            throw new RuntimeException();
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
