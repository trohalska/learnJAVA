package threads;

public class CloseThread {

	public static void main(String[] args) throws InterruptedException {
//		evilOfStop();
//		correctClose();
//		interruptException();  // throws exception
		correctClose2();
	}

	private static void correctClose2() throws InterruptedException {
		Thread t = Thread.currentThread();
		t.interrupt(); // <-- main thread
		System.out.println(t.isInterrupted());
		try {
			Thread.sleep(555); // <-- main thread
		} catch (InterruptedException ex) {
			System.out.println(t.isInterrupted());  // flag set false
		}
	}

	private static void interruptException() throws InterruptedException {
		Thread t = Thread.currentThread();
		t.interrupt(); // <-- main thread
		System.out.println(t.isInterrupted());
		Thread.sleep(555); // <-- main thread / throws exception
	}

	private static void correctClose() {
		Thread t = Thread.currentThread();

		System.out.println(t.isInterrupted());
		System.out.println(t.isInterrupted());

		t.interrupt();

		System.out.println(t.isInterrupted());
		System.out.println(t.isInterrupted());

		System.out.println(Thread.interrupted());  // shows flag and makes interrupt_flag = false;
		System.out.println(Thread.interrupted());
	}

	private static void evilOfStop() throws InterruptedException {
		Thread t = new Child();
		t.start();
		Thread.sleep(1555);
		/** STOP works but it is unsafe,
		 * doesn't guarantied that thread will set free resource, that was in use on stop moment */
		t.stop(); // <-- It is evil!!!!
	}

	static class Child extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("Child");
				try { sleep(333); }
				catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
	}

}


