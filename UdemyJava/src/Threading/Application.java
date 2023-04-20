package Threading;

public class Application {

	public static void main(String[] args) {
		//System.out.println("Starting Thread 1");
		
		/*thread running concurrently along with main
		create instance of thread class in main to run as separate thread
		if main method below run still it get executed first because thread dont wait for it
		to complete but it will go to main method to run, thread can not start more than 
		one it will throw exception, instead create new instance of task class and run another thread*/
       // Task taskRunner = new Task("Thread-A");
       // taskRunner.start();
        //new instance
       // System.out.println("Starting Thread 2");
        //Task taskRunner1 = new Task("Thread-B");
        //taskRunner1.start();
        
        //when implementin interface thread class instance can create
        System.out.println("Starting Thread 1");
        Task taskRunnerA = new Task("Thread-A");
        Thread t1 = new Thread(taskRunnerA);
        t1.start();
        
        System.out.println("Starting Thread 2");
        Task taskRunnerB = new Task("Thread-B");
        Thread t2 = new Thread(taskRunnerB);
        t2.start();
	}
}
/*Thread class implements Runnable which has run() method
run get executed on separate thread not on main thread
-Thread class implements interface Runnable, we can not implements 
interface directly, if we envoke Run() me thod by implementing interface
it wont be concurrent but will be sequential, it needs to be Thread class
for multithreading*/

/*class Task extends Thread{
	//set name of thread
	String name;
	public Task(String name) {
		this.name = name;
	}
	
	public void run() {
		Thread.currentThread().setName(this.name);
		for (int i = 0; i < 1000; i++) {
			//to get to know which thread getting run first we can use get name method to check
			//by using setName method can set name of each thread
			System.out.println("number: "+ i +"-"+Thread.currentThread().getName());
			//make thread sleep for sometime to perform other task
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}*/

//for interface implements we can use method as
class Task implements Runnable{
	//set name of thread
	String name;
	public Task(String name) {
		this.name = name;
	}
	
	public void run() {
		Thread.currentThread().setName(this.name);
		for (int i = 0; i < 1000; i++) {
			//to get to know which thread getting run first we can use get name method to check
			//by using setName method can set name of each thread
			System.out.println("number: "+ i +"-"+Thread.currentThread().getName());
			//make thread sleep for sometime to perform other task
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

