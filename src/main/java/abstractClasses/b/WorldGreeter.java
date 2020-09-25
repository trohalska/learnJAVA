package abstractClasses.b;

import abstractClasses.a.AbstractGreeter;

public class WorldGreeter extends AbstractGreeter {
    public WorldGreeter() {
        super("World");
    }

    public void test() {
        this.hello();
        super.hello();
//        other.hello();   // не можемо використовувати таке звернення
    }
}
