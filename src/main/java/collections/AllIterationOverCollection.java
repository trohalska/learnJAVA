package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class AllIterationOverCollection {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        col.add("A");
        col.add("B");
        col.add("C");
        col.add("D");

        // (0)
        System.out.println(col);

        // (1)
        Iterator<String> it = col.iterator();
        while (it.hasNext()) {
            String el = it.next();
            System.out.print(el);
        }
        System.out.println();

        //(2)
        for (String el : col) {
            System.out.print(el);
        }
        System.out.println();

        // (3) <-- only for Lists !!!
//        for (int i = 0; i < col.size(); i++) {
//            String el = col.get(i);
//            System.out.print(el);
//        }
//        System.out.println();

        // (3.1)
        for (Object el : col.toArray()) {
            System.out.print(el);
        }
        System.out.println();

        // (3.2)
        for (String el : col.toArray(new String[] {})) {
            System.out.print(el);
        }
        System.out.println();

        System.out.println("~~~");

        // (4.1)
        col.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });
        System.out.println();

        // (4.2)
        col.forEach(s -> System.out.print(s));
        System.out.println();
        // (4.3)
        col.forEach(System.out::print); // reference on method
        System.out.println();





    }
}
