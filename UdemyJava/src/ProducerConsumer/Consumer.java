package ProducerConsumer;

import java.util.List;

//here question get asked
public class Consumer implements Runnable {
	
	List<Integer> queList = null;
	
	//constructor
	public Consumer(List<Integer> queList) {
		this.queList= queList;
	}
	public void answerQue() throws InterruptedException {
		synchronized(queList) {
			while(queList.isEmpty()) {
				System.out.println("No Questions to Answers...Waiting for producer to get questions");
				queList.wait();
			}
			
		}
		synchronized(queList) {
			Thread.sleep(5000);
			System.out.println("Answered Question: "+queList.remove(0));
			//notify will wake up thread once question will come
			queList.notify();
			
		}
	}

	@Override 
	public void run() {
		while(true) {
			try {
				answerQue();
			} catch (InterruptedException e) {
			}	
		}
		
	}

}
