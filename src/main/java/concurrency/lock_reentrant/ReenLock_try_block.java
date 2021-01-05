package concurrency.lock_reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * same that ReentrantLock1 but locking in try-finally block
 */
public class ReenLock_try_block {

	private static final Lock MUTEX = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {

		MUTEX.lock();
		System.out.println("Main Lock");

		new Thread() {
			public void run() {
				try {
					MUTEX.lock();
					System.out.println("Child Lock");

					try {
						sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("Child Unlock");
				} finally {
					MUTEX.unlock();
				}
			}
		}.start();

		Thread.sleep(1500);
		System.out.println("Main Unlock");
		MUTEX.unlock();
	}

}
