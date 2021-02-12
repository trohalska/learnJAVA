package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * це сумка, яка може в собі містити елементи та інші сумки
 */
public class CompositeApp {
    public static void main(String[] args) {

        Shape square1 = new SquareShape();
        Shape square2 = new SquareShape();
        Shape triangle1 = new TriangleShape();

        Shape square3 = new SquareShape();
        Shape circle1 = new CircleShape();
        Shape circle2 = new CircleShape();
        Shape circle3 = new CircleShape();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        // first composite with nodes
        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        // second composite with nodes
        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        // third composite with composites inside
        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new TriangleShape());

        composite.draw();
    }
}

interface Shape {
    void draw();
}

class SquareShape implements Shape {
    public void draw() {
        System.out.println("I'm square!");
    }
}
class TriangleShape implements Shape {
    public void draw() {
        System.out.println("I'm triangle!");
    }
}
class CircleShape implements Shape {
    public void draw() {
        System.out.println("I'm circle!");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }
    public void removeComponent(Shape component) {
        components.remove(component);
    }
    // this is MAIN method that helps us get all that inside
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}