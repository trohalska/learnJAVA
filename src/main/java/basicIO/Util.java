package basicIO;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private static final String ENCODING = "UTF8";

    public static String arrayToString(int[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]).append(" ");
        }
        return sb.toString();
    }

    public static String arrayToString(double[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]).append(" ");
        }
        return sb.toString();
    }

    public static int[] createIntArray(int count) {
        int[] values = new int[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }

    public static double[] createDoubleArray(int count) {
        double[] values = new double[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }

    public static void writeFile(String to, String text, String encoding) throws IOException {
        Files.write(Paths.get(to), text.getBytes(encoding));
    }

    public static void copy(InputStream from, OutputStream to) throws IOException {
        try (BufferedInputStream bFrom = new BufferedInputStream(from);
             BufferedOutputStream bTo = new BufferedOutputStream(to)) {
            int data;
            while ((data = from.read()) != -1) {
                to.write(data);
            }
        }
    }

    // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
    public static void readFromUrl() throws Exception {

        URL oracle = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

    public static void main(String[] args) throws Exception {
        readFromUrl();
//		writeFile("doubles.txt", arrayToString(createDoubleArray(10)), ENCODING);
    }
}
