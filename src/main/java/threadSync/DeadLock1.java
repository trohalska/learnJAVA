package threadSync;

/**
 * if put sleep(1) then deadLock situation occures:
 *
 * main has m1 then try to get m2
 * and if sleep(1) is present than
 * child has time to grep m2 and blocks on m1
 * threads are in DEADLOCK
 */
public class DeadLock1 {

	public static void main(String[] args) throws InterruptedException {

		new Thread() {
			public void run() {
				System.out.println("Child starts");
				synchronized ("m2") {
					synchronized ("m1") {

					}
				}
				System.out.println("Child OK");
			}
		}.start();

		synchronized ("m1") {
//			Thread.sleep(1);
			synchronized ("m2") {

			}
		}
		System.out.println("Main Ok");
	}

}
