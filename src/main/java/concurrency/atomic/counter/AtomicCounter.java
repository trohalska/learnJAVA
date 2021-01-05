package concurrency.atomic.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {
	
	private AtomicInteger x = new AtomicInteger();

	@Override
	public void increment() {
		x.incrementAndGet();
	}

	@Override
	public void decrement() {
		x.decrementAndGet();
	}

	@Override
	public int get() {
		return x.get();
	}

}
