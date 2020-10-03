package jenerics;

public class InheritanceJenerics {
    public static void main(String[] args) {
        System.out.println("-----------");

        /** НАСЛЕДОВАНЕ */
        NumberShmoption<?> number = new NumberShmoption<>(123);
        Number n = number.get();
//        number.set(456);  // can't do it
        System.out.println(n);

        IntegerShmoption integer = new IntegerShmoption(123);
        Integer i = integer.get();
        integer.set(456);
        /** переприсвоєння NumberShmoption = IntegerShmoption */
        number = integer;
        System.out.println(i);
        System.out.println(number.get());

        System.out.println("-----------");

        /** ЧТЕНИЕ (producer - extends) */
        double d = getDoubleValue(new IntegerShmoption(123)); // because <? extends Number>
        System.out.println(d);


        /** ЗАПИСЬ (consumer - super) */
        NumberShmoption<Number> s = new NumberShmoption<>(123.45);
        System.out.println(s.get());
        setInteger(s);  // because <? super Number>
        System.out.println(s.get());

        System.out.println("-----------");

        /** ПРЕОБРАЗОВАНИЕ ТИПОВ */
        Shmoption<Integer> integer1 = new Shmoption<>(10);
//        Shmoption<String> string = ((Shmoption<String>) integer1); // error, разные типы
        Shmoption<?> any = integer1;
        Shmoption<String> string1 = (Shmoption<String>) any;  // можно но с предупреждением от копилятора
//        String string2 = string1.get(); // ClassCastException
//        NumberShmoption<Integer> integer2 = (NumberShmoption<Integer>) integer1; // можно


        /** ДЖЕНЕРИКИ И МАССИВЫ */
        Shmoption<?>[] array = new Shmoption<?>[10]; // еще нормально
//        Shmoption<Integer>[] arrayInt = new Shmoption<Integer>[10];  // нельзя

        Shmoption<Integer>[] arrayInt = new Shmoption[10]; // можно но с предупреждением
        /** в такой массив можно записать сроку,
         * но при доставании все взорвется - ожидался то инт :
         * */
//        Object[] obj = arrayInt;
//        obj[0] = new Shmoption<>("foo");
//        Shmoption<Integer> shmopt = arrayInt[0];
//        Integer x = shmopt.get();
//        System.out.println(x);



    }

    /** НАСЛЕДОВАНЕ */
    static class NumberShmoption<N extends Number> extends Shmoption<N> {
        public NumberShmoption(N value) {
            super(value);
        }
    }
    static class IntegerShmoption extends NumberShmoption<Integer> {
        public IntegerShmoption(Integer value) {
            super(value);
        }
    }

    /** ЧТЕНИЕ (producer - extends)
     * этот метод дает возможность доставать с класса,
     * но при этом записывать проблематично - set() не работает
     * */
    static double getDoubleValue(Shmoption<? extends Number> shmopt) {
        return shmopt.get().doubleValue();
    }
    /** ЗАПИСЬ (consumer - super)
     * этот метод дает возможность записывть в класс,
     * но при этом читать проблематично - get() не работает
     * */
    static void setInteger(Shmoption<? super Integer> shmopt) {
        shmopt.set(42);
    }

    /** Covariant Return Types */

    public interface Supplier {
        Object get();
    }
    public interface StringSupplier extends Supplier {
        @Override
        String get();
        // Supplier возвращает объект, но его наследник может возвращать конкретно String
    }
}
