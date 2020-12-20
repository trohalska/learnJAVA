package basicIO;

import java.io.*;
import java.util.*;

public class Flush {
    private static final int N = 10;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("resources/basicIO/flush.txt"));

        for (int i = 0; i < N; i++) {
            bw.write("" + i);
        }
        System.out.println("All data wrote / Press enter...");
        // file created, but data still in buffer - file is empty,
        // though we have finished to write them in cycle
        sc.nextLine();
		bw.flush();
        System.out.println("Flushed / Press enter...");
        // data was pushed from buffer to file
        // we can see number in file
        sc.nextLine();
        sc.close();
        bw.close();
        System.out.println("Closed / Press enter...");
        // streams was closed
    }
}
