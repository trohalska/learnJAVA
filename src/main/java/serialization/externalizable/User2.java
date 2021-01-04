package serialization.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User2 implements Externalizable {
	
	static String text;
	private String login;
	private String password;

	private UserDetails2 details;

	public User2() {
		System.out.println("User2::DefaultConstructor");
	}

	public User2(String login, String password, UserDetails2 details) {
		this.login = login;
		this.password = password;
		this.details = details;
		System.out.println("User2::Constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// Use writeObject() instead of out.writeUTF(login); 
		// to avoid NullPointerException if String field is null
		out.writeObject(login); 
		out.writeObject(password);
		out.writeObject(details);
		out.writeObject(text); // static field
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		login = (String) in.readObject(); // Use readObject() instead of in.readUTF();
		password = (String) in.readObject(); // Use readObject() instead of in.readUTF();
		details = (UserDetails2) in.readObject();
		text = (String) in.readObject();  // static field
	}

	@Override
	public String toString() {
		return "User2 [login=" + login + ", password=" + password + ", details=" + details + ", static=" + text + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
