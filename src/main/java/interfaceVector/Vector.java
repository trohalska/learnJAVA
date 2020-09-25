package interfaceVector;

/**
 * Represents an immutable 3D-vector
 */
public interface Vector {
    /**
     * Returns a vector component
     * @param n component number, must be 0 (X), 1 (Y) or 2 (Z)
     * @return a value of the corresponding vector
     */
    double component(int n);
    /**
     * @return a vector length
     */
    double length();
    /**
     * Sum two vectors
     * @param other a vector to add to this vector
     * @return a result of addition
     */
    Vector plus(Vector other);

    /**
     * Returns a string representation of vector
     * which looks like (X, Y, Z)
     */
    @Override
    String toString();

    @Override
    boolean equals(Object obj);
}
