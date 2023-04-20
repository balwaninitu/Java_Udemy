package client1;

import java.util.ArrayList;
import java.util.List;
//generics
public class Application  {

	public static void main(String[] args) {
		
       Object myObj = new Object();
       String myVar = "hello";
       //we can assign one obj variable to other and its called polymorphism
       myObj = myVar;
       
       Employee emp = new Employee();
       Accountant acc = new Accountant();
       //polymorphism, employee id parent class of accountant
       emp = acc;
       
       ArrayList<Employee> employees = new ArrayList<Employee>();
       employees.add(new Employee());
       ArrayList<Accountant> accountants = new ArrayList<>();
       accountants.add(new Accountant());
       //in generics below polyphormism is not possible, it allowed in only objects
       //employee is parent class of accountant, arraylist is generics 
      // employees = accountants;
       
       //generics provide type safety hence polymorphism not allowed but they do 
       //provide limited flexibility in wild card where we can assign as below
       //employees1 is wild card , it has unknown value
       ArrayList<?> employees1 = new ArrayList<>();
       ArrayList<Accountant> accountants1 = new ArrayList<>();
       employees1 = accountants1;
       
       //there is one more fact, in generics if we mentioned only children of parent class 
       //are allowed then it work
       //if class change to interface it will still works
       //upper bound - means all children(lower bound) along with parent class employee(upper bound) are allowed
       ArrayList<? extends Employee> employees2 = new ArrayList<>();
       ArrayList<Accountant> accountants2 = new ArrayList<>();
       employees2 = accountants2;
       
       //lower bound - means only parent allowed , since this class doesnt have parent it will not allowed 
       //but if we change to object then it will aloowed
       ArrayList<? super Employee> employees3 = new ArrayList<>();
       //ArrayList<Accountant> accountants3 = new ArrayList<>();
       //change to object
       ArrayList<Object> accountants3 = new ArrayList<>();
       employees3 = accountants3;
       makeEmpWork(employees);
       makeEmpWork1(accountants);
      // makeEmpWork2(accountants);
       
	}
	
	public static void makeEmpWork(List<Employee> employees) {
		for(Employee emp:employees) {
			emp.work();
		}
	}
	public static void makeEmpWork1(List<? extends Employee> employees) {
		for(Employee emp:employees) {
			emp.work();
		}
	}
	
	//if work method is not in parent(employee) but only in child(accountant)
	//we can access it by down cas as below
	/*
	 * public static void makeEmpWork2(List<? extends Employee> employees) {
	 * for(Accountant emp:(ArrayList<Accountant> employees) { emp.work(); } }
	 */
	
	

}
