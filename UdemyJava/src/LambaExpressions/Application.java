package LambaExpressions;

public class Application {

	public static void main(String[] args) {
		Human tom = new Human();
		//tom.walk();
		//walker1(tom);//this is polymorphism as same method use by two class
		
		Robot wale = new Robot();
		//wale.walk();
		//walker1(wale);
		
		/*
		 * Anonymous class is creating class definition on 
		 * the fly, instead creating instance of class like human robot
		 * can create brand new object, this is not tied to any class,
		 * we are creating on fly
		 * anaonymous class was there untill java 7 then after introducing
		 * java 8, lambda function came
		 * 
		 */
		walker1(new Walkable(){

			@Override
			public void walk() {
				System.out.println("custom object walking..");
				
			}
			
		});
		
		/*convert anonymous class(untill java 7) to lambda(java 8 onwards)
		 * for lambda no need any implemented method like walk, only 
		 * mandatory part for lambda is arrow and parenthesis () -> and steps to be
		 * executed like println stmnt, multiple steps can wrapped in 
		 * curly braces, for one line code curly braces no need.
		 */
		walker1( () ->{
			System.out.println("lambda object walking...");
			System.out.println("lambda object tripped...");	
		});
		/*lambda expression can be given a name or assign a variable
		 * and variable must have a type of functional interface(Interface which
		 * has only one abstract method if it has more than one method
		 * it is no longer functional interface)
		 * 
		 * Lambda interface are blocks of code used to implement 
		 * a method define by functional interface
		 * 
		 * Benefit of using lambda is not only less code but it allow
		 * us to dissassociate a set of instructions from an object, because 
		 * traditinally OOP is all about object, so if we need to run any functionality
		 * that functionality need to be part of object, part of class so lambda 
		 * breaks that association, java 8 has plenty of functional interfaces
		 * which we can use in application
		 * 
		 * java 8 is about switching from an object to set of functinality using
		 * lambda expression, reason behind this switch is to compete
		 * with other programming language in processing data in bulk amount
		 */
		
		ALambdaInterface aBlockOfCode = () ->{
			System.out.println("lambda object walking...");
			System.out.println("lambda object tripped...");	
		};
		
		/*if walkable interface has more than one method, lambda expression
		 * still works
		 */
		
		Walkable aBlockOfCode1 = () ->{
			System.out.println("lambda object Walkable...");
			System.out.println("lambda object Walkable tripped...");	
		};
		
		/*
		 * pass variable of lambda expression to walker class
		 * only when variable is type of functional interface which is walkable
		 */
		walker1(aBlockOfCode1);
	}
	
	public static void walker(Human human) {
		human.walk();
	}
	public static void walker1(Walkable walkableEntity) {
		walkableEntity.walk();
		//convert sayHello method to lambda expression
		ALambdaInterface helloVar = () ->System.out.println("Hello there");
		helloVar.someMethod();
		//convert sum method to lambda expression
		//created new functional interface calculate which return int
		Calculate sumVar = (a,b) -> a+b;
		System.out.println(sumVar.compute(4,5));
		
		Calculate nonZeroDivideVar = (a,b) -> {
			if(a==0) {
				return 0;
			};
			return a/b;
		};
		System.out.println(nonZeroDivideVar.compute(25,5));
		
		
		Reverse reverseVar = (s) -> {
			String result = "";
			for (int i = s.length()-1; i>=0; i--) {
				result = result + s.charAt(i);
				
			}
			return result;
			
		};
		System.out.println(reverseVar.reverseString("vehicle"));
		
		//can use generic functional interface
		MyGeneric<String> reverseVar1 = (s) -> {
			String result = "";
			for (int i = s.length()-1; i>=0; i--) {
				result = result + s.charAt(i);
				
			}
			return result;
			
		};
		System.out.println(reverseVar1.work("michael"));
		
		Factorial factorialVar = (num) ->{
			int result =1;
			for (int i = 1; i <=num; i++) {
				result = i*result;
			}
			return result;
		};
		System.out.println(factorialVar.findFactorial(10));
		
		MyGeneric<Integer>  factorialVar1 = (num) ->{
			int result =1;
			for (int i = 1; i <=num; i++) {
				result = i*result;
			}
			return result;
		};
		System.out.println(factorialVar1.work(5));
	};
	
	public void sayHello() {
		System.out.println("Hello there");
	}
	
	public int sum(int arg1, int arg2) {
		return arg1 + arg2;
	}
	
	public int nonZeroDivide(int arg1, int arg2) {
		if(arg1==0) {
			return 0;
		}
		return arg1/arg2;
	}
	
	public String reverse(String str) {
		String result = "";
		for (int i = str.length()-1; i>=0; i--) {
			result = result + str.charAt(i);
			
		}
		return result;
	}
	
	public int factorial(int num) {
		int result =1;
		for (int i = 1; i <=num; i++) {
			result = i*result;
		}
		return result;
	}
	
	

}
