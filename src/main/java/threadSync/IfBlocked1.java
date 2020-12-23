package threadSync;

/**
 * class has monitor M
 * main thread starts -> child thread starts and has(blocked) Monitor ->
 * main wants to start Monitor block, but can't ->
 * so main thread is BLOCKED until child thread will release Monitor
 */
public class IfBlocked1 {
	
	private static final Object M = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		System.out.println(t.getState());
		
		new Thread() {
			public void run() {
				synchronized (M) {
					try {
						sleep(500);
						
						System.out.println(t.getState());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.start();
		
		Thread.sleep(50);
		synchronized (M) {
			
		}
		
		
		
	}

}
