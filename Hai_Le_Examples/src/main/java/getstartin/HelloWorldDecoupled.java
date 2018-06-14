package getstartin;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandartOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
