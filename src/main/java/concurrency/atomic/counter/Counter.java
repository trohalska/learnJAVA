package concurrency.atomic.counter;

public interface Counter {
	
	void increment();

	void decrement();
	
	int get();

}
