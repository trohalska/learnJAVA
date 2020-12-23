package threads;

public class MethodsThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.setName("ololo");

        /** normal work: main is closing and child process continue */
//        t.start();
//        System.out.println("Main is stopped!");

        /** wrong, main start to do method of another class and never stops, child process doesn't envolved. */
//        t.run();
//        System.out.println("Main is stopped!");

        Thread m = Thread.currentThread();
        System.out.println(m);
        System.out.println(m.getName());
        System.out.println(m.getState());
        System.out.println(m.getPriority()); // 5
        m.setPriority(Thread.MAX_PRIORITY); // 10
        System.out.println(m.getPriority());
        m.join();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
//                System.out.println("Child thread");
//                System.out.println(this.getName());
                System.out.println(Thread.currentThread().getName()); // for check run method in main
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/**
 * Methods
 *
 * .join()          waits for thread to end
 * .getName()       get thread name
 * .currentThread() get object of influence on thread in thich this method was called
 *
 * .toString()
 * .suspended()
 * .stop()                              stop execution
 * .start()
 * .setUncaughtExceptionHandler(ex)
 * .setPriority()                       define a new priority (highter)
 * .setName()                           define new thread name
 * .setDaemon()
 * .setContextClassLoader()
 * .run()
 * .resume()                            start after stop
 * .join()                              waiting for another thread to finish
 * .isInterrupted()                     check flag of state
 * .isDaemon()                          check if daemon
 * .isAlive()                           if thread is not terminated
 * .interrupt()
 * .getUncaughtExceptionHandler()
 * .getThreadGroup()
 * .getState()                          what state is it
 * .getStackTrace()
 * .getPriority()                       get priority
 * .getName()
 * .getId()
 * .getContextClassLoader()
 * .destroy()
 * .countStackFrames()
 * .checkAccess()
 * .Thread()
 *
 * STATIC METHODS
 *
 * .yield()                             pass this thread's processor time to another process
 * .sleep()                             make pause in thread
 * .setDefaultUncaughtExceptionHandler()
 * .interrupted()                       check state dropping it to false
 * .holdLock()
 * .getDefaultUncaughtExceptionHandler()
 * .getAllStackTarces()
 * .enumerate()
 * .dumpStack()
 * .currentThread()
 * .activeCount()
 *
 * */