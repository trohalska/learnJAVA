package functional_Interface;

@FunctionalInterface
public interface LongSupplier {
    long getLong();
}

@FunctionalInterface
interface IntSupplier extends LongSupplier {
    int getInt();

    @Override
    default long getLong() {
        return getInt();
    }
}
