package collections;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class List {

    public List() {
//        System.out.println(rangeSet(10,20).contains(10));
//        System.out.println(rangeSet(10,20).contains(20));
//        System.out.println(rangeSet(10,20));
//
//        // якщо цей метод наслідуваний довго буде, оскільки перевірить все по черзі
//        System.out.println(rangeSet(0,Integer.MAX_VALUE).contains(-1));
    }

    static AbstractList<Integer> rangeList(int fromInclusive, int toExclusive) {
        return new AbstractList<Integer>() {

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
        };
    }
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
