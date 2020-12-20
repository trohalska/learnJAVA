package basicIO;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTests {
    private static final String EOL = System.lineSeparator();
    private static final String UTF8 = "UTF-8";
    private static final String CP1251 = "CP1251";

    public static void main(String[] args) throws IOException {
        System.out.println("~~~~~~~~ bytes");
        String text = readBytes("resources/basicIO/test.txt");
        System.out.println(text);
        writeBytes("resources/basicIO/test.out.txt", text.getBytes());
        copy("resources/basicIO/test.txt", "resources/basicIO/test.copy.txt");

        System.out.println("~~~~~~~~ chars");
        text = readChars("resources/basicIO/test.txt", null);
        System.out.println(text);
        System.out.println("~~~~~~~~ chars2");
        text = readChars2(new FileInputStream("resources/basicIO/test.txt"), UTF8);
        System.out.println(text);

        System.out.println("~~~~~~~~ doubles");
        double[] doubles = Util.createDoubleArray(10);
        System.out.println("Original: \n" + Arrays.toString(doubles));
        writeData(new FileOutputStream("resources/basicIO/doubleData.dat"), doubles);
        System.out.println(Arrays.toString(readData(new FileInputStream("resources/basicIO/doubleData.dat"))));
        System.out.println(Arrays.toString(readData(new FileInputStream("resources/basicIO/doubles.txt"))));
//		System.out.println(Arrays.toString(readData(System.in)));
    }

    private static String readBytes(String fName) {
        StringBuilder sb = new StringBuilder();
        InputStream in = null;
        try {
            in = new FileInputStream(fName);
            int s;
            while ((s = in.read()) != -1) {
                sb.append((char) s);
            }
        } catch (IOException e) {
            sb = null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        assert sb != null;
        return sb.toString();
    }

    private static void readBytes3(String fName) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(fName);
            int s;
            while ((s = in.read()) != -1) {
                System.out.print(s + ", ");
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
//					e.printStackTrace();
                }
            }
        }
    }

    private static String readBytes2(String fName) {
        StringBuilder sb = new StringBuilder();

        try (InputStream in = new FileInputStream(fName)) {
            int s;
            while ((s = in.read()) != -1) {
                sb.append((char) s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return sb.toString();
    }

    private static void writeBytes(String fName, byte[] bytes) throws IOException {
        OutputStream output = null;
        try {
            output = new FileOutputStream(fName);
            for (byte b : bytes) {
                output.write(b);
            }
            output.flush(); // forces any buffered output bytes to be written out
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        }
    }

    private static void writeBytes2(String fName, byte[] bytes) throws IOException {
        try (OutputStream output = new FileOutputStream(fName)) {
            for (byte b : bytes) {
                output.write(b);
            }
            output.flush(); // forces any buffered output bytes to be written out
        }
    }

    private static void copy(String from, String to) throws IOException {
        try (FileInputStream fisFrom = new FileInputStream(from);
             FileOutputStream fisTo = new FileOutputStream(to);) {
            Util.copy(fisFrom, fisTo);
        }
    }

    private static String readChars(String fName, String encoding) {
        Charset cs = encoding == null ? Charset.defaultCharset() : Charset.forName(encoding);
        StringBuilder sb = new StringBuilder();
        try (Reader in = new FileReader(fName, cs)) {
            int s;
            while ((s = in.read()) != -1) {
                sb.append((char) s);
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void writeChars(String text, String fName, String encoding) throws IOException {
        Charset cs = encoding == null ? Charset.defaultCharset() : Charset.forName(encoding);
        try (Writer out = new FileWriter(fName, cs)) {
            out.write(text);
        }
    }

    private static String readChars2(InputStream in, String encoding) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(in, encoding));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bin.readLine()) != null) {
            sb.append(s).append(EOL);
        }
        bin.close();
        return sb.toString();
    }

    private static double[] readData(InputStream in) throws IOException {
        List<Double> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(in));) {
            Double d;
            while (true) {
                try {
                    d = dis.readDouble();
                    list.add(d);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        return list.stream().mapToDouble(x -> x).toArray();
    }

    private static void writeData(OutputStream out, double[] values) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(out);) {
            for (Double d : values) {
                dos.writeDouble(d);
            }
        }
    }
}
