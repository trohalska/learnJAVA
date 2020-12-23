package threadSync;

/**
 * all 3 sync blocks have ONE monitor (Test3.class)
 * this is blocked synchronization
 */
public class BlockedSync {
	synchronized void m() {}
	synchronized void m2() {}

	public static void main(String[] args) {
		BlockedSync t = new BlockedSync();
		
		t.m();
		
		t.m2();
		
		synchronized (t) {
			// ...
		}
	}
	
}
