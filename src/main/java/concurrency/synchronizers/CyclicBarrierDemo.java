package concurrency.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	private static CyclicBarrier b = new CyclicBarrier(4);

	private static class Task extends Thread {

		private int n;
		public Task(int n) { this.n = n; }

		public void run() {
			try {
				System.err.print(n + " ");
				b.await();
				Thread.sleep(1000);
				System.out.print("\n" + n);
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.print("Creating and starting tasks: ");
		for (int j = 1; j <= 3; j++) {
			new Task(j).start();
		}

		Thread.sleep(1500);
		System.out.print("\nNow all three tasks (3) await fourth: ");
		Thread.sleep(1000);
		new Task(4).start();
	}

}
