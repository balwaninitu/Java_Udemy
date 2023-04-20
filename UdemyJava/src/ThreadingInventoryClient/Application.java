package ThreadingInventoryClient;

import ThreadingInventoryManager.InventoryManager;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager manager = new InventoryManager();
		//anonymous class example
		//Thread 1
		Thread inventoryTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.populateSoldProduct();
				
			}
			
		});
		//Thread 2
		Thread displayTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.displaySoldProducts();;
				
			}
			
		});
		//kick start thread
		inventoryTask.start();
		//increasing thread sleep seconds is primitive way of handling, safe thread method, another way is join
		Thread.sleep(2000);
		/*join means jvm has to wait until inventory task join the main and then display will start, this become sequential
		and not multi thread, printing only happened after added task, sleeping and join wont solve the problem
		*/
		//inventoryTask.join();
		displayTask.start();

	}
	
}
