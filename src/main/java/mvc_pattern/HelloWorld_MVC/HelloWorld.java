package mvc_pattern.HelloWorld_MVC;

public class HelloWorld {
    public static void main(String[] args) {
        // init
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        // run
        controller.processInput();
    }
}
