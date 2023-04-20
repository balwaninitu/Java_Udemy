package Threadpool;

public class MessageProcessor implements Runnable {
	
	private int message;
	
	public MessageProcessor(int message) {
		this.message = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"[Received] Message ="+message);
		respondToMessage();//make thread sleep to simukate doing some work
		System.out.println(Thread.currentThread().getName()+"(DONE) Processing Message "+message);
	}

	private void respondToMessage() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		System.out.println("Unable to process message "+ message);
	}
		
	}
	

}
