package getstartin;

public interface MessageRenderer {

    void render();

    void setMessageProvider(MessagePrivoder provider);

    MessagePrivoder getMessagePrivoder();

}
