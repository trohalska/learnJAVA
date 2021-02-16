package patterns;

/**
 * Допомагає звязати дві структури характеристик через ссилку
 */
public class BridgeApp {
    public static void main(String[] args) {
        Cars car = new Sedan(new Kia());
        car.showDetails();
        Cars car2 = new Mers(new Skoda());
        car2.showDetails();
        Cars car3 = new Sedan(new Vagon());
        car3.showDetails();
    }
}
/** first structure */
abstract class Cars {
    Make make; //   ---- > THIS IS BRIDGE
    public Cars(Make m) {
        make = m;
    }
    abstract void showType();   // ---- > pattern template method
    void showDetails() {
        showType();
        make.setMake();
    }

}
class Sedan extends Cars {
    public Sedan(Make m) { super(m); }
    void showType() {
        System.out.print("Sedan ");
    }
}
class Mers extends Cars {
    public Mers(Make m) { super(m); }
    void showType() {
        System.out.print("Mers ");
    }
}
/** second structure */
interface Make {
    void setMake();
}
class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}
class Skoda implements Make {
    public void setMake() {
        System.out.println("Skoda");
    }
}
class Vagon implements Make {
    public void setMake() {
        System.out.println("Vagon");
    }
}
