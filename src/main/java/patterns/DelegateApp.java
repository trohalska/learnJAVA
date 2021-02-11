package patterns;

public class DelegateApp {
    public static void main(String[] args) {
//        A a = new A();
//        B b = new B();
//        a.f();
//        b.f();

        Painter painter = new Painter();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();
    }
}

/**
 * класс В делегирует свои полномочия классу А
 */
class A {
    void f() {
        System.out.println("f()");
    }
}
class B {
    A a = new A();
    void f() {
        a.f();
    }
}

/**
 * більш складний приклад
 */
interface Graphics {
    void draw();
}
class Triangle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing triangle...");
    }
}
class Square implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing square...");
    }
}
class Circle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }
}
class Painter {
    Graphics graphics;
    void setGraphics(Graphics g) {
        graphics = g;
    }
    void draw() {
        graphics.draw();
    }
}



