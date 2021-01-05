package concurrency.executors_aka_threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	
	private static class Task implements Callable<String> {

		private String message;
		
		public Task(String message) {
			this.message = message;
		}

		@Override
		public String call() throws Exception {
			Thread.sleep(1000);
			return Thread.currentThread().getName() + " : " + message;
		}
	}

	
	public static void main(String[] args) throws Exception {
		/** in executor 3 treads
		 * will print tree lines per time */
//		ExecutorService es = Executors.newFixedThreadPool(3);

		/** in executor only one tread
		 * will print one line per time*/
//		ExecutorService es = Executors.newSingleThreadExecutor();

		/** in executor not limited amount of treads
		 * will print all lines when all threads are finished */
		ExecutorService es = Executors.newCachedThreadPool();
		
		List<Future<String>> results = new ArrayList<>();

		for (int j = 0; j < 20; j++) {
			Task t = new Task("message " + j);
			Future<String> result = es.submit(t);
			results.add(result);
		}
		es.shutdown();

		for (Future<String> r : results) {
			System.out.println(r.get());
		}
    }
}