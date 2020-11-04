package hash_equals;

public class Equals {
    static String name;

    Equals(String n) {
        name = n;
    }
    public boolean equals(Object o) {
        Equals m = (Equals) o;
        if (m.name != null) {
            return true;
        }
        return false;
    }
    public static class MyEquals {
        public MyEquals() {
            Equals m1 = new Equals("gui");
            Equals m2 = new Equals("tv");
            Equals m3 = new Equals(null);
            System.out.println(
                    m1.equals(m2) + "," +
                    m2.equals(m3) + "," +
                    (m3 == m3)
            );                   // false, false, true
        }
    }
}
