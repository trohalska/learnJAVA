package basicIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleFileReadWrite {

    public static void main(String[] args) throws IOException {
        int END_OF_FILE = -1;
        String SOURCE = "source.txt";
        String TARGET = "target.txt";

        /** simple reading from file */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( SOURCE );
            System.out.println("*** Simple reading from file:\n" + fis.toString() + "\n---");
        }
        catch (FileNotFoundException e) {
            System.out.println("There is exception: FileNotFoundException");
            System.err.println(e.toString());
        }

        /** reading from file and writing to another file with closure in finally block */
        System.out.println("*** Reading from file and writing to another file with closure in finally block:");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(SOURCE);
            out = new FileOutputStream(TARGET);
            int c;
            while ((c = in.read()) != END_OF_FILE) {
                System.out.print((char) c);
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is exception: FileNotFoundException");
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
        System.out.println("\n---");

        /** reading from file and writing to another file using try with resources */
        System.out.println("*** Reading from file and writing to another file using try with resources:");
        try (
                FileInputStream in2 = new FileInputStream( SOURCE );
                FileOutputStream out2 = new FileOutputStream(TARGET)
        ){
            int c;
            while ((c = in2.read()) != END_OF_FILE){
                System.out.print((char)c);
                out2.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is exception: FileNotFoundException");
        }

        System.out.println("\n---");
        System.out.println(fis.toString());
        fis.close();
    }
}

