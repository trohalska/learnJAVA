package reflections;

import java.lang.reflect.Method;

public class GetReflClass {
	
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<A> c = A.class;

		/** Methods to get REFLECTION CLASS */
		// 1
		Class clazz = String.class;
		Class clazz2 = java.lang.String.class;

		// 2
		A a = new A();
		Class<?> c2 = a.getClass();
		System.out.println(c == c2);

		// 3
//		String className = "A";
//		Class<?> c3 = Class.forName(className);
//		System.out.println(c == c3);
		
		Method m = c.getDeclaredMethod("m");
		m.invoke(null);
	}
}

class A {
	static void m() {
		System.out.println("A#m");
	}
}


