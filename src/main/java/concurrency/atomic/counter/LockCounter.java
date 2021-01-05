package concurrency.atomic.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * correct counter using locks
 */
public class LockCounter implements Counter {
	
	private static final Lock LOCK = new ReentrantLock();
	
	private int x;

	@Override
	public void increment() {
		try {
			LOCK.lock();
			++x; 
		} finally {
			LOCK.unlock();
		}
	}

	@Override
	public void decrement() {
		try {
			LOCK.lock();
			--x; 
		} finally {
			LOCK.unlock();
		}
	}

	@Override
	public int get() {
		return x;
	}

}
