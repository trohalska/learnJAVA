package threadSync;

public class SyncStatic {
    static boolean flag; // false

//    static synchronized void m(boolean f) {   // variant 1 monitor(mutex) -> Test6.class
    static void m(boolean f) {
        synchronized (SyncStatic.class) {       // variant 2
            flag = f;

            try { Thread.sleep(333); }
            catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println(flag + " == " + f); // x++
        }

    }

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                while (true) {
                    m(true);

                    try { sleep(1); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    m(false);

                    try { sleep(1); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.start();

    }

}
