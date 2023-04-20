package ProducerConsumer;

import java.util.List;

//here question get asked
public class Producer implements Runnable {
	
	List<Integer> queList = null;
	final int LIMIT = 5;
	private int queNo;
	
	
	//constructor
	public Producer(List<Integer> queList) {
		this.queList= queList;
	}
	public void readQuestion(int queNo) throws InterruptedException {
		synchronized(queList) {
			while(queList.size() == LIMIT) {
				System.out.println("Questions have piled up..wait for answers");
				queList.wait();
			}
			
		}
		synchronized(queList) {
			System.out.println("New question: "+queNo);
			queList.add(queNo);
			Thread.sleep(100);
			//notify will wake up thread once question will come
			queList.notify();
			
		}
	}

	@Override 
	public void run() {
		while(true) {
			try {
				readQuestion(queNo++);
			} catch (InterruptedException e) {
			}	
		}
		
	}

}
