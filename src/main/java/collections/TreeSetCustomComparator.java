package collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetCustomComparator {
	
	public static void main(String[] args) {
		Set<A> set;
		set = new TreeSet<>(new Comparator<A>() {
			public int compare(A a1, A a2) {
				System.out.printf("comp.compare(%s,%s)%n", a1.x, a2.x);
				return -a1.x + a2.x;
			}
		});
		
		set.add(new A(4));
		System.out.println("~~~");

		set.add(new A(1));
		System.out.println("~~~");
		set.add(new A(2));
		System.out.println("~~~");
		set.add(new A(3));
		System.out.println("~~~");

		System.out.println(set);
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
			return x - a.x;
		}
	}
	
}


