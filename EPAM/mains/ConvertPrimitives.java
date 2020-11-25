public class ConvertPrimitives {
    public static void main(String[] args) {
        // int to float
        int a = 2147483647;
        float b = a;            // от типа int к типу float
        System.out.println(b);  // 2.14748365E9

        // long to float
        long c = 214748364789123L;
        b = c;                  // от типа long к типу float
        System.out.println(b);  // 2.14748365E9

        // convert

        int y = (int) 77.85; // 77

        byte x = 71;
        char s = (char)x; // 'G'

//        byte c1 = (byte) 1 + 1;  // compilation error, second = int
//        int b2 = (int) 7 + (long) 7L;  // compilation error

        int b3 = 3;
        b3 += 7L;  // 10 (int)
        System.out.println(b3);

        System.out.println("x="+1);
        System.out.println(1+2+"text");
        System.out.println("text"+2+1);

        int z = 3;
        char zy = 'x';
        System.out.println((int)zy);
        System.out.println(z + zy);

        // print note key
        System.out.println("\uD834\uDD1E");
    }
}
