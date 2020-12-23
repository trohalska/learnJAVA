package threads;

public class SeveralThrJoin {

    static class Worker extends  Thread {
        private String message;
        private int time;

        public Worker(String message, int time) {
            this.message = message;
            this.time = time;
        }

        public void run() {
            for (int j = 0; j < 3; j++) {
                System.out.println(message);
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];

        for (int j = 0; j < threads.length; j++) {
            threads[j] = new Worker("Mes" + j, 333 * (j + 1));
        }
        /** start */
        for (Thread t : threads) {
            t.start();
        }
        Thread.sleep(3000);

        /** join */
        for (Thread t : threads) {
            t.join();
        }
    }
}
