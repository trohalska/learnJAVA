package concurrency.lock_reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  interrupting while lock is working
 */
public class ReenLock_interrupt {

	private static final Lock MUTEX = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = Thread.currentThread();
		
		new Thread() {
			public void run() {
				MUTEX.lock();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Try to interrupt the main thread");
				t.interrupt();
				
				System.out.println(t.isInterrupted());
			}
		}.start();

		Thread.sleep(100);
		MUTEX.lock(); // hanging
		System.out.println("OK");
	}

}
