package compatarors;

public class UserStr implements Comparable<UserStr> {
    private final String name;

    public UserStr(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(UserStr o) {  // @NotNull
        return name.compareTo(o.name);
    }

    public String toString() {
        return name;
    }
}
