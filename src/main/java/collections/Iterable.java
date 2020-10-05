package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterable<T> {
     /**
     * THEORY
     * printAll === printAll1
     * */
//    void printAll(Iterable<?> iterable) {
//        Iterator<?> iterator = iterable.iterator();
//        while (iterator.hasNext()) {
//            Object obj = iterator.next();
//            System.out.println(obj);
//        }
//    }
//    void printAll1(Iterable<?> iterable) {
//        for (Object obj : iterable) {
//            System.out.println(obj);
//        }
//    }
//
//    void removeEmpty(Iterable<String> iterable) {
//        Iterator<String> iterator = iterable.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().isEmpty()) {
//                iterator.remove();
//            }
//        }
//    }

    static <T> Iterable<T> nCopies(T value, int count) {
        if (count < 0)
            throw new IllegalArgumentException("Negative count: " + count);
        return new Iterable<T>() {
//            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int res = count;
                    @Override
                    public boolean hasNext() {
                        return res > 0;
                    }
                    @Override
                    public T next() {
                        if (res-- == 0)
                            throw new NoSuchElementException();
                        return value;
                    }
                };
            }
        };
    }

    /** METHODS
     *
     *  int size()                                  - вертає розмір коллекції (int)
     *  boolean isEmpty();                          - true (empty), false (not empty) пріоритетніше за size
     *  boolean contains(Object o)                  - перевіряє чи обєкт входить в коллекцію (уважно до типа)
     *  Object[] toArray()                          - створити массив обєктів
     *  <T> T[] toArray(T[] a)                      - створити типізований массив обєктів, можна передавати T[]a пустий
     *                                                  а фушкція сама створить копію потрібного розміру
     *
     *  boolean add(E e)                            - додає / може кинути exception
     *  boolean remove(Object o)                    - видаляє / може кинути exception
     *  boolean containsAll(Collection<?> c)        - перевіряє чи є всі елементи з переданої колекції в тій, що перевіряється
     *  boolean addAll(Collection<? extends E> c)   - додає елементи до коллекції
     *  boolean removeAll(Collection<?> c)          - видалить всі елементи з колекції, які співпадають з переданими
     *  boolean retainAll(Collection<?> c)          - збереже всі елементи в колекції, які співпадають з переданими
     *  void clear();                               - очистить колекцію
     * */
}
