package com.ioc.appcontext;

import com.getstartin.MessageProvider;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloMessageProviderV2 implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
