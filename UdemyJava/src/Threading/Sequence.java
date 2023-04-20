package Threading;

public class Sequence {
	
	private int value=0;
	
	//below method when called from main its not thread safe
	//public int getNext() {
		/*below step in not thread safe because thread may stop after value 
		incremental and control can pass to other so one thread may see value 3
		and other thread will also see same value different, to make this step thread
		safe there is concept of automacy which means do all steps or do nothing but not do in
		parts and is called synchronize, it means no control given to other untill code under
		the block run, print line is not under synchronized so print can be any but
		there will no repetition of number*/
		//value++;
		//return value;
		
		
	//}
	/*public int getNext(){
	//synchronization
	synchronized(this) {
		value++;
		return value;
		
	}
	}*/
	
	//improvised, method is given synchronized keyword, it will lock thread untill it dont complete that method
	/*
	 * If synchronized keyword is there, no other thread interleave until whole synchronized block
	 * get complete.
	 */
	public synchronized int getNext(){
		//synchronization
		synchronized(this) {
			value++;
			return value;
			
		}
		}
}


