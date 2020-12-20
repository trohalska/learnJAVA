package basicIO;

import java.io.*;

public class FileInputOutputStreams {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream("resources/basicIO/test.txt");
            out = new FileOutputStream("resources/basicIO/test.res.txt");
            int b;
            while ((b = in.read()) != -1) {
                System.out.print(b);
                System.out.print("_" + (char)b + "___");
                out.write(b);
            }
        } finally {
            assert in != null;
            in.close();
            assert out != null;
            out.close();
        }
    }
}
