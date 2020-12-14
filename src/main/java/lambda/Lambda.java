package lambda;

public class Lambda {

	public static double val1 = 3.0, val2 = 3.0;

	public static void main(String... args) {

		// old version
		Operation operation = new Operation() {
			@Override
			public double getResult(double v1, double v2) {
				return v1 + v2;
			}
		};
		System.out.println(operation.getResult(2.0, 2.0));

		// new version - lambda, for interfaces with ONLY ONE method
		Operation lambda = (v1, v2) -> v1 + v2;
		System.out.println(lambda.getResult(2.0, 2.0));


		Printer printer = string -> System.out.println(string);
		printer.println("Hello World");

		// return in lambda
		Factorial f = value -> {
			int res = 1;

			for (int i = 1; i <= value; ++i) {
				res *= i;
			}
			return res;
		};
		System.out.println(f.getResult(5));

		// empty brackets in lambda
		OperationBlank op = () -> {
			// val1 = 100;
			return val1 + val2;
		};
		System.out.println(op.getResultBlank());
		System.out.println(val1);
		System.out.println(val2);

		// final fields using  in lambda
		final String s = "hello"; // s must be final (or class variable)
		// s = "trololo"; // won't work
		Printer2 pr = () -> System.out.println(s);
		pr.println();

	}
}

interface Operation {
	double getResult(double v1, double v2);
}
interface OperationBlank {
	double getResultBlank();
}

interface Printer {
	void println(String string);
}

interface Printer2 {
	void println();
}

interface Factorial {
	int getResult(int value);
}