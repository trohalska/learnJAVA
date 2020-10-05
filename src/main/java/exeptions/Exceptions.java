package exeptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Exceptions {

    public static class MyException extends Exception {
        public MyException(String msg) {
            super(msg);
        }
        public MyException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    public static void readFile() throws MyException {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("/ect/passwd"));
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            throw new MyException("Unable to read file");
        }
    }

    public static class ExceptionsMain {
        public ExceptionsMain() throws MyException {
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

}
