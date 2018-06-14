package getstartin;

public class StandartOutMessageRenderer implements MessageRenderer {
    private MessagePrivoder messagePrivoder;

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
    public void setMessageProvider(MessagePrivoder messageProvider) {
        this.messagePrivoder = messageProvider;
    }

    @Override
    public MessagePrivoder getMessagePrivoder() {
        return messagePrivoder;
    }
}
