package threadSync;

public class DeadLock2 {
	/** DeadLock3 - thread waits forever
	 * it can be awoken from inside, or wild awakening */
	public static void main(String[] args) throws InterruptedException {
		synchronized ("monitor") {
			"monitor".wait();
		}
	}

	/** DeadLock2 - thread waits itself to finish */
	public static void main2(String[] args) throws InterruptedException {
		Thread.currentThread().join();
	}

}
