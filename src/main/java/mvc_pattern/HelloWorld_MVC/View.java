package mvc_pattern.HelloWorld_MVC;

public class View {
    private static final String errSymbols = "unknown symbols";
    private static final String errWords = "unknown words";

    public void printResult(String msg) {
        System.out.println(msg);
    }
    public void printErrSymbols() {
        System.out.println(errSymbols);
    }
    public void printErrWords() {
        System.out.println(errWords);
    }
}
