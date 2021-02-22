package patterns;

/**
 * через visitor буде доступ до кузова або двигуна (класів)
 */
public class VisitorApp {
    public static void main(String[] args) {

//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        Visitor hooligan = new HooliganVisitor();
//        Visitor mechanic = new MechanicVisitor();
//        body.accept(hooligan);
//        engine.accept(hooligan);
//        body.accept(mechanic);
//        engine.accept(mechanic);

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

/**
 * VISITOR
 */
interface Visitor {
    void visit(BodyElement body);
    void visit(EngineElement engine);
    void visit(WheelElement wheel);
    void visit(CarElement car);
}

/**
 * ELEMENTS
 */
interface Element {
    void accept(Visitor visitor);
}
class BodyElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class EngineElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class CarElement implements Element {
    Element[] wheels;

    public CarElement() {
        this.wheels = new Element[] {
                new WheelElement("front left"),
                new WheelElement("front right"),
                new WheelElement("back left"),
                new WheelElement("back right"),
                new BodyElement(),
                new EngineElement() };
    }
    public void accept(Visitor visitor) {
        for (Element w : wheels) {
            w.accept(visitor);
        }
        visitor.visit(this);
    }
}

/**
 * USERS who had access to engine and body
 */
class HooliganVisitor implements Visitor {
    public void visit(BodyElement body) {
        System.out.println("Break engine");
    }
    public void visit(EngineElement engine) {
        System.out.println("Break body");
    }
    public void visit(WheelElement wheel) { System.out.println("Punch " + wheel.getName() + " wheel"); }
    public void visit(CarElement car) { System.out.println("Smoke inside"); }
}
class MechanicVisitor implements Visitor {
    public void visit(BodyElement body) {
        System.out.println("Check engine");
    }
    public void visit(EngineElement engine) {
        System.out.println("Polish body");
    }
    public void visit(WheelElement wheel) { System.out.println("Repair " + wheel.getName() + " wheel"); }
    public void visit(CarElement car) { System.out.println("Check inside of the car"); }
}

