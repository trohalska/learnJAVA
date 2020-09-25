package interfaceVector;

abstract class AbstractVector implements Vector {
    @Override
    public String toString() {
        return "(" + component(0) + ", " +
                component(1) + ", " + component(2) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector)) return false;
        Vector that = (Vector) obj;
        return (this.component(0) == that.component(0) &&
                this.component(1) == that.component(1) &&
                this.component(2) == that.component(2));
    }
}
