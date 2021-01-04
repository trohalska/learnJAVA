package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestStaticSerialization {
	private static final String FILE_NAME = "static.ser";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Some some = new Some("login");
		System.out.println("New Some: " + some);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));) {
			oos.writeObject(some);
			Some.serializeStatic(oos);
		}
		Some some2 = new Some();
		System.out.println("New empty Some: " + some2);

		Some some3 = new Some("other");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));) {
 			some3 = (Some) ois.readObject();
			Some.deserializeStatic(ois);
		}
		System.out.println("Desrialized: " + some3);
	}

}
