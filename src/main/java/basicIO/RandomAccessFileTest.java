package basicIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile f = new RandomAccessFile("resources/basicIO/raf.txt", "rw");
		f.writeChars("Some ������");
		f.seek(f.getFilePointer()+ 4);
		f.write("����� String".getBytes("UTF8"));
		f.seek(f.getFilePointer()+ 4);
		f.writeBytes("Some other ������");
		f.seek(f.getFilePointer()+ 4);
		f.writeUTF("��������� sting");
		f.close();
		
		f = new RandomAccessFile("resources/basicIO/raf.dat", "rw");
		int[] values = Util.createIntArray(10);
		for (int i = 0; i < values.length; i++) {
			if (i % 2 == 0) {
				f.writeInt(values[i]);
				f.seek(f.getFilePointer() + 4);
			}
		}
		values = new int[10];
		int pos = 0;
		read(f, values, pos);
		System.out.println(Arrays.toString(values));

		values = Util.createIntArray(10);
		f.seek(4);
		for (int i = 0; i < values.length; i++) {
			if (i % 2 != 0) {
				f.writeInt(values[i]);
				f.seek(f.getFilePointer() + 4);
			}
		}
		values = new int[10];
		pos = 0;
		read(f, values, pos);
		System.out.println(Arrays.toString(values));
	}

	private static void read(RandomAccessFile f, int[] values, int pos) throws IOException {
		f.seek(pos);
		for (int i = 0; i < values.length - 1; i++) {
			values[i] = f.readInt();
		}
	}
	
}
