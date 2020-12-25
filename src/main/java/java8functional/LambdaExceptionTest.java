package java8functional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * if we let exception out (like in Foo2)
 * than we don't need try-catch block in lambda
 */
public class LambdaExceptionTest {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Foo2 foo2 = in -> in.read();
		Foo3 foo3 = in -> {
			try {
				return in.read();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};
	}

}

interface Foo2 {
	int execute(BufferedReader in) throws IOException;
}

interface Foo3 {
	int execute(BufferedReader in);
}