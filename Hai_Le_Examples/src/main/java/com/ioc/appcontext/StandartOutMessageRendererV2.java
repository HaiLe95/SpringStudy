package com.ioc.appcontext;

import com.getstartin.MessageProvider;
import com.getstartin.MessageRenderer;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandartOutMessageRendererV2 implements MessageRenderer {
    private MessageProvider messagePrivoder;

    @Override
    public void render() {
        if(messagePrivoder == null) {
            throw new RuntimeException("You must set the property messageProvider of class: "
                + StandartOutMessageRendererV2.class.getName());
            //Вы должны установить свойство messageProvider класа
        }
        System.out.println(messagePrivoder.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messagePrivoder = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messagePrivoder;
    }
}
