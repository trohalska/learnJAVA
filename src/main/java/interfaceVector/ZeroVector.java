package interfaceVector;

public class ZeroVector extends AbstractVector {
    public static final ZeroVector INSTANCE = new ZeroVector();

    private ZeroVector() {}

    @Override
    public double component(int n) {
        return 0;
    }

    @Override
    public double length() {
        return 0;
    }

    @Override
    public Vector plus(Vector other) {
        return other;
    }
}
