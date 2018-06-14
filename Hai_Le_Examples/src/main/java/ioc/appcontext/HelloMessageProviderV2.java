package ioc.appcontext;

import getstartin.MessagePrivoder;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloMessageProviderV2 implements MessagePrivoder {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
