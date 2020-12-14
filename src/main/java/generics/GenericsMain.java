package generics;

public class GenericsMain {
    public GenericsMain() {
        System.out.println("----------- 0");

        Shmoption<String> present = new Shmoption<>("yes");
        Shmoption<String> absent = new Shmoption<>(null);
        System.out.println(present.isPresent());
        System.out.println(present.get());
        System.out.println(absent.isPresent());
        System.out.println(absent.orElse("no"));

        System.out.println("----------- 1");

        /** var replace any type (in this case it becomes String and smth for null */
        var present1 = new Shmoption<>("yes");
        var absent1 = new Shmoption<>(null);
        System.out.println(present1.orElse("no").length());
//        System.out.println(absent1.orElse("no").length());  // can't do it

        System.out.println("----------- 2");

        /** wildcard (? replace any type) */
        Shmoption<?> present2 = new Shmoption<>("yes");
        System.out.println(present2.isPresent());
        System.out.println(present2.get());

        Object value = present2.get();
        System.out.println(value);
//        present2.set("ff");  // can't set value in <?> -> error: capture of ?
        present2.set(null); // this is THE ONLY WAY to set Shmoption<?>

        System.out.println("----------- 3");

        /** Object */
        Shmoption<Object> present3 = new Shmoption<>("yes");
        System.out.println(present3.isPresent());
        Object value3 = present3.get();
        System.out.println(value3);
        present3.set(123);  // can set in Object any type

        System.out.println("----------- 4");

        /** ? extends Object */
        Shmoption<? extends Number> present4 = new Shmoption<>(123);
        System.out.println(present4.isPresent());
//        present4.set(456);  // can set in Number because it can be int, double etc
    }
}
