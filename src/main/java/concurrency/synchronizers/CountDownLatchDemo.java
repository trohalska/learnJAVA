package concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	
	private static CountDownLatch latch = new CountDownLatch(1);

	private static class Task extends Thread {
		private int n;
		public Task(int n) { this.n = n; }

		public void run() {
			try {
				System.err.print(n + " ");

				latch.await();
				Thread.sleep(1000);

				System.out.println(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.print("Creating and starting tasks: ");

		for (int j = 0; j < 4; j++) {
			new Task(j).start();
		}
		Thread.sleep(1000);
		System.out.println("\nAll the tasks are waiting for a signal.");
		Thread.sleep(1500);
		System.out.println("Give the signal to start work!");
		latch.countDown();
	}

}
