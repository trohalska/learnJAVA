package concurrency;

/**
 * t thread started and blocked on main monitor
 * while main thread has monitor and sleep for 2 sec
 */
public class SimpleHappensBeforeOrder {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				synchronized ("asdf") {
					
				}
				System.out.println("Child");
			}
		};
		
		synchronized ("asdf") {
			t.start();
			
			Thread.sleep(2000);
			System.out.println("Main");
		}
	}

}
