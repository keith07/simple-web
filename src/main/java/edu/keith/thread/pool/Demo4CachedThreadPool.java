package edu.keith.thread.pool;

import java.util.concurrent.*;

/**
 * Created by keith on 2016/5/8 0008.
 */
public class Demo4CachedThreadPool {
	private static ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
	private static ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
	private static ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
	private static ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Callable<Integer> task;
		Future<Integer>[] futures = new Future[10];
		for(int i=0;i<10;i++) {
			task = new MyTask();
			futures[i] = fixedExecutorService.submit(task);
		}
		Thread.sleep(1000);
		System.out.println(futures[2].cancel(false));
		for(int i=0;i<10;i++) {
			if(!futures[i].isCancelled())
				System.out.println(i+":"+futures[i].get());
		}

	}
}

class MyTask implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
				Thread.sleep(10000);
		return (int) (Math.random() * 100);
	}
}
