package concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin - how to find max in array
 */
public class ForkJoinTest {

    private static Random random = new Random();
    private static final int N = 100;
    private static int[] array = new int[N];
    private static int THRESHOLD = 10;
    
    static {
    	for (int j = 0; j < N; j++) {
    		array[j] = random.nextInt();
    	}
    }

    static class FindMaxTask extends RecursiveTask<Integer> {
        private int start;
        private int end;

        public FindMaxTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * while array.length >= threshold wi break array in two parts
         * and recursevly find max in each part
         * @return
         */
        @Override
        protected Integer compute() {
            int length = end - start;
            if (length < THRESHOLD) {
                return computeDirectly();
            }

            System.out.println(Thread.currentThread().getName());
            int offset = length / 2;

            FindMaxTask left = new FindMaxTask(start, start + offset);
            left.fork();
            FindMaxTask right = new FindMaxTask(start + offset, end);

            return Math.max(right.compute(), left.join());
        }

        private Integer computeDirectly() {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int max = new ForkJoinPool().invoke(new FindMaxTask(0, N));
        System.out.println("max = " + max);
    }
}
