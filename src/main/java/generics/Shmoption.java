package generics;

import java.util.NoSuchElementException;

/** A mutable box which is either empty or contains a not-null value  */
public class Shmoption<T> {
    T value;
    /** Passing nul means absent value */
    public Shmoption(T value) {
        this.value = value;
    }

    /** Never returns null */
    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public void set(T newValue) {
        value = newValue;
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public boolean isPresent() {
        return value != null;
    }

}
