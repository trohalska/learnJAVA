package concurrency.synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	private static Semaphore s = new Semaphore(3);

	private static class Task extends Thread {
		int n;
		public Task(int n) { this.n = n; }

		public void run() {
			try {
				s.acquire();  // get semaphore counter -1
				System.err.println(n + " starts");
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release();
				System.out.println(n + " finished");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Creating and starting tasks.");
		for (int j = 0; j < 15; j++) {
			new Task(j).start();
			Thread.sleep(1);
		}
	}

}