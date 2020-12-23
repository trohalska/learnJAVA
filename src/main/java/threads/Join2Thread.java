package threads;

/**
 * child process interrupted main thread, which join itself
 * also "catch exception" method is uses for return some information
 */
public class Join2Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread();
        new Thread() {
            public void run() {
                try {
                    sleep(1555);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.interrupt();
            }
        }.start();

        System.out.println("before");
        try {
            t.join();
        }  catch (InterruptedException ex) {
            System.out.println("interrupted!");
        }
        System.out.println("after");
    }
}
