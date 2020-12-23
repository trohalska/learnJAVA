package threads;

public class StartInsideThreadClass extends Thread {
	
	public StartInsideThreadClass() {
		start();
	}
	
	public void run() {
		while (true) {
			System.out.println("Child");
			
			try {
				sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		/** start from inside Thread class main.method */
//		new StartFromThreadClass().start();

		/** start from the constructor of Thread class */
//		new StartFromThreadClass();

		/** start in anonymous class */
		new Thread() {
			public void run() {
				while (true) {
					System.out.println(getName());
					try { sleep(333); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}.start();

		new Thread() {
			public void run() {
				while (true) {
					System.out.println(getName());
					try { sleep(555); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}.start();
	}

}
