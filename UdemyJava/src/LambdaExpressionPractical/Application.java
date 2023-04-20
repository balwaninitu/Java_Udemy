package LambdaExpressionPractical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {

	public static void main(String[] args) {
		
		List<Car> cars = Arrays.asList(
				new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700),
				new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200),
				new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300),
				new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500)
				);
		//use function interface from java
		Function<Car, String> priceAndColor = (c) -> "price = "+ c.getPrice() + " color = "+c.getColor();
		String Stringcar = priceAndColor.apply(cars.get(0));
		System.out.println("Printing from function interface java");
		System.out.println(Stringcar);
		
		
		
		
		
		//printCarsPriceRange(cars,18000,22000);
		//printCarByColor(cars, "Red");
		System.out.println("Printing cars of given Price range");
		//create anonymous for above two method
		 printCars(cars, new CarCondition() {

			@Override
			public boolean test(Car c) {
				return c.getPrice() >= 18000 && c.getPrice() <= 22000;
			}		
	});
			System.out.println("Printing cars of given Color");
		 printCars(cars, new CarCondition() {

				@Override
				public boolean test(Car c) {
					return c.getColor().equals("White");
				}		
		});
		 //create lambda for above two method
		 printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
		 printCars(cars, (c) -> c.getColor().equals("Blue"));
		 
		 //using generic interface
		 System.out.println("Printing cars of using Generic interface");
		 printCars1(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
		 printCars1(cars, (c) -> c.getColor().equals("Blue"));
		 
		//using predicate interface
		 System.out.println("Printing cars of using Predicate interface");
		 printCars2(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
		 printCars2(cars, (c) -> c.getColor().equals("White"));

	}
	
	public static void printCars(List<Car> cars,CarCondition condition ) {
		for (Car c : cars) {
			if(condition.test(c)) {
				c.printCar();
			}
		}
	}
	//using generic interface - Condition
	public static void printCars1(List<Car> cars,Condition<Car> condition ) {
		for (Car c : cars) {
			if(condition.test1(c)) {
				c.printCar();
			}
		}
	}
	
	//using available java interface 
		public static void printCars2(List<Car> cars,Predicate<Car> predicate ) {
			for (Car c : cars) {
				if(predicate.test(c)) {
					c.printCar();
				}
			}
		}
	//no need this method when using lambda
	public static void printCarsPriceRange(List<Car> cars, int low, int high) {
		for(Car c: cars) {
			if(low <= c.getPrice() && c.getPrice() <= high) {
				c.printCar();
			}
		}
	}
	//no need this method when using lambda
	public static void printCarByColor(List<Car> cars, String color) {
		for(Car c: cars) {
			if(c.getColor().equals(color)) {
				c.printCar();
			}
		}
	}

}
