package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMaps {
    public MultiMaps() {
//        Map<String, String> m2 = new HashMap<>();
//        m2.put("one", "        foo   ");
//        m2.put("two", "   gg tt  ");
//        m2.put("three", "   3     ");
    }

    /** MultiMap - с листом в значениях, изменяемый и дополняемый */
    Map<String, List<String>> multiMap = new HashMap<>();

    public void addOld(String key, String value) {
        List<String> list = multiMap.get(key);
        if (list == null) {
            list = new ArrayList<>();
            multiMap.put(key, list);
        }
        list.add(value);
    }
    public void add(String key, String value) {
        multiMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    /** Multi-set/bag - множество с повторяемыми значениями */
    Map<String, Integer> counts = new HashMap<>();

    public void addOld(String key) {
        Integer count = counts.get(key);
        if (count == null) {
            count = 0;
        }
        counts.put(key, count + 1);
    }
    public void add(String key) {
        counts.merge(key, 1, (a, b) -> a + b);
    }
}
