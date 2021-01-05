package concurrency.synchronizers;

import java.util.concurrent.Exchanger;

/**
 * if thread interrupted while waiting exchange - will be exception
 * this is an example OF THIS
 */
public class ExchangerDemo2 {

	private static Exchanger<String> exch = new Exchanger<>();

	private static class Task extends Thread {
		private String mes;
		public Task(String mes) { this.mes = mes; }

		public void run() {
			try {
				System.err.println(getName()
						+ " wants to exchange: message --> " + mes);
				sleep(1000);

				mes = exch.exchange(mes);

				System.out.println(getName()
						+ " exchange was successful: message --> " + mes);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Thread t = new Task("AAAAAAAAAAAA");
		t.start();
		Thread.sleep(2000);
		
		t.interrupt();
	}

}