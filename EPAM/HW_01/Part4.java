public class Part4 {

    public static void main(String[] args) {
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

}
