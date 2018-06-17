package com.ioc.appcontext;

import com.getstartin.MessageProvider;
import com.getstartin.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;

public class StandartOutMessageRendererV3 implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                    + StandartOutMessageRendererV3.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) { this.messageProvider = messageProvider; }

    @Override
    public MessageProvider getMessageProvider() { return messageProvider; }
}
