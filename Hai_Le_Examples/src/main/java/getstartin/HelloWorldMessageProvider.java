package getstartin;

public class HelloWorldMessageProvider implements MessagePrivoder {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
