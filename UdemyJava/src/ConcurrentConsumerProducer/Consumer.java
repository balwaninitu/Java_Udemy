package ConcurrentConsumerProducer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> queQueue;
	public Consumer(BlockingQueue<Integer> queQueue) {
		this.queQueue = queQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		try {
			Thread.sleep(1000);
			System.out.println("Answered Questions: "+queQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
