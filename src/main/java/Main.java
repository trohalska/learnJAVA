import compatarors.ComparatorMain;

public class Main {
    public static void main(String[] args) {
//        new InterfaceVectorMain();
//        new EnumMain();
//        new AbstractClassesMain();
//        new StringMain();
//        new JenericsMain();
//        new InheritanceJenerics();
//        exeptions
//        new VarargsMain();

//        new Sets();
//        new Lists();
//        new Maps();

//        new InheritMethods();
//        new Equals.MyEquals();

//        new HashCode(2,12,9);
//        new MainMapExceptions();

//        new ComparatorMain();

        int result = 0;
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int min = (first > second) ? second : first;

        for (int count = 1; count <= min; count++) {
            if (first % count == 0 && second % count == 0) {
                if (count > result) {
                    result = count;
                }
            }
        }

        System.out.println(result);

    }

//    public static void main(String[] args) throws Exceptions.MyException {
//        new Exceptions.ExceptionsMain();
//    }
}
