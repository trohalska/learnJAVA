package serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization2 {
	private static final String FILE_NAME = "user2.ser";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		User2 u = new User2(null, "pass", new UserDetails2(18, "address", "email"));
		User2.text = "Static";
		System.out.println("New User: " + u);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));) {
			oos.writeObject(u);
		}
		User2 u2 = new User2();
		User2.text = null;
		System.out.println("New empty User: " + u2);

		User2 u3;
//		User2.text = "Static";
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));) {
			u3 = (User2) ois.readObject();
		}
		System.out.println("Desrialized: " + u3);
	}
}
