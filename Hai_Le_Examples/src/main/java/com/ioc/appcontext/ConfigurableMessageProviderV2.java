package com.ioc.appcontext;

import com.getstartin.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProviderV2 implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProviderV2(@Value("Configurable message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
