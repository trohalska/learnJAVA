package abstractClasses.a;

public class AbstractGreeter {
    private final String recipient;

    protected AbstractGreeter(String recipient) {
        this.recipient = recipient;
    }

    protected void hello() {
        System.out.println("Hello " + recipient + "!");
    }
}
