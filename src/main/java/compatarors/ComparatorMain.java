package compatarors;

import java.util.TreeSet;

public class ComparatorMain {
    public ComparatorMain() {
        UserString c1 = new UserString("masha", 6);
        UserString c2 = new UserString("masha", 6);
        System.out.println(c1.compareTo(c2));     // 6

//        System.out.println(USER_STRING_COMPARATOR)


        TreeSet<UserBool> set = new TreeSet<>();
        UserBool u = new UserBool(true);
        set.add(u);
        set.add(u);
        System.out.println(set);  // [true]
    }
}
