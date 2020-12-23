package threadSync;

/**
 * used string-monitor (BAD practice!!!!!)
 * (print info about main thread)
 * main thread waits on monitor for him to awake (frees monitor) -> main state WAITING
 * child thread awakes main thread after 1,5seconds by calling notifyAll
 * but still holds monitor and main blocked on monitor, so -> main state BLOCKED
 * child frees monitor and main has it, main leaves it and stops,
 * so after 1mls we can see -> state TERMINATED
 *
 * priority doesn't change anything
 */
public class WaitExample {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();

//		t.setPriority(Thread.MAX_PRIORITY);
		
		new Thread() {
			public void run() {

//				setPriority(Thread.MIN_PRIORITY);

				try { sleep(1500); }
				catch (InterruptedException e) { e.printStackTrace(); }
				
				synchronized ("asdf") {
//					"asdf".notifyAll();

					System.out.println(t.getState());  // waiting
					"asdf".notify();
					
					System.out.println(t.getState());  // blocked
				}
			
				try { Thread.sleep(1); } 
				catch (InterruptedException e) { e.printStackTrace(); }

				synchronized ("asdf") {
					System.out.println(t.getState());  // terminated
				}
			}
		}.start();

		System.out.println("before");
		synchronized ("asdf") {
			"asdf".wait(); // <-- Main thread
		}
		System.out.println("after");
	}

}
