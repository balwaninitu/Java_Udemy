package Threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		
		//manages thread pool, 2 threads process simultaneously
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable processor = new MessageProcessor(2);
		executor.execute(processor);
		
		Runnable processor2 = new MessageProcessor(3);
		executor.execute(processor2);
		
		Runnable processor3 = new MessageProcessor(4);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(5);
		executor.execute(processor4);
		
		executor.shutdown();//rejects any new task from being submitted.Gracefully shut down the service.
		//executor.shutdownNow();//terminate executor service immediately
		
		//make service wait untill all done
		while(!executor.isTerminated()) {
			//System.out.println("looping");
		}
		//OR can use below to wait
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Submitted all task...");
		
	}

}
