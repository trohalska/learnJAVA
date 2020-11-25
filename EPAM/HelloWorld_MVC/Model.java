public class Model {
    private static final String w1 = "Hello";
    private static final String w2 = "world!";

    public boolean check(String input1, String input2) {
        if (!w1.equals(input1) || !w2.equals(input2)) {
            return false;
        }
        return true;
    }

    public String process(String input1, String input2) {
        return input1 + ' ' + input2;
    }
}
