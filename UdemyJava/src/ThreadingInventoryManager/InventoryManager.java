package ThreadingInventoryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * Array List is not thread safe because it will make things slow,however
 * vector class all methods are thread safe, so we cant use arraylist in multithread
 * either we need to use word synchronized or use concurrent collection(introduced from java 5)
 * all methods are synchronized
 */
public class InventoryManager {
	//List<Product> soldProductList = new ArrayList<Product>();
	List<Product> soldProductList = new CopyOnWriteArrayList<Product>();
	List<Product> purchasedProductList = new ArrayList<Product>();
	
	public void populateSoldProduct() {
		for (int i = 0; i < 1000; i++) {
			Product prod = new Product(i, "test_product_"+i);
			soldProductList.add(prod);
			System.out.println("Added: "+prod);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void displaySoldProducts() {
		for (Product product : soldProductList) {
			System.out.println("Printing the sold: " +product);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
