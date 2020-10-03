package varargs;

import jenerics.Shmoption;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        printAll("a", 1, "b", 2.0);

        Object[] objects = {"a", 1, "b", 2.0};
        printAll(objects);

        printAll(null, null);   // массив из двух элементов
//        printAll(null);         // массив == null, ошибка

        String s = "bar";
        boolean res = isOneOf(s, "foo", "bar");
        System.out.println(res);

        validateGender("Male");
    }

    static void printAll (Object... objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    /** varargs + generics */

    @SafeVarargs
    static <T> boolean isOneOf(T value, T... options) {
        for (T opt : options) {
            if (Objects.equals(value, opt)) {
                return true;
            }
        }
        return false;
    }

    static void validateGender(String gender) {
        if (!isOneOf(gender, "Male", "Female")) {
            throw new IllegalArgumentException("Wrong gender: " + gender);
        }
    }
}
