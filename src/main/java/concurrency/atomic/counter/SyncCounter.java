package concurrency.atomic.counter;

/**
 * the SLOWEST but correct counter for threads manipulation
 */
public class SyncCounter implements Counter {
	
	private int x;

	@Override
	public synchronized void increment() {
		++x; 
	}

	@Override
	public synchronized void decrement() {
		--x;
	}

	@Override
	public int get() {
		return x;
	}

}
