package ConcurrentConsumerProducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

	public static void main(String[] args) {
		//here is 5 is max capacity of this list, it can change by changing number in bracket
		BlockingQueue<Integer> queQueue = new ArrayBlockingQueue<Integer>(5);
		Thread t1= new Thread(new Producer(queQueue));
		Thread t2= new Thread(new Consumer(queQueue));
		t1.start();
		t2.start();
	}

}
