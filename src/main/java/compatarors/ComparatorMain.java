package compatarors;

import java.util.ArrayList;
import java.util.TreeSet;

public class ComparatorMain {
    public ComparatorMain() {
        UserStr c11 = new UserStr("sasha");
        UserStr c12 = new UserStr("masha");
        System.out.println(c11.compareTo(c12));     // 6

        // bool
        TreeSet<UserBool> set = new TreeSet<>();
        UserBool u = new UserBool(true);
        set.add(u);
        set.add(u);
        System.out.println(set);  // [true]

        // User
        User c1 = new User("sasha", 6);
        User c2 = new User("masha", 6);
        System.out.println(c1.compareTo(c2));     // 6

        // comparators
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("masha", 6));
        list.add(new User("sasha", 8));
        list.add(null);
        list.add(new User("dasha", 14));
        list.sort(User.USER_COMPARATOR04);
        System.out.println(list.toString());
    }
}
