public class Part2 {

    public static void main(String[] args) {
        int result = 0;
        for (String arg : args) {
            result += Integer.parseInt(arg);
        }
        System.out.println(result);
    }
}
