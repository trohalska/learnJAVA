package patterns;

/**
 * зберігає одну ссилку на компонент(інтерфейс)
 * і доповнює основний функціонал через наслідування інтерфейса і доповнення
 */
public class DecoratorApp {
    public static void main(String[] args) {

//        PrinterInterface printer = new Printer("Hello");
//        printer.print();

//        PrinterInterface printer = new QuotesDecorator(new Printer("Hello"));
//        printer.print();

        PrinterInterface printer = new QuotesDecorator(new LeftDecorator(new RightDecorator(new Printer("Hello"))));
        printer.print();
    }
}

/**
 * This is main interface
 */
interface PrinterInterface {
    void print();
}

/**
 * this is clients class
 */
class Printer implements PrinterInterface {
    String value;
    public Printer(String value) { this.value = value; }
    @Override
    public void print() {
        System.out.print(value);
    }
}

/**
 * this is DECORATOR abstract class
 * usually does not use, because there is only one decorator
 */
abstract class Decorator implements PrinterInterface {
    PrinterInterface component;
    public Decorator(PrinterInterface component) { this.component = component; }
    public void print() {
        component.print();
    }
}

/**
 * those are sub decorators
 */
class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
class LeftDecorator extends Decorator {
    public LeftDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
class RightDecorator extends Decorator {
    public RightDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}
