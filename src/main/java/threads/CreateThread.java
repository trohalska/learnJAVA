package threads;

public class CreateThread {

    public static void main(String[] args) {
//		MyThread t = new MyThread();
        Thread t = new MyThread();
        t.start();
        System.out.println("Main is stopped!");

        Thread t1 = new Thread(new MyThread2()); // this method is better
        t1.start();
    }

    /**
     * first method to create thread (extends Thread)
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
//                System.out.println("Child thread");
                System.out.println(this.getName());
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * second method to create thread (implements Runnable)
     * this way is better - here we can also write "extends"
     */
    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Child runnable");
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




