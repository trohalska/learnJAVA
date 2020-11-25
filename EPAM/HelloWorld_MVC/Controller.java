import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    private View view;
    private Model model;
    private String word1;
    private String word2;

    private static final String regex1 = "(^[a-zA-Z]+$)";
    private static final String regex2 = "(^[a-zA-Z]+!$)";

    private Pattern pattern1 = Pattern.compile(regex1);
    private Pattern pattern2 = Pattern.compile(regex2);

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void processInput() {
        Scanner input = new Scanner(System.in);
        word1 = input.nextLine();
        word2 = input.nextLine();

        if (pattern1.matcher(word1).matches() && pattern2.matcher(word2).matches()) {
            if (model.check(word1, word2)) {
                view.printResult(model.process(word1, word2));
            } else {
                view.printErrWords();
            }
        } else {
            view.printErrSymbols();
        }
    }
}
