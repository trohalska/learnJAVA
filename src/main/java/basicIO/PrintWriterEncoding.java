package basicIO;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PrintWriterEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // print in file, output stream etc
        // UTF-8 for MacOS, Cp866 for Windows console
        // system.out - automatic uses necessary encoding utf-8
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        out.println("Интернациональная строка");
        System.out.println("Интернациональная строка");
        printEncoding();
    }

    static void printEncoding() {
        Properties props = System.getProperties();
        Set<Object> keys = props.keySet();
        for (Object object : keys) {
            String key = (String) object;
            if (key.contains("encoding")) {
                System.out.println(key + " : " + props.getProperty(key));
            }
        }
    }
}
