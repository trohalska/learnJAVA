package concurrency;

/**
 * volatile
 * when one thread change volatile field - then all threads will see this change
 */
public class VolatileExample {
	
//	static int x = 7;
	static volatile int x = 7;
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			public void run() {
				while (x == 7);
				
				System.out.println("Child: " + x);
			}
		}.start();
		
		Thread.sleep(1000);
		
		x = 8;
		System.out.println("Main is finished!");
	}
}
