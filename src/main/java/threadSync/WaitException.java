package threadSync;

/**
 * we have an exception if try to interrupt method which is waiting
 */
public class WaitException {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
		
		new Thread() {
			public void run() {
				try { sleep(1000); }
				catch (InterruptedException e) { e.printStackTrace(); }
				
				t.interrupt();
			}
		}.start();
		
		synchronized (args) {
			args.wait();
		}
		
	}

}
