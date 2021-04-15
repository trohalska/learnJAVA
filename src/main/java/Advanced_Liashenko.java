import java.util.*;
import java.util.stream.Collectors;

public class Advanced_Liashenko {
    public static void main(String[] args) {
        sortWithLambda();
    }

    private static void sortWithLambda() {
//        List<String> list = Arrays.asList("12", "3", "123", "8");
//        System.out.print(list);
////        Collections.sort(list, (a1,a2) -> a2 - a1);
//        Collections.sort(list, (a1, a2) -> a1.compareTo(a2));
//        System.out.println(list);
//
//        Map<String, Integer> namesMap = list.stream().distinct()
//                .collect(Collectors.toMap(s -> s, s -> 0));
//        System.out.println(namesMap);
//
//        Map<String, Long> counts = list.stream().collect(
//                Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(counts);

        Object[] objs = {1, "hgfdhjgdfsg", 3};
//        objs[0] = 8;
//        objs[1] = 2;
//        objs[2] = -14;
//        objs[3] = 4;

//        List<String> s = Arrays.stream(objs)
//                .map(Object::toString)
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(s);

        String[] str = new String[objs.length];
        Arrays.stream(objs)
                .map(Object::toString)
                .sorted()
                .collect(Collectors.toList())
                .toArray(str);

        System.out.println(Arrays.asList(str));

    }
}
