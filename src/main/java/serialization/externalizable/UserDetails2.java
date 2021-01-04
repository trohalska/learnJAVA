package serialization.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class UserDetails2 implements Externalizable {
	private int age;
	private String address;
	private String email;

	public UserDetails2() {
		// default
		System.out.println("UserDetails2::DefaultConstructor");
	}

	public UserDetails2(int age, String address, String email) {
		this.age = age;
		this.address = address;
		this.email = email;
		System.out.println("UserDetails2::Constructor");
	}

//	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(age);
		out.writeUTF(address);
		out.writeUTF(email);
	}

//	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		age = in.readInt();
		address = in.readUTF();
		email = in.readUTF();
	}

	@Override
	public String toString() {
		return "UserDetails2 [age=" + age + ", address=" + address + ", email=" + email + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
