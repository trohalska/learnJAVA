package exeptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Exeptions {

    static class MyExeption extends Exception {
        public MyExeption(String msg) {
            super(msg);
        }
        public MyExeption(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    static void readFile() throws MyExeption {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("/ect/passwd"));
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            throw new MyExeption("Unable to read file");
        }
    }

    public static void main(String[] args) throws MyExeption {
//        readFile();

        /** how to use finally
         * */
        for (int i = 0; i < 10; ++i) {
            try {
                if (i == 5) continue;
                if (i == 7) break;
                System.out.println("Do iterator");
            } finally {
                System.out.println("I = " + i);
            }
        }
    }
}
