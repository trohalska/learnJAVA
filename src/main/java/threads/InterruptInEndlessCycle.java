package threads;

public class InterruptInEndlessCycle {

	/**
	 * .interrupt() -> another thread -> set flag = true or causes throwing exception
	 * .isInterrupt() -> this thread -> get flag value
	 *
	 * static .interrupted() -> this thread -> show flag state and set flag=false
	 */
	public static void main(String[] args) throws InterruptedException {
//		Thread t = new Child();
//		t.start();
//		Thread.sleep(1555);
//		t.interrupt();

		Thread t2 = new Child2();
		t2.start();
		Thread.sleep(1555);
		t2.interrupt();
	}

	static class Child extends Thread {  // first way
		@Override
		public void run() {
			while (true) {
				System.out.println("Child");

				try {
					sleep(333);
				} catch (InterruptedException e) { // if we have interrupt_flag == true
					return;  // reaction on interrupt
//					break;
				}
			}
		}
	}
	static class Child2 extends Thread {  // second way
		@Override
		public void run() {
			while (!isInterrupted()) {  // while not interrupted
				System.out.println("Child");
				try {
					sleep(333);
				} catch (InterruptedException e) { // if we have interrupt_flag == true
					interrupt();  // interrupt itself
				}
			}
		}
	}

}
