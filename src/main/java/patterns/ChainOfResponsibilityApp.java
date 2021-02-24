package patterns;

/**
 * получают сообщение и передают по цепочке хендлеров,
 * кажый из которых сам обрабатывает по-своему и  передает дальше
 */
public class ChainOfResponsibilityApp {
    public static void main(String[] args) {

        AbstractLogger logger0 = new SMSLogger(Level.ERROR);
        AbstractLogger logger1 = new FileLogger(Level.DEBUG);
        AbstractLogger logger2 = new EmailLogger(Level.INFO);

        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("all good", Level.INFO);
        logger0.writeMessage("debugging", Level.DEBUG);
        logger0.writeMessage("error", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

/**
 * ONE BLOCK OF CHAIN
 */
interface Logger {
    void writeMessage(String message, int level);
}
/**
 * ONE BLOCK OF CHAIN WITH ABSTRACT
 */
abstract class AbstractLogger implements Logger {
    int priority;
    public AbstractLogger(int priority) {
        this.priority = priority;
    }

    Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}

class SMSLogger extends AbstractLogger {
    public SMSLogger(int priority) {
        super(priority);
    }
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}
class FileLogger extends AbstractLogger {
    public FileLogger(int priority) {
        super(priority);
    }
    public void write(String message) {
        System.out.println("Write to file: " + message);
    }
}
class EmailLogger extends AbstractLogger {
    public EmailLogger(int priority) {
        super(priority);
    }
    public void write(String message) {
        System.out.println("Email msg: " + message);
    }
}