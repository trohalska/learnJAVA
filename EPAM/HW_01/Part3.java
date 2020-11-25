public class Part3 {

    public static void main(String[] args) {
        String result = new String();
        int length = args.length;

        for (int i = 0; i < length; i++) {
            result += args[i];
            if (i < length - 1) {
                result += ' ';
            }
        }
        System.out.println(result);
    }
	
}
