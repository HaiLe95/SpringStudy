package getstartin;

public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messagePrivoder;

    @Override
    public void render() {
        if( messagePrivoder == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class"
                    + StandartOutMessageRenderer.class.getName());
            //Мы должны установить свойство MessageProvider класса
        }
        System.out.println(messagePrivoder.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messagePrivoder = messageProvider;
    }

    @Override
    public MessageProvider getMessagePrivoder() {
        return messagePrivoder;
    }
}
