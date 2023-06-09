package aggregators;

import java.util.ArrayList;
import java.util.List;
//abstract class probably parent of some other class
//any class which are child(extends) to aggregator will have access to list(numbers)
public abstract class Aggregator {
	
	List<Double> numbers;
	//constructor without value
	public Aggregator(){
		numbers = new ArrayList<Double>();
	}
	//constructor with value
	public Aggregator(List<Double> numbers){
		numbers = new ArrayList<Double>(numbers);
	}
	
	/**
	 * add data to the given collection
	 * 
	 */
	public void add(Double number) {
		numbers.add(number);
	}
	/**
	 * Any class that is a derivative of the abstract class
	 * Aggregator must implement the calculate method.
	 * @return double
	 */
	public abstract double calculate();
	
	public abstract List<Double> getValues();
	
}
