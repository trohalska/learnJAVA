package hash_equals.mapExeptions;

public class User {
    private boolean valid;

    User(boolean valid) { this.valid = valid; }

    boolean isValid() { return valid; }

    public boolean get() {
        return valid;
    }
}
