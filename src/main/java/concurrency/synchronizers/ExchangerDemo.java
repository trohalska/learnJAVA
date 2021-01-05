package concurrency.synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	private static Exchanger<String> exch = new Exchanger<>();

	private static class Task extends Thread {
		private String mes;
		public Task(String mes) { this.mes = mes; }

		public void run() {
			try {
				System.err.println(getName()
						+ " wants to exchange: message --> " + mes);

				sleep(1000);

				mes = exch.exchange(mes);  /// changing messages

				System.out.println(getName()
						+ " exchange was successful: message --> " + mes);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Task("AAAAAAAAAAAA").start();
		new Task("@@@").start();

	}

}