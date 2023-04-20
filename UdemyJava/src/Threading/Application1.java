package Threading;

/*
 * In multithreeading, processor give control to one thread for sometime and then
 * give control to other thread,processor can handle one thread at a time. When threead 
 * share same data then one thread may not complete and other thread will take over control 
 * and there will inconsistency in data
 */

public class Application1 {
	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		
		//sequential
		/*for (int i = 0; i < 100; i++) {
			System.out.println(" sequential :"+sequence.getNext());
		}*/
		
		//threading
		Worker worker1 = new Worker(sequence);
		worker1.start();
		Worker worker2 = new Worker(sequence);
		worker2.start();
	}

}

class Worker extends Thread {
	Sequence sequence;
	//constructor
	public Worker(Sequence sequence) {
		this.sequence=sequence;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
		System.out.println(Thread.currentThread().getName()+" got value: "+sequence.getNext());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
