package compatarors;

import java.util.Comparator;

public class UserString implements Comparable<UserString> {
    private final String name;
    private final int age;

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public UserString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(UserString o) {  // @NotNull
        int res = name.compareTo(o.name);
        return res == 0 ? Integer.compare(this.age, o.age) : res;
    }

    public String toString() {
        return name + ": " + age;
    }

    // lambda!
    static final Comparator<UserString> USER_STRING_COMPARATOR = (u1, u2) -> {
        int res = u1.getName().compareTo(u2.getName());
        return res == 0 ? Integer.compare(u1.getAge(), u2.getAge()) : res;
    };
}
