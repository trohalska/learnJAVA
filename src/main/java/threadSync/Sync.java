package threadSync;

public class Sync {

    boolean flag; // false

    // without synchronized - problem!

//    synchronized void m(boolean f) {  // version 1
    void m(boolean f) { // this         // version 2
        synchronized (this) {
            this.flag = f;

            try { Thread.sleep(333); }
            catch (InterruptedException e) { e.printStackTrace(); }

            System.out.println(flag + " == " + f);
        }
    }

    public static void main(String[] args) {
        Sync t = new Sync();

        new Thread() {
            public void run() {
                while (true) {
                    t.m(true);

                    try { sleep(1); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    t.m(false);

                    try { sleep(1); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.start();

    }
}
