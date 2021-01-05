package concurrency.atomic;

import concurrency.atomic.counter.*;

public class CounterDemo {
	
	private static final int N = 5_000_000;
	
	static void runCounter(Class<? extends Counter> clazz) throws ReflectiveOperationException, InterruptedException {
		Counter c = clazz.newInstance();
		Thread t1 = new Thread(new Worker(c, true, N));
		Thread t2 = new Thread(new Worker(c, false, N));
		
		long before = System.currentTimeMillis();
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		long after = System.currentTimeMillis();
		
		long time = after - before;
	
		System.out.println(clazz.getSimpleName() + " [" +
				time + "]: " + c.get());
	}
	
	
	private static class Worker implements Runnable {
		Counter c;
		boolean increment;
		int count;

		public Worker(Counter c, boolean increment, int count) {
			this.c = c;
			this.increment = increment;
			this.count = count;
		}
	
		@Override
		public void run() {
			if (increment) {
				for (int j = 0; j < N; j++) {
					c.increment();
				}
			} else {
				for (int j = 0; j < N; j++) {
					c.decrement();
				}
			}
		}

	}
	
	public static void main(String[] args) throws ReflectiveOperationException, InterruptedException {
		while (true) {
//			runCounter(OrdinalCounter.class);  // completely unsafe counter
//			runCounter(SyncCounter.class);     // the slowest correct counter
//			runCounter(LockCounter.class);	   // correct counter using locks
			runCounter(AtomicCounter.class);
			System.out.println("=============");
		}
	}

}
