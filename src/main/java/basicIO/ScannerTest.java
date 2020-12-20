package basicIO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws Exception {
        System.out.println("~~~~~~~~ doubles");
        System.out.println(readInputStream(new FileInputStream("resources/basicIO/doubles.txt")));
        System.out.println(readInputStream(System.in));
    }

    private static String readInputStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(in);
        double s;
        while (sc.hasNextDouble()) {
            // will be split by whitespace characters only after receiving the line separator
            s = sc.nextDouble();
            sb.append(s).append(" ");
        }
        sc.close();
        return sb.toString();
    }
}
