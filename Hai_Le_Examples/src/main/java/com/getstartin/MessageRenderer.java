package com.getstartin;

public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();

}
