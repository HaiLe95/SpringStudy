package ioc.appcontext;

import getstartin.MessagePrivoder;
import getstartin.MessageRenderer;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandartOutMessageRendererV2 implements MessageRenderer {
    private MessagePrivoder messagePrivoder;

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
    public void setMessageProvider(MessagePrivoder provider) {
        this.messagePrivoder = provider;
    }

    @Override
    public MessagePrivoder getMessagePrivoder() {
        return this.messagePrivoder;
    }
}
