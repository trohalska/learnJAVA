package threadSync;

/**
 * main thread blocked monitor, after it releases it -> child thread has monitor
 */
public class IfBlocked2 {
	
	private static final Object M = new Object();
	/** don't use strings for monitor because of string pool */
//	private static final String M = "Monitor!!!! :-)";
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread() {
			public void run() {

//				try { sleep(1); }
//				catch (InterruptedException e) { e.printStackTrace(); }

				synchronized (M) {}
				
				System.out.println("Child is finished");
			}
		};
		
		synchronized (M) {
			t.start();
			
			while (t.getState() != Thread.State.BLOCKED) {
				System.out.println(t.getState());
			}
			System.out.println(t.getState());
			System.out.println("Main frees Monitor");
		}
	}
}
