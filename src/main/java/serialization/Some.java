package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Some implements Serializable {
	static String staticField;
	private String field;

	public static void serializeStatic(ObjectOutputStream out) throws IOException {
		out.writeUTF(staticField);
	}

	public static void deserializeStatic(ObjectInputStream in) throws IOException {
		staticField = in.readUTF();
	}

	public Some() {
		System.out.println("Some::DefaultConstructor");
	}

	public Some(String field) {
		this.field = field;
		staticField = field;
		System.out.println("Some::Constructor");
	}

	@Override
	public String toString() {
		return "Some [field=" + field + ", staticField=" + staticField + "]";
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
