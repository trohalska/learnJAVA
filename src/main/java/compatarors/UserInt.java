package compatarors;

public class UserInt implements Comparable<UserInt> {
    private int age;

    public UserInt(int age) { this.age = age; }

    public int getAge() {return age;}

    @Override
    public int compareTo(UserInt o) {
//        return this.age - o.age;   // незахищено від переповнення
        return Integer.compare(this.age, o.age);
    }

    public String toString() { return String.valueOf(age); }
}
