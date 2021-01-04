package serialization.serializable;

import java.io.Serializable;

public class UserDetails implements Serializable {
	private int age;
	private String address;
	private String email;

	public UserDetails() {
		// default
		System.out.println("UserDetails::DefaultConstructor");
	}

	public UserDetails(int age, String address, String email) {
		this.age = age;
		this.address = address;
		this.email = email;
		System.out.println("UserDetails::Constructor");
	}

	@Override
	public String toString() {
		return "UserDetails [age=" + age + ", address=" + address + ", email=" + email + "]";
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
