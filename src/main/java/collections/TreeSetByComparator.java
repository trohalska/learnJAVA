package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetByComparator {
	
	public static void main(String[] args) {
		Set<A> set;
		set = new TreeSet<>();
		
		set.add(new A(1));
		System.out.println("~~~");
		set.add(new A(2));
		System.out.println("~~~");
		set.add(new A(3));
		System.out.println("~~~");

		set.add(new A(2));
		System.out.println("~~~");

		set.add(new A(4)); // 3
		System.out.println("~~~");
		
		System.out.println(set);
		
		System.out.println(set.contains(new A(2)));
	}
	
	static class A implements Comparable<A> {
		int x;
		A(int x) { this.x = x; }
		
		@Override
		public boolean equals(Object obj) {
			A a = (A)obj;
			System.out.printf("A(%s).equals(%s)%n", x, a.x);
			return x == a.x;
		}
		@Override
		public int hashCode() {
			System.out.printf("A(%s).hashCode()%n", x);
			return x;
		}
		@Override
		public String toString() { return "A(" + x + ")"; }

		@Override
		public int compareTo(A a) {
			System.out.printf("A(%s).compareTo(%s)%n", x, a.x);
//			return 0;  // 1
			return x - a.x; // 2-3
		}

	}
	
}


