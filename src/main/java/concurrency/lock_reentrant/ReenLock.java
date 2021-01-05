package concurrency.lock_reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * first executed main till unlock
 * child thread is started but lock
 * after mutex unlock child thread start executing
 */
public class ReenLock {
	private static final Lock MUTEX = new java.util.concurrent.locks.ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException {
		
		MUTEX.lock();
		System.out.println("Main Lock");
		
		new Thread() {
			public void run() {
				MUTEX.lock();
				System.out.println("Child Lock");
				
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Child Unlock");
				MUTEX.unlock();
			}
		}.start();

		Thread.sleep(1500);
		System.out.println("Main Unlock");
		MUTEX.unlock();
	}

}
