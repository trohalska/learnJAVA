package collections;

import java.lang.reflect.Array;
import java.util.*;

public class Maps {
    public Maps() {
//        Map<String, Integer> m = new HashMap<>();
//        m.put("one", 1);
//        m.put("two", 2);
//        m.put("three", 3);
//        iterateOverMap(m);

//        Map<String, String> m2 = new HashMap<>();
//        m2.put("one", "        foo   ");
//        m2.put("two", "   gg tt  ");
//        m2.put("three", "   3     ");
//        trimAllValues(m2);
//        removeUnwantedValues3(m2);
//        iterateOverMap(m2);

        Map<Integer, String> mg = getIntegerToStringMap(10);
        iterateOverMap(mg);
    }

    public static Map<Integer, String> getIntegerToStringMap(int count) {
        return new AbstractMap<Integer, String>() {

            @Override
            public boolean containsKey(Object key) {
                return key instanceof Integer && ((Integer) key) >= 0 && ((Integer) key) < count;
            }

            @Override
            public String get(Object key) {
                return containsKey(key) ? key.toString() : null;
            }

            @Override
            public Set<Entry<Integer, String>> entrySet() {
                return new AbstractSet<Entry<Integer, String>>() {
                    @Override
                    public Iterator<Entry<Integer, String>> iterator() {
                        return new Iterator<Entry<Integer, String>>() {
                            int next = 0;

                            @Override
                            public boolean hasNext() {
                                return next < count;
                            }

                            @Override
                            public Entry<Integer, String> next() {
                                if (next == count) throw new NoSuchElementException();
                                return new AbstractMap.SimpleImmutableEntry<>(next, String.valueOf(next++));
                            }
                        };
                    }

                    @Override
                    public int size() {
                        return count;
                    }
                };
            }
        };
    }

    /** обхід колекції */
//    public void iterateOverMapOld(Map<String, Integer> map) {
//        for (var entry : map.entrySet()) {  // for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key + " -> " + value);
//        }
//    }
//    public void iterateOverValuesOld(Map<String, Integer> map) {
//        for (Integer value : map.values()) {
//            System.out.println("Value: " + value);
//        }
//    }
    public void iterateOverMap(Map<? extends Object, ? extends Object> map) {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    /** модифікація */
//    public void trimAllValuesOld(Map<String, String> map) {
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            entry.setValue(entry.getValue().trim());
//        }
//    }
    public void trimAllValues(Map<String, String> map) {
        map.replaceAll((key, value) -> value.trim());
    }

    /** видалення значень */
//    public void removeUnwantedValuesOld(Map<String, String> map) {
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry<String, String> entry = iterator.next();
//            if (entry.getValue().equals("foo") || entry.getValue().equals("bar")) {
//                iterator.remove();
//            }
//        }
//    }
    public void removeUnwantedValues(Map<String, String> map) {
        map.entrySet().removeIf(entry ->
                entry.getValue().equals("foo") ||
                entry.getValue().equals("bar"));
    }
    public void removeUnwantedValues2(Map<String, String> map) {
        map.values().removeIf(value -> value.equals("foo") || value.equals("bar"));
    }
    // -------------
    private static final List<String> UNWANTED_VALUES = List.of("foo", "bar", "3");

    public void removeUnwantedValues3(Map<String, String> map) {
        map.values().removeAll(UNWANTED_VALUES);
    }





}


/** METHODS  MAP
 *
 *** не класти null в ячейки колекції - будуть помилки
 *
 *  int size()
 *  boolean isEmpty()
 *  boolean containsKey(Object key)
 *  boolean containsValue(Object value)         - обережно дуже повільна
 *  V get(Object key)                           - вертає значення або null, якщо не найдене, підвох - null може бути в ячейці
 *  V put(K key, V value)
 *  V remove(Object key)
 *  void putAll(Map<? extends K, ? extends V> m)
 *  void clear()
 *  Set<K> keySet()                             - вертається Set колекція ключів
 *  Collection<V> values()                      - вертається колекція значень
 *  Set<Map.Entry<K, V>> entrySet()             - вертається Set колекція записів
 *  V getOrDefault(Object key, Object value)    - отримати значення, або видати дефолтне, якщо не знайдене
 *  V putIfAbsent(K key, V value)               - покласти якщо не було (якщо в ячейці null, то перезапише)
 *  boolean remove(Object key, Object value)
 *  boolean replace(K key, V oldValue, V newValue)
 *  V replace(K key, V value)
 *
 *
 ***  METHODS  LISTITERATOR  // стоїть якби між елементами коллекції
 *
 * boolean hasPrevious()            - чи є попередній елемент
 * E previous()                     - ітератор рухається вліво (в сторону голови)
 * int nextIndex()                  - отримати індекс наступного
 * int previousIndex()              - отримати індекс попереднього
 * void set(E e)                    - вставити елемент
 * void add(E e)                    - додати елемент
 *
 * */
