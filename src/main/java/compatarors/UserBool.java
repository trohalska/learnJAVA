package compatarors;

public class UserBool implements Comparable<UserBool>{
    private boolean valid;

    public UserBool(boolean valid) { this.valid = valid; }

    boolean isValid() {return valid;}

    @Override
    public int compareTo(UserBool o) {
        // тут нарушен контракт, одинаковые обьекты при стравнении признаются разными
//        return this.valid && o.valid ? 1 : -1;
        return Boolean.compare(this.valid, o.valid);
    }

    public String toString() { return String.valueOf(valid); }
}
