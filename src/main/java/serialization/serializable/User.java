package serialization.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	
	static String text;
//	static String some;
	
	private String login;
	transient private String password;  // unserializable field

	private UserDetails details;

	public User() {
		System.out.println("User::DefaultConstructor");
	}

	public User(String login, String password, UserDetails details) {
		this.login = login;
		this.password = password;
		this.details = details;
		System.out.println("User::Constructor");
	}


	@Override
	public String toString() {
		return "User [login=" + login 
				+ ", password=" + password + ", details=" + details 
				+ ", text = " + text + "]";
	}

//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	/** serialize and de-||- static fields */
	static void serializeStatic(ObjectOutputStream out) throws IOException {
		out.writeUTF(text); // throw NullPointerException if the field is null
//		out.writeUTF(some); // throw NullPointerException if the field is null
	}
	static void deserializeStatic(ObjectInputStream in) throws IOException {
		text = in.readUTF(); 
//		some = in.readUTF();
	}

	// uncomment code above if you want to use custom serialization process

	/*private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println("writeObject");
		out.writeObject(login);
		out.writeObject(password);
		out.writeObject(details);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("readObject");
		login = (String) in.readObject();
		password = (String) in.readObject();
		details = (UserDetails) in.readObject();
	}*/

	
//	private void readObjectNoData() throws ObjectStreamException {
//	}

}
