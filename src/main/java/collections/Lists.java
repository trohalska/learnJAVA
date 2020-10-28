package collections;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lists {

    public Lists() {
        System.out.println(rangeList(10,20).contains(10));      // true
        System.out.println(rangeList(10,20).contains(20));      // false
        System.out.println(rangeList(10,20));                   // 10,11,12, 13,14,15,16,17,18,19
        System.out.println(rangeList(10,20).get(0));            // 10
        System.out.println(rangeList(10,20).subList(3, 7));     // 13,14,15,16

        // якщо цей метод наслідуваний довго буде, оскільки перевірить все по черзі
//        System.out.println(rangeList(0,Integer.MAX_VALUE).contains(-1));
    }

//    static List<Integer> rangeList(int fromInclusive, int toExclusive) {
//        return new AbstractList<Integer>() {
//
//            @Override
//            public Integer get(int index) {
//                if (index < 0 || index >= size())
//                    throw new IndexOutOfBoundsException(index);
//                return fromInclusive + index;
//            }
//
//            @Override
//            public int size() {
//                return toExclusive - fromInclusive;
//            }
//        };
//    }

    static List<Integer> rangeList(int fromInclusive, int toExclusive) {
        return new RangeList(fromInclusive, toExclusive);
    }
    private static class RangeList extends AbstractList<Integer> implements RandomAccess {
        private int fromInclusive;
        private int toExclusive;

        RangeList(int fromInclusive, int toExclusive) {
            this.fromInclusive = fromInclusive;
            this.toExclusive = toExclusive;
        }

        @Override
        public boolean contains(Object o) {
            return o instanceof Integer &&
                    (Integer) o >= fromInclusive &&
                    (Integer) o < toExclusive;
        }
        @Override
        public int indexOf(Object o) {
            if (contains(o)) {
                return ((Integer) o) - fromInclusive;
            }
            return -1;
        }
        @Override
        public int lastIndexOf(Object o) {
            return indexOf(o);
        }
        @Override
        public AbstractList<Integer> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0)
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            if (toIndex > size())
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            if (fromIndex > toIndex)
                throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
            return new RangeList(fromInclusive + fromIndex, fromInclusive + toIndex);
        }

        @Override
        public Stream<Integer> stream() {
            return IntStream.range(fromInclusive, toExclusive).boxed();
        }
        @Override
        public Stream<Integer> parallelStream() {
            return stream().parallel();
        }

        @Override
        public Integer get(int index) {
            if (index < 0 || index >= size())
                throw new IndexOutOfBoundsException(index);
            return fromInclusive + index;
        }
        @Override
        public int size() {
            return toExclusive - fromInclusive;
        }
    }

//    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
//        if (c == null)
//            return binarySearch((List<? extends Comparable<? super T>>) list, key);
//        if (list instanceof RandomAccess || list.size() < BINARYSEARCH_THRESHOLD)  // BINARYSEARCH_THRESHOLD = 5000
//            return Collection.indexedBinarySearch(list, key, c);
//        else
//            return Collection.iteratorBinarySearch(list, key, c);
//    }
}

    /*** METHODS  LIST
     *
     *  boolean addAll(int index, Collection<? extends E> c)    - вставляє коллекцію в колекцію
     *  void sort(Comparator<? super E> c)                      - сортування
     *  E get(int index)                                        - отримати елемент по індексу
     *  E set(int index, E element)                             - вставити елемент по індексу
     *  void add(int index, E element)                          - додає елемент по індексу
     *  E remove(int index)                                     - видаляє по індексу
     *  int indexOf(Object o)                                   - знаходить індекс входження обєкта
     *  int lastIndexOf(Object o)                               - ... з кінця
     *  ListIterator<E> listIterator()                          - розширений ітератор (ходить вперед-назад, дістає елементи і тп)
     *  ListIterator<E> listIterator(int index)                 - розширений ітератор з потрібної позиції
     *  List<E> sublist(int formIndex, int toIndex)             - взяти кусочок ліста (копіювати чи вирізати ??? )
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
