package compatarors;

import java.util.Comparator;

public class User implements Comparable<User> {
    private final String name;
    private final int age;

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {  // @NotNull
        int res = name.compareTo(o.name);
        return res == 0 ? Integer.compare(this.age, o.age) : res;
    }

    public String toString() {
        return name + ": " + age;
    }


    /** то же самое, но используя обычную ламбду выражение !!! */

    static final Comparator<User> USER_COMPARATOR = (u1, u2) -> {
        int res = u1.getName().compareTo(u2.getName());
        return res == 0 ? Integer.compare(u1.getAge(), u2.getAge()) : res;
    };


    /** то же самое, но используя ламбда выражения */

    // сравнивает по имени, потом по age
    static final Comparator<User> USER_COMPARATOR1 =
            Comparator.comparing((User u) -> u.getName())
                    .thenComparingInt(u -> u.getAge());

    // сравнивает по имени в обратном порядке (начиная з имен на z), потом по age в прямом порядке
    static final Comparator<User> USER_COMPARATOR2 =
            Comparator.comparing((User u) -> u.getName(), Comparator.reverseOrder())
                    .thenComparingInt(u -> u.getAge());

    // сравнивает по имени без учета регистра (Ваня == ваня), потом по age
    static final Comparator<User> USER_COMPARATOR3 =
            Comparator.comparing((User u) -> u.getName(), String.CASE_INSENSITIVE_ORDER)
                    .thenComparingInt(u -> u.getAge());

    // если среди пользователей есть (UserString u = null), то nullFirst вытаскивает их вперед, nullLast - назад
    // теперь компаратор может обрабатывать null значения
    static final Comparator<User> USER_COMPARATOR4 =
            Comparator.nullsFirst(
                    Comparator.comparing((User u) -> u.getName(), String.CASE_INSENSITIVE_ORDER)
                            .thenComparingInt(u -> u.getAge()));

    // если среди пользователей есть (u.name = null), то nullFirst вытаскивает их вперед, nullLast - назад
    static final Comparator<User> USER_COMPARATOR5 =
            Comparator.comparing((User u) -> u.getName(), Comparator.nullsFirst(Comparator.naturalOrder()))
                            .thenComparingInt(u -> u.getAge());


    /** то же самое, но используя ссылки на методы вместо ламбда выражений */

    static final Comparator<User> USER_COMPARATOR01 =
            Comparator.comparing(User::getName).thenComparingInt(User::getAge);

    static final Comparator<User> USER_COMPARATOR02 =
            Comparator.comparing(User::getName, Comparator.reverseOrder()).thenComparingInt(User::getAge);

    static final Comparator<User> USER_COMPARATOR03 =
            Comparator.comparing(User::getName, String.CASE_INSENSITIVE_ORDER).thenComparingInt(User::getAge);

    static final Comparator<User> USER_COMPARATOR04 =
            Comparator.nullsFirst(Comparator.comparing(User::getName).thenComparingInt(User::getAge));

    static final Comparator<User> USER_COMPARATOR05 =
            Comparator.comparing(User::getName, Comparator.nullsFirst(Comparator.naturalOrder()))
                    .thenComparingInt(User::getAge);
}
