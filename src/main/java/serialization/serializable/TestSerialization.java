package serialization.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {
	private static final String FILE_NAME = "user.ser";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		User u = new User(null, "pass", null);
		User.text = "Some text";
		System.out.println("New User: " + u);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));) {
			oos.writeObject(u);
			User.serializeStatic(oos);  //serilialize static fields
		}

		User.text = null;
		User u2 = new User();
		System.out.println("New empty User: " + u2);

		/** get new object without constructor */
		User u3;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));) {
			u3 = (User) ois.readObject();
			User.deserializeStatic(ois);
		}
		System.out.println("Desrialized: " + u3);
	}
}
