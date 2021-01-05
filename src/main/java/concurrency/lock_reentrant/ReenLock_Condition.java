package concurrency.lock_reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Condition

/**
 * main thread creates child and lock mutex
 * child thread wait for unlocking
 * then condition.await() -> main thread starts waiting and release mutex
 * child locks mutex and proceed
 * after condition.signal() -> main thread awakes from waiting
 * main thread waits for unlocking and proceed
 */
public class ReenLock_Condition {
	private static final Lock MUTEX = new ReentrantLock();
	private static final Condition CONDITION = MUTEX.newCondition();

	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			public void run() {
				try {
					MUTEX.lock();
					System.out.println("Child");

					sleep(1000);

					CONDITION.signal();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} finally {
					MUTEX.unlock();
				}
			}
		}.start();

		try {
			MUTEX.lock();

			Thread.sleep(1000);

			System.out.println("Main try to await");
			CONDITION.await();
			System.out.println("Main has been signaled");

		} finally {
			MUTEX.unlock();
		}
	}

}
