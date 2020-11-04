package hash_equals;

public class HashCode {
    private Integer a, b, c;

    public HashCode(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println(hashCode());
    }

    @Override
    public int hashCode() {
        int res = a != null ? a.hashCode() : 0;
        res = 31 * res + (b != null ? b.hashCode() : 0);
        res = 31 * res + (c != null ? c.hashCode() : 0);
        return res;
    }
}
