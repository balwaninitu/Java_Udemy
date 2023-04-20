package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;


/*
 * Producer add questions to list and consumers remove questions from 
 * the list, due to wait and notify right communication happening as they are
 * using same resource of queList. one thread is adding and other thread removing
 * once it get answered.wait and notify is primitive method better user concurrent
 * methods and other suitable data structure.there is concurrent friedly arraylist in java 
 * concurrent package so no need to use wait and notify
 */
public class Application {

	public static void main(String[] args) {
	
		List<Integer> queList = new ArrayList<Integer>();
		
		Thread t1 = new Thread(new Producer(queList));
		Thread t2 = new Thread(new Consumer(queList));
		
		t1.start();
		t2.start();

	}

}
