package java8functional;

/**
 * we use lambda also to avoid constructor envolwing
 *
 * we can't use polimorphism on functions,
 * that take as parameter functional class (compilator can't help us)
 */
public class ExecutionContext {

//	static Run r = new Run();

	void execute(Runnable r) {
		System.out.println("execute Runnable");
		r.run();
	}
	public void executeAsAction(Action a) {
		System.out.println("execute Action");
		a.act();
	}

	/**
	 * method overloading (not recommended)
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutionContext ec = new ExecutionContext();

		/** correct way - different function names */
//		ec.execute(new Run());
//		ec.executeAsAction(new Act());
//
//		ec.execute(() -> System.out.println("Run"));
//		ec.executeAsAction(() -> System.out.println("Act"));

		/** not so correct - obvious type casting */
		Object run = (Runnable) () -> System.out.println("Run");
		Object act = (Action) () -> System.out.println("Act");
		ec.execute((Runnable) run);
		ec.executeAsAction((Action) act);

//		ec.execute((Runnable) act); // java.lang.ClassCastException
	}
}

@FunctionalInterface
interface Action {
	static String s = "Action";

	void act();
}

class Run implements Runnable {

	public Run() {
		System.out.println("Runnable Constructor " + this);
	}

	@Override
	public void run() {
		System.out.println("Runnable " + this);
	}

}

class Act implements Action {

	public Act() {
		System.out.println("Action Constructor " + this);
	}

	@Override
	public void act() {
		System.out.println(s + " " + this);
	}

}
