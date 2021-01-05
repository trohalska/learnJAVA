package concurrency.atomic.counter;

/**
 * complete UNSAFE counter for threads manipulation
 */
public class OrdinalCounter implements Counter {
	
	private int x;

	@Override
	public void increment() {
		++x; // x++
	}

	@Override
	public void decrement() {
		--x;
	}

	@Override
	public int get() {
		return x;
	}

}
