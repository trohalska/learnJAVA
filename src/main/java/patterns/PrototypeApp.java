package patterns;

/**
 * генерує клони самого себе (interface Cloneable - це прототип зі стандартної ліби)
 */
public class PrototypeApp {
    public static void main(String[] args) {

        Human origin = new Human(18, "Tanya");
        System.out.println(origin);

        Human copy = (Human)origin.copy();
        System.out.println(copy);

        HumanFactory humanFactory = new HumanFactory(copy);
        Human h1 = humanFactory.makeCopy();
        System.out.println(h1);

        humanFactory.setPrototype(new Human(30, "Masha"));
        Human h2 = humanFactory.makeCopy();
        System.out.println(h2);

    }
}

interface Copyable {
    Object copy();
}

class Human implements Copyable {
    int age;
    String name;
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }
    public void setPrototype(Human human) {
        this.human = human;
    }
    Human makeCopy() {
        return (Human) human.copy();
    }
}
