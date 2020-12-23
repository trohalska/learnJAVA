package threads;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Child();
        t.start();
        t.join();
        System.out.println("Main stopped!");
    }

    static class Child extends Thread {
        public void run() {
            for (int j = 0; j < 5; j++) {
                System.out.println("Child");
                try {
                    sleep(333);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
