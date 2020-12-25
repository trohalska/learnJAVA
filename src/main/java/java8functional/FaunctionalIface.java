package java8functional;

public class FaunctionalIface {
	static final String STRING = "Some string";

	public interface Foo {
		void doIt(String text);
	}

	public static void work(Foo w) {
		w.doIt(STRING);
	}

	public static void main(String[] args) {
        work(new Foo() {
			
			@Override
			public void doIt(String text) {
				System.out.println(text);
				
			}
        });
    }
}

@FunctionalInterface
interface Bar {
	void doSomething();
//	default void doDefault() {...}
//	static void doStatic() {...}
}
