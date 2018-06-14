package getstartin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageRenderer messageRenderer;
    private  MessagePrivoder messagePrivoder;

    private MessageSupportFactory() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(
                    "getstartin/msf.properties"));

            String renderedClass = properties.getProperty("rendered.class");
            String providerClass = properties.getProperty("provider.class");

            messageRenderer = (MessageRenderer) Class.forName(renderedClass).newInstance();
            messagePrivoder = (MessagePrivoder) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Впервые вижу такое
    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessagePrivoder getMessagePrivoder() {
        return messagePrivoder;
    }
}
