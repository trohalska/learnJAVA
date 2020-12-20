package exeptions;

import java.io.IOException;
import java.sql.SQLException;

public class EpamExceptions {

	// method can throw Exception or any descendant of it:
	public void method() throws Exception {
		// throw exception NoSuchMethodException,
		// which descendant of Exception:
		throw new NoSuchMethodException();
	}

	//
	public static void method2() {
		boolean a, b, c;
		a = b = c = false;
		String s = null;
		try {
			// ex exception throw
			// ex type is NullPointerException:
			int y = s.length();
			a = true; // will not be executed
			// catching exception ex :
		} catch (NullPointerException ex) {
			b = true; // will be executed
		}
		c = true; // will be executed

		try {
			try {
				// throw exception Ex1:
				throw new NullPointerException();
				// handle exception Ex 1:
			} catch (NullPointerException e) {
				// throw exception Ex2,
				// that cause to exit from try/catch:
				throw new Exception();
			}
		} catch (Exception e) {
			/* ... */ // handle exception Ex2
		}

		try {
			if (a)
				throw new IOException();
			if (b)
				throw new SQLException();
		} catch (IOException | SQLException e) { // ��������� Ex1
		} finally {
			// ����� ������� ���������� ���� ����� finally
			System.out.println("finally block is always executed");
		}

	}

	public void setX(int x) {
		assert x >= 0 : "X less then zero";
		this.x = x;
	}

	public int getX() {
		int x = 1;
		try {
			throw new Exception();
		} catch (Exception E) {
			return x = 2; // the value 2 is stored
		} finally {
			// return value 2:
			x = 3;
		}
	}
	
	public static void tryWithResource() {
		Resource resource = new Resource();
		try {
			resource.m(true);
		} catch (Exception e) {
			// log
		} finally {
			try {
				if (resource != null) {
					resource.close();
				}
			} catch (Exception e) {
				// nothing
			}
		}
	}
	
	public static void tryWithResource2() throws Exception {
		try(Resource resource = new Resource();) {
			resource.m(true);
		}
	}

	// the method returns 2:
	int x = getX(); // x = 2

	public static void main(String[] args) throws Exception {
		method2();
		EpamExceptions t = new EpamExceptions();
		t.setX(-10);
		tryWithResource();
	}
}

class A {
	void m() throws IOException {
	}
}

class B extends A {
	void m() { // ���������� ������ m ������ A
		try {
			// ������ ����������
			throw new IOException();
		} catch (Exception e) { // �������� ����������
			// ������ ������ ����������
			throw new Error(e);
		}
	}
}

class Resource implements AutoCloseable {

	void m(boolean flag) throws Exception {
		System.out.println("do something");
		if (flag) {
			throw new Exception();
		}
		System.out.println("do something other");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Closed");
	}

}
