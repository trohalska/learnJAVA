package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// example, hat HashSet elements are comparing by hashCode method
public class HashSetByHashCode {
	
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>(4, 1);
		set1.add("A");
		set1.add("B");
		set1.add("C");
		set1.add("D");
		set1.add("A");
		set1.add("E");
		System.out.println(set1);

		Set<A> set;
		set = new HashSet<>();

		set.add(new A(1));
		System.out.println("~~~");
		set.add(new A(2));
		System.out.println("~~~");
		set.add(new A(3));
		System.out.println("~~~");

		// 4
		set.add(new A(2));
		System.out.println("~~~");
		System.out.println(set.contains(new A(2)));

		System.out.println(set);
	}
	
	static class A {
		int x;
		A(int x) { this.x = x; }
		
		@Override
		public boolean equals(Object obj) {
			A a = (A)obj;
			System.out.printf("A(%s).equals(%s)%n", x, a.x);
//			return super.equals(obj); // 1-3
			return x == a.x; // 4 equals compares object's fields by == and don't add second "2"
		}
		@Override
		public int hashCode() {
			System.out.printf("A(%s).hashCode()%n", x);
//			return super.hashCode(); // 1
//			return x; // 2 hashCode compares objects by == but all still works correct
//			return 0; // 3 hashCode returns 0 for each element, so HashSet has to revoke equals method
			return x; // 4 hashCode compares objects by == and said they're maybe equals
		}
		@Override
		public String toString() { return "A(" + x + ")"; }
	}
}


