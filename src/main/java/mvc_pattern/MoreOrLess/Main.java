package mvc_pattern.MoreOrLess;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Model model = ;
        View view = ;*/
        Controller controller = new Controller(new Model(), new View());

        controller.processUser();
    }
}
