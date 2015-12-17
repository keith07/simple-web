package edu.keith.demo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RunnableCallable {
	
	class SimpleBean{
		int i = 0;
		
		public String toString(){
			return "simpleBean:i="+i;
		}
	}

	public static void main(String args[]) throws InterruptedException, ExecutionException{
		RunnableCallable rc = new RunnableCallable();
		SimpleBean bean = rc.new SimpleBean();
		FutureTask<SimpleBean> ft1 = new FutureTask<SimpleBean>(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				bean.i = 10;
			}
			
		}, bean);
		
		Thread t1 = new Thread(ft1);
		t1.start();
		System.out.println(ft1.get());
		FutureTask<Integer> ft2 = new FutureTask<Integer>(new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return 5*2;
			}
			
		});
		Thread t2 = new Thread(ft2);
		t2.start();
		System.out.println(ft2.get());
		
		Future<Integer> f = new ExecutorService(){

			@Override
			public void execute(Runnable command) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void shutdown() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public List<Runnable> shutdownNow() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isShutdown() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isTerminated() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean awaitTermination(long timeout, TimeUnit unit)
					throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public <T> Future<T> submit(Callable<T> task) {
				// TODO Auto-generated method stub
				return new Future<T>(){

					@Override
					public boolean cancel(boolean mayInterruptIfRunning) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean isCancelled() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean isDone() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public T get() throws InterruptedException,
							ExecutionException {
						// TODO Auto-generated method stub
						try {
							return task.call();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}

					@Override
					public T get(long timeout, TimeUnit unit)
							throws InterruptedException, ExecutionException,
							TimeoutException {
						// TODO Auto-generated method stub
						return null;
					}
					
				};
			}

			@Override
			public <T> Future<T> submit(Runnable task, T result) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Future<?> submit(Runnable task) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> List<Future<T>> invokeAll(
					Collection<? extends Callable<T>> tasks)
					throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> List<Future<T>> invokeAll(
					Collection<? extends Callable<T>> tasks, long timeout,
					TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
					throws InterruptedException, ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
					long timeout, TimeUnit unit) throws InterruptedException,
					ExecutionException, TimeoutException {
				// TODO Auto-generated method stub
				return null;
			}
			
		}.submit(new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return 2*5;
			}
			
		});
		
		System.out.println(f.get());
	}
}
