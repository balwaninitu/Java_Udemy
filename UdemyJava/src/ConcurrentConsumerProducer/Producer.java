package ConcurrentConsumerProducer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	int queNo;
	BlockingQueue<Integer> queQueue;

	public Producer(BlockingQueue<Integer> queQueue) {
		this.queQueue = queQueue;
	}
	
	@Override
	public void run() {
		
		//put and take  is thread safe method and not add and remove
		while(true) {//infinite loop
		try {
			synchronized(this) {
				int nextQue = queNo++;
				System.out.println("Got new question: "+nextQue);
				queQueue.put(nextQue);
			}
		} catch (InterruptedException e) {
			
		}
		}
	}
	

}
