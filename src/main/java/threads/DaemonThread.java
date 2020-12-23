package threads;

public class DaemonThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				while (true) {
					System.out.println("Child");
					try { sleep(333); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		};
		System.out.println(t.isDaemon());
		t.setDaemon(true);
		System.out.println(t.isDaemon());

		t.start(); // <-- main thread start a child thread

		/** create new thread - is long operation, so first we will se next phrase
		 * and then - Child ...*/
		System.out.println("Main is going to sleep");
		Thread.sleep(1500);
		System.out.println("Main is stopped!");
	}
}
