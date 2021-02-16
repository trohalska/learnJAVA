package patterns;

/**
 * всередині використовує кілька фабричних методів
 */
public class AbstractFactoryApp {
    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("ua"); // en
        Mouse m     = factory.getMouse();
        Keyboard k  = factory.getKeyboard();
        Touchpad t  = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);

    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "ua":
            case "UA":
                return new UaDeviceFactory();
            case "en":
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code: " + lang);
        }
    }
}

/**
 * наші три продукта
 */
interface Mouse {
    void click( );
    void dblclick();
    void scroll(int direction);
}
interface Keyboard {
    void print();
    void println();
}
interface Touchpad  {
    void track(int deltaX, int deltaY);
}

/**  Ukrainian devices */
class UaMouse implements Mouse {
    public void click() {
        System.out.println("Клік");
    }
    public void dblclick() {
        System.out.println("Подвійниц клік");
    }
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Скроллим вгору");
        else if (direction < 0)
            System.out.println("Скроллим вниз");
        else
            System.out.println("Не скроллим");
    }
}
class UaKeyboard implements Keyboard {
    public void print() {
        System.out.println("Друкуємо строку");
    }
    public void println() {
        System.out.println("Друкуємо строку з переводом строки");
    }
}
class UaTouchpad implements Touchpad {
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Пересунулись на " + s + " пікселів");
    }
}
/**  English devices */
class EnMouse implements Mouse {
    public void click() {
        System.out.println("Click");
    }
    public void dblclick() {
        System.out.println("Double click");
    }
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Scroll up");
        else if (direction < 0)
            System.out.println("Scroll down");
        else
            System.out.println("No scrolling");
    }
}
class EnKeyboard implements Keyboard {
    public void print() {
        System.out.println("Print");
    }
    public void println() {
        System.out.println("Print line");
    }
}
class EnTouchpad implements Touchpad {
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved on " + s + " pixels");
    }
}

/**
 *  out FACTORY
 */
interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
class UaDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new UaMouse();
    }
    public Keyboard getKeyboard() {
        return new UaKeyboard();
    }
    public Touchpad getTouchpad() {
        return new UaTouchpad();
    }
}
class EnDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new EnMouse();
    }
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}



