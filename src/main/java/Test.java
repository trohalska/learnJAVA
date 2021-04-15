
public class Test implements Cloneable {
    private String str;
    private int i;

    public Test(String s, int i) {
        this.str = s;
        this.i = i;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        }
        Test o2 = (Test) o;
        if (!this.str.equals(o2.str)) {
            return false;
        }
        if (this.i != o2.i) {
            return false;
        }
        return true;

    }

    public int hashCode() {
        return 31*i + str.hashCode();
    }
}


final class Singleton {
    private static volatile Singleton instance;
    public String value;
    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }
}

class Immutable {
    private final String s;
    private final Test test;
    private static Immutable instance;

    private Immutable(String s, Test t) {
        this.s = s;
        this.test = t;
    }
    public String getS() {
        return s;
    }
    public Test getTest() throws CloneNotSupportedException {
        return (Test)test.clone();
    }

    public static Immutable getInstance(String s, Test test) {
        if (instance == null) {
            synchronized (Immutable.class) {
                if (instance == null) {
                    instance = new Immutable(s, test);
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "s='" + s + '\'' +
                ", test=" + test +
                '}';
    }
}

