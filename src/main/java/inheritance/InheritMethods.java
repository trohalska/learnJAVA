package inheritance;

public class InheritMethods {
    public static class A {
        String getName() {
            return "A";
        }
        static class B extends A {
            String getName() {
                return "B";
            }
        }
    }

    public InheritMethods() {
        A.B b = new A.B();
        A a = (A) b;
        System.out.println(a.getName() + "," + b.getName());   // result B,B
    }
}
