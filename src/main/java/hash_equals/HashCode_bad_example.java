package hash_equals;

public class HashCode_bad_example {
    char a, b;

    @Override
    public int hashCode() {
//        return a << 16 + b;   // wrong
        return (a << 16) + b;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HashCode_bad_example)) return false;
        HashCode_bad_example ex = (HashCode_bad_example) obj;
        return a == ex.a && b == ex.b;
    }
}
