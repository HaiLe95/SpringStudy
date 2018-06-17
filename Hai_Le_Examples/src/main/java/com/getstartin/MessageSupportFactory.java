package com.getstartin;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageRenderer messageRenderer;
    private MessageProvider messagePrivoder;

    private MessageSupportFactory() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(
                    "com/getstartin/msf.properties"));

            String renderedClass = properties.getProperty("rendered.class");
            String providerClass = properties.getProperty("provider.class");

            messageRenderer = (MessageRenderer) Class.forName(renderedClass).newInstance();
            messagePrivoder = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessagePrivoder() {
        return messagePrivoder;
    }
}
